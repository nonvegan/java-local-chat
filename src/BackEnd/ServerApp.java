package BackEnd;


public class ServerApp {
	
	public static void main(String[] args) {
		
		ServidorContactos servidor = new ServidorContactos();
		servidor.instanciarAtendedorContactos();
	}
}