package chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class AtiendeCliente extends Thread{
	
	Socket conexion;
	DataInputStream entrada;
	Monitor monitor = null;

//CONSTRUCTOR
	public AtiendeCliente(Socket conexion) throws IOException {
		this.entrada = new DataInputStream(conexion.getInputStream());
		this.conexion = conexion;
	}
	
//METODOS
	@Override
	public void run() {
		try {	
			
			while(true) {	
				
				String mensaje = entrada.readUTF();	
				System.out.println(mensaje);				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}//FIN RUN
	
		
}//FIN AtiendeCliente
