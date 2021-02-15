package chatInicial;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
	static final String IP = "localhost";
	static final int PUERTO = Servidor.PUERTO;
	public static void main(String[] args) {
	
		try {
			Socket socketCliente = new Socket();
			InetSocketAddress direccion = new InetSocketAddress(IP, PUERTO);	//Asigno al socket la direccion y el puerto.
			socketCliente.connect(direccion);	
			
			DataInputStream datosEntrada = new DataInputStream(socketCliente.getInputStream()); //Recibir mensaje de AtiendeCliente? 
			DataOutputStream datosSalida = new DataOutputStream(socketCliente.getOutputStream());
			
			String mensaje = "Mensaje desde cliente.";
			datosSalida.writeUTF(mensaje);
			
			socketCliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
