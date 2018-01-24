<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
    <!--  this is a test to include a map from MapBox--> 
    <script src='https://api.mapbox.com/mapbox-gl-js/v0.42.0/mapbox-gl.js'></script>
<link href='https://api.mapbox.com/mapbox-gl-js/v0.42.0/mapbox-gl.css' rel='stylesheet' />
    
    
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Light Bootstrap Dashboard by Creative Tim</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="assets/css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
    
    <!-- Multi-menu map -->
      <meta charset='utf-8' />
        <title>Change a map's style</title>
        <meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />
        <script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.43.0/mapbox-gl.js'></script>
        <link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.43.0/mapbox-gl.css' rel='stylesheet' />
        <style>
            body { margin:0; padding:0; }
            #map { position:absolute; top:0; bottom:0; width:100%; }
        </style>
    
        <title>Display map navigation controls</title>
    <meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />
    <script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.43.0/mapbox-gl.js'></script>
    <link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.43.0/mapbox-gl.css' rel='stylesheet' />
    <style>
        body { margin:0; padding:0; }
        #map { position:absolute; top:0; bottom:0; width:100%; }
    </style>
    
        <title>Get coordinates of the mouse pointer</title>
    <meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />
    <script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.43.0/mapbox-gl.js'></script>
    <link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.43.0/mapbox-gl.css' rel='stylesheet' />
    <style>
        body { margin:0; padding:0; }
        #map { position:absolute; top:0; bottom:0; width:100%; }
    </style>
    
        <title>Add a GeoJSON line</title>
    <meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />
    <script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.43.0/mapbox-gl.js'></script>
    <link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.43.0/mapbox-gl.css' rel='stylesheet' />
    <style>
        body { margin:0; padding:0; }
        #map { position:absolute; top:0; bottom:0; width:100%; }
    </style>

</head>
<body>

