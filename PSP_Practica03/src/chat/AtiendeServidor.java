package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

//Recibe los mensajes del servidor y los escribe en el terminal.
public class AtiendeServidor extends Thread{
	
	Socket conexion;
	DataInputStream entrada;	

//CONSTRUCTOR
	public AtiendeServidor(Socket conexion) throws IOException {
		this.entrada = new DataInputStream(conexion.getInputStream());
		this.conexion = conexion;
	}

//METODOS
	@Override
	public void run() {
		try {			
//			DataOutputStream salida = new DataOutputStream(conexion.getOutputStream());			
			while(true) {
				String salidaString = entrada.readUTF(); //El readUTF es bloqueante, por eso lo ponemos en un hilo.
				System.out.println(salidaString);
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

}
