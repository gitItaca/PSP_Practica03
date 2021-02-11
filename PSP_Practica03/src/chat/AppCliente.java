package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class AppCliente {
	static final String IP = "localhost";
	static final int PUERTO = AppServidor.PUERTO;
	static DataOutputStream datosSalida;
	static Scanner entradaTerminal = new Scanner(System.in);
	static String nombreUser;
	static String mensajeUser;

	public static void main(String[] args) {
		
		try {
			Socket socketCliente = new Socket();								//Creo el socket del cliente.			
			InetSocketAddress direccion = new InetSocketAddress(IP, PUERTO);	//Asigno al socket la direccion y el puerto.
			socketCliente.connect(direccion);
			
			
			DataInputStream datosEntrada = new DataInputStream(socketCliente.getInputStream());
			datosSalida = new DataOutputStream(socketCliente.getOutputStream());
			
			AtiendeCliente atiendeCliente = new AtiendeCliente(socketCliente);
			atiendeCliente.start();
			do {
				if(nombreUser == null) {
					System.out.println("Escribe tu nombre de usuario");
					nombreUser = entradaTerminal.nextLine();
					datosSalida.writeUTF(nombreUser);
				}else {
					mensajeUser = "[" + nombreUser + "]  ";
					System.out.println(mensajeUser);
					mensajeUser = mensajeUser + entradaTerminal.nextLine();
					datosSalida.writeUTF(mensajeUser);
				}
				
			}while(mensajeUser != "*");
			
//			String mensajeUser = "hhhhhhhhhhhhhhhh";
//			
//			datosSalida.writeUTF(mensajeUser);
//			
//			String mensajeServidor = datosEntrada.readUTF();			
//			System.out.println("Mensaje desde el servidor: " + mensajeServidor);
			
			socketCliente.close();							//Cierro el socket del cliente	
			
		} catch (IOException e) {			
			e.printStackTrace();
		}						
		
	}

}


//InputStream is = socketCliente.getInputStream();
//OutputStream os = socketCliente.getOutputStream();