<div class="wrapper">
    <%@ include file="sidebar.jsp" %>
        
        
    <div class="main-panel">
		<nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Maps</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-dashboard"></i>
								<p class="hidden-lg hidden-md">Dashboard</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-globe"></i>
                                    <b class="caret hidden-sm hidden-xs"></b>
                                    <span class="notification hidden-sm hidden-xs">5</span>
									<p class="hidden-lg hidden-md">
										5 Notifications
										<b class="caret"></b>
									</p>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                              </ul>
                        </li>
                        <li>
                           <a href="">
                                <i class="fa fa-search"></i>
								<p class="hidden-lg hidden-md">Search</p>
                            </a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                           <a href="">
                               <p>Account</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <p>
										Dropdown
										<b class="caret"></b>
									</p>

                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                              </ul>
                        </li>
                        <li>
                            <a href="#">
                                <p>Log out</p>
                            </a>
                        </li>
						<li class="separator hidden-lg hidden-md"></li>
                    </ul>
                </div>
            </div>
        </nav>

        
        <style>
                                #menu {
                                    position: absolute;
                                    top: 0; 
                                    left: 0 ;
                                    background: #000;
                                    padding: 10px;
                                    font-family: 'Open Sans', sans-serif;
                                    z-index: 10000; 
                                    opacity: 0.7; 
                                }
                                        
                                    /* to display coordinates*/    
                                #info {
                                    display: block;
                                    position: relative;
                                    margin: 0px auto;
                                    width: 50%;
                                    padding: 10px;
                                    border: none;
                                    border-radius: 3px;
                                    font-size: 12px;
                                    text-align: center;
                                    color: #222;
                                    background: #fff;
                                    opacity: 0.8;
                                    z-index: 1000;
                                }
                                        
                                #info_click {
                                    display: block;
                                    position: relative;
                                    margin: 0px auto;
                                    width: 50%;
                                    padding: 10px;
                                    border: none;
                                    border-radius: 3px;
                                    font-size: 12px;
                                    text-align: center;
                                    color: #222;
                                    background: pink;
                                    opacity: 0.8;
                                        z-index: 1000
                                }

        </style>
                            
                            <div id='map'></div>
        
                            <pre id='info'></pre>
                            <div id='menu'>
                                <input id='basic' type='radio' name='rtoggle' value='basic' checked='checked'>
                                <label for='basic'>basic</label>
                                <input id='streets' type='radio' name='rtoggle' value='streets'>
                                <label for='streets'>streets</label>
                                <input id='bright' type='radio' name='rtoggle' value='bright'>
                                <label for='bright'>bright</label>
                                <input id='light' type='radio' name='rtoggle' value='light'>
                                <label for='light'>light</label>
                                <input id='dark' type='radio' name='rtoggle' value='dark'>
                                <label for='dark'>dark</label>
                                <input id='satellite' type='radio' name='rtoggle' value='satellite'>
                                <label for='satellite'>satellite</label>
                                <div > 
                                    <button type="button" id="buttonCalculateDistance" class="btn btn-info" onclick="location.href='#';" >Calculate distance</button>
                                </div>
                            </div>
                            <pre id='info_click'> Select your origin and destination. </pre>
        
                           
        
                        <script>
                            
                            mapboxgl.accessToken = 'pk.eyJ1Ijoib2JhZGFvdWkiLCJhIjoiY2pjaXJld3B6MDg0ZzJ3bHh1NXgyYWc5eCJ9.5WB96eoC4E7TDB5P8ofsQw';
                            var map = new mapboxgl.Map({
                                container: 'map',
                                style: 'mapbox://styles/mapbox/basic-v9',
                                zoom: 2,
                                center: [-120, 50]
                            });

                            var layerList = document.getElementById('menu');
                            var inputs = layerList.getElementsByTagName('input');

                            function switchLayer(layer) {
                                var layerId = layer.target.id;
                                map.setStyle('mapbox://styles/mapbox/' + layerId + '-v9');
                            }

                            for (var i = 0; i < inputs.length; i++) {
                                inputs[i].onclick = switchLayer;
                            }
                                
                                // add zoom menu            

                                // Add zoom and rotation controls to the map.
                                map.addControl(new mapboxgl.NavigationControl());
                                
                                //show coordinates 
                                map.on('mousemove', function (e) {
                                    document.getElementById('info').innerHTML =
                                        // e.point is the x, y coordinates of the mousemove event relative
                                        // to the top-left corner of the map
                                        JSON.stringify(e.point) + '<br />' +
                                        // e.lngLat is the longitude, latitude geographical position of the event
                                        JSON.stringify(e.lngLat);
                                        });
                                
                                // test to have coords in a variable
                                var coordinates1;
                                var coordinates2; 
                                var long1; 
                                var long2; 
                                var lat1; 
                                var lat2; 
                                var flip=false; 
                                var deleteLayerLine = false; 
                                var id = 0; 
                                
                       /*             var layers = map.getStyle().layers;
                                    // Find the index of the first symbol layer in the map style
                                    var firstSymbolId;
                                    for (var i = 0; i < layers.length; i++) {
                                        if (layers[i].type === 'symbol') {
                                            firstSymbolId = layers[i].id;
                                            break;
                                        }
                                    }*/

                                         map.on('click', function(e){ 

                                             if (flip==false){ 
                                                 coordinates1 = JSON.stringify(e.point) + '<br />' +
                                                // e.lngLat is the longitude, latitude geographical position of the event
                                                JSON.stringify(e.lngLat);
                                                 long1= e.lngLat.lng// JSON.stringify(e.lngLat).substr(7, 17); 
                                                 lat1= e.lngLat.lat //JSON.stringify(e.lngLat).substr(32, 48);
                                                 flip=true; 
                                                 
                                                 
                                                 var elementExists = map.getLayer('points'+(id-1));
                                                 if ( elementExists !=null) {
                                                     
                                                    console.log("coucou " + elementExists.id  + " " + id ); 

                                                     
                                                    map.removeLayer("points"+(id-1)); 
                                                 }
                                                 
                                                id++; 

                                                                                                  
                                                  map.addLayer({
                                                    "id": "points"+id,
                                                    "type": "symbol",
                                                    "source": {
                                                        "type": "geojson",
                                                        "data": {
                                                            "type": "FeatureCollection",
                                                            "features": [{
                                                                "type": "Feature",
                                                                "geometry": {
                                                                    "type": "Point",
                                                                    "coordinates": [long1, lat1]
                                                                },
                                                                "properties": {
                                                                    "title": "FROM",
                                                                    "icon": "monument"
                                                                }
                                                            }]
                                                        }
                                                    },
                                                    "layout": {
                                                        "icon-image": "{icon}-15",
                                                        "text-field": "{title}",
                                                        "text-font": ["Open Sans Semibold", "Arial Unicode MS Bold"],
                                                        "text-offset": [0, 0.6],
                                                        "text-anchor": "top"
                                                    }
                                                });
                                         


                                             }
                                            else { 
                                            coordinates2 = JSON.stringify(e.point) + '<br />' +
                                                // e.lngLat is the longitude, latitude geographical position of the event
                                                JSON.stringify(e.lngLat);



                                                long2=  e.lngLat.lng  ; //JSON.stringify(e.lngLat).substr(7, 17); 
                                                 lat2= e.lngLat.lat ; //JSON.stringify(e.lngLat).substr(32, 48);
                                                 flip= false;
                                              

                                                var elementExists = map.getLayer('points'+(id-1)); 
                                                 if ( elementExists !=null) {
                                                     
                                                 console.log("hello " + elementExists.id  + " " + id ); 

                                                    map.removeLayer("points"+(id-1)); 
                                                 }
                                                   id++; 

                                                
                                               map.addLayer({
                                                    "id": "points"+id,
                                                    "type": "symbol",
                                                    "source": {
                                                        "type": "geojson",
                                                        "data": {
                                                            "type": "FeatureCollection",
                                                            "features": [{
                                                                "type": "Feature",
                                                                "geometry": {
                                                                    "type": "Point",
                                                                    "coordinates": [long2, lat2]
                                                                },
                                                                "properties": {
                                                                    "title": "TO",
                                                                    "icon": "harbor"
                                                                }
                                                            }]
                                                        }
                                                    },
                                                    "layout": {
                                                        "icon-image": "{icon}-15",
                                                        "text-field": "{title}",
                                                        "text-font": ["Open Sans Semibold", "Arial Unicode MS Bold"],
                                                        "text-offset": [0, 0.6],
                                                        "text-anchor": "top"
                                                    }
                                                });
                                                 
                                                

                                                 // Add a line between coordinates 1 and 2 

/*                                            map.addLayer({
                                                    "id": "route",
                                                    "type": "line",
                                                    "source": {
                                                        "type": "geojson",
                                                        "data": {
                                                            "type": "Feature",
                                                            "properties": {},
                                                            "geometry": {
                                                                "type": "LineString",
                                                                "coordinates": [
                                                                    [long1, lat1],
                                                                    [long2, lat2] 
                                                                ] 
                                                            }
                                                        }
                                                    },
                                                    "layout": {
                                                        "line-join": "round",
                                                        "line-cap": "round"
                                                    },
                                                    "paint": {
                                                        "line-color": "#f00",
                                                        "line-width": 8
                                                    }
                                                }); */// , firstSymbolId);

                                                deleteLayerLine= true; 
                                            }


                                          document.getElementById('info_click').innerHTML = 
                                              'First point: ' + coordinates1 + '<br />' + 'Second point:' + coordinates2 ;



        /*                                    document.getElementById('info_click').innerHTML = 
                                                // e.point is the x, y coordinates of the mousemove event relative
                                                // to the top-left corner of the map
                                                JSON.stringify(e.point) + '<br />' +
                                                // e.lngLat is the longitude, latitude geographical position of the event
                                                JSON.stringify(e.lngLat);*/


                                            });

                               
                                  
                              //       });
                                
                                                            
                                
                            </script>
        
        

      </div>
</div>


</body>

        <!--   Core JS Files   -->
    <script src="assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Charts Plugin -->
	<script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>



</html>