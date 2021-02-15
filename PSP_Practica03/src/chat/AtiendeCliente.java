package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AtiendeCliente extends Thread{
	
	Socket conexion;
	DataInputStream entrada;
//	DataOutputStream salida;
	Monitor monitor = null;

//CONSTRUCTOR
	public AtiendeCliente(Socket conexion) throws IOException {
		this.entrada = new DataInputStream(conexion.getInputStream());
//		this.salida = new DataOutputStream(conexion.getOutputStream());
		this.conexion = conexion;
	}
	
//METODOS
	@Override
	public void run() {
		try {				
			while(true) {	
				//Lee los mensajes de los clientes y los imprime.
				String mensaje = entrada.readUTF();	
				System.out.println(mensaje);		
				
//				salida.writeUTF(mensaje);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}		
	}//FIN RUN
	
		
}//FIN AtiendeCliente
