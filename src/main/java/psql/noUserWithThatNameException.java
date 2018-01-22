package psql;

public class noUserWithThatNameException extends Exception {
	private static final long serialVersionUID = 1L;

	public noUserWithThatNameException(String mensaje){
        super(mensaje);
    }
     
}
