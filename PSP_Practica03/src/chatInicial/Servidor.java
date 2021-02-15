package chatInicial;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	static final int PUERTO = 2211;
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket;		
			serverSocket = new ServerSocket(); //Creo el socket servidor.
						
			
			InetSocketAddress direccion = new InetSocketAddress("localhost", PUERTO);
			serverSocket.bind(direccion);							//Asigno al socket la direccion y el puerto.
			System.out.println("Escuchando puerto " + PUERTO);
		
			Socket newSocket = serverSocket.accept();	
			
			DataInputStream datosEntrada = new DataInputStream(newSocket.getInputStream()); 
			DataOutputStream datosSalida = new DataOutputStream(newSocket.getOutputStream());
			
			while (true) {
				String mensaje = datosEntrada.readUTF();
				System.out.println("Mensaje recibido: " + mensaje);
			}
			
			
			
//			newSocket.close();
//			serverSocket.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}

}
