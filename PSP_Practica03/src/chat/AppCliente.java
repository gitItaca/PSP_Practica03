package chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class AppCliente {
	static final String IP = "localhost";
	static final int PUERTO = AppServidor.PUERTO;
	static DataOutputStream datosSalida;
	static Scanner entradaTerminal = new Scanner(System.in);
	static String nombreUser;
	static String mensajeUser;

//Establece conexiones con el servidor, lee mensajes del terminal y se los envia al servidor.
	public static void main(String[] args) {
		
		try {
			//ESTABLEZCO CONEXION CON APP_SERVIDOR
			Socket socketCliente = new Socket();								//Creo el socket del cliente.			
			InetSocketAddress direccion = new InetSocketAddress(IP, PUERTO);	//Asigno al socket la direccion y el puerto.
			socketCliente.connect(direccion);
			
			//CREAR ATIENDE_SERVIDOR para leer los mensajes del terminal y enviarselos al servidor.
			AtiendeServidor atiendeServidor = new AtiendeServidor(socketCliente);
			atiendeServidor.start();
			
			datosSalida = new DataOutputStream(socketCliente.getOutputStream());
			
			do {
				if(nombreUser == null) {
					System.out.println("Escribe tu nombre de usuario");
					nombreUser = entradaTerminal.nextLine();
					datosSalida.writeUTF(nombreUser + " se acaba de conectar.");
				}else {
					String escriboNombre = "[" + nombreUser + "]  ";					
					mensajeUser = entradaTerminal.nextLine();
					System.out.print(escriboNombre);
					System.out.println(mensajeUser);
					
					String nombreUserYMensaje = escriboNombre + mensajeUser;
					datosSalida.writeUTF(nombreUserYMensaje);						
				}				
			}while(mensajeUser != "*");
			
			socketCliente.close();							//Cierro el socket del cliente	
			
		} catch (IOException e) {			
			e.printStackTrace();
		}			
		
	}//FIN MAIN
	

}
