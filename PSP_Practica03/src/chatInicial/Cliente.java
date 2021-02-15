package chatInicial;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	static final String IP = "localhost";
	static final int PUERTO = Servidor.PUERTO;
	static Scanner entradaTerminal = new Scanner(System.in);
	static String nombreUser;
	static String mensajeUser;
	
	public static void main(String[] args) {
	
		try {
			Socket socketCliente = new Socket();
			InetSocketAddress direccion = new InetSocketAddress(IP, PUERTO);	//Asigno al socket la direccion y el puerto.
			socketCliente.connect(direccion);	
			
			DataInputStream datosEntrada = new DataInputStream(socketCliente.getInputStream()); //Recibir mensaje de AtiendeCliente? 
			DataOutputStream datosSalida = new DataOutputStream(socketCliente.getOutputStream());
			
//			String mensaje = "Mensaje desde cliente.";
//			datosSalida.writeUTF(mensaje);
			do {
				if(nombreUser == null) {
					System.out.println("Escribe tu nombre de usuario");
					nombreUser = entradaTerminal.nextLine();
					datosSalida.writeUTF(nombreUser);
				}else {
					String escriboNombre = "[" + nombreUser + "]  ";
					System.out.print(escriboNombre);
					mensajeUser = entradaTerminal.nextLine();
					System.out.println(mensajeUser);
					
					String nombreUserYMensaje = escriboNombre + mensajeUser;
					datosSalida.writeUTF(nombreUserYMensaje);						
				}				
			}while(mensajeUser != "*");
			
			socketCliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
