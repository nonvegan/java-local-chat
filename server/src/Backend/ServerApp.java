package Backend;

import java.io.IOException;


public class ServerApp {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ServidorContactos servidor = new ServidorContactos();
		servidor.instanciarAtendedorContactos();
	}
}