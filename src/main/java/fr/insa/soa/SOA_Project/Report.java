package fr.insa.soa.SOA_Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Path("report")
public class Report {
	
	@GET
	@Path("/pdf/{coordinates}")
	@Produces("application/pdf")
	public Response ReadPDF(@PathParam("coordinates") String coordinates) {
		String tDir = System.getProperty("java.io.tmpdir"); 
		
		// Create the pdf document
		String pdfFile = tDir + "tmp" + ".pdf"; 
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		
		// Add content to the pdf
		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		try {
			document.add( new Paragraph( "Shortest path report" ) );
			document.add( Chunk.NEWLINE );
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			document.add( new Paragraph( dateFormat.format(date) ) ); // 2016/11/16 12:08:43
			document.add( Chunk.NEWLINE );
			
			// Generate static map image with the coordinates
			String urlPrefix = "http://maps.googleapis.com/maps/api/staticmap?size=400x400&path=";
			String urlCoordinates = "";
			String urlSuffix = "&sensor=false";
			try {
				urlCoordinates = java.net.URLDecoder.decode(coordinates, "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			/*for(GPSPoint point : route.getRoute()){
				urlCoordinates += point.getLat() + "," + point.getLon() + "|";
			}
			if(!urlCoordinates.equals("")){
				urlCoordinates = urlCoordinates.substring(0, urlCoordinates.length()-1);
			}*/
			System.out.println(urlPrefix + urlCoordinates + urlSuffix);
			//http://localhost:8080/SOA_Project/webapi/report/pdf/40.737102,-73.990318%7C40.749825,-73.987963%7C40.752946,-73.987384%7C40.755823,-73.986397
			//40.737102,-73.990318|40.749825,-73.987963|40.752946,-73.987384|40.755823,-73.986397
			
			Image image;
			try {
				image = Image.getInstance(urlPrefix + urlCoordinates + urlSuffix);
				//image = Image.getInstance("http://maps.googleapis.com/maps/api/staticmap?size=400x400&path=40.737102,-73.990318|40.749825,-73.987963|40.752946,-73.987384|40.755823,-73.986397&sensor=false");
				//image.scaleToFit((float)200.0, (float)49.0);
				document.add(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
			document.add( Chunk.NEWLINE );
			
			// Add list of coordinates in text format
			String coordinatesText = "Coordinates:\n";
			Route route = new Route();
			String[] listCoordinates = urlCoordinates.split("[|]");
			for(String c: listCoordinates){
				coordinatesText += c + "\n";
				String[] latlon = c.split(",");
				route.addGPSPoint(Double.parseDouble(latlon[0]), Double.parseDouble(latlon[1]));
			}
			document.add( new Paragraph( coordinatesText ) );
			document.add( Chunk.NEWLINE );
			document.add( new Paragraph( "Distance: " + route.distanceInKm() + " km" ));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		document.close();
		
		// Return the pdf to the web browser
		File file = new File(pdfFile);
		//File file = new File("C:/Users/Alexis Zamar/Documents/INSA/4IR_1617.pdf");
		ResponseBuilder response = Response.ok((Object) file);
	    response.header("Content-Disposition",  "filename=restfile.pdf");
	    
	    return response.build();
	}
	
	@GET
	@Path("/route")
	@Produces(MediaType.APPLICATION_JSON)
	public Route getRoute() {
		//40.737102,-73.990318|40.749825,-73.987963|40.752946,-73.987384|40.755823,-73.986397
		Route route = new Route();
		route.addGPSPoint(40.737102, -73.990318);
		route.addGPSPoint(40.749825, -73.987963);
		route.addGPSPoint(40.752946, -73.987384);
		route.addGPSPoint(40.755823, -73.986397);
		return route;
	}
}

