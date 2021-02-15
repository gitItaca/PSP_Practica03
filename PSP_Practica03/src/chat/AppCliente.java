package chat;

import java.io.DataInputStream;
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
		new AppCliente().run();
		
	}//FIN MAIN
	
	public void run() {
		try {
			//ESTABLEZCO CONEXION CON APP_SERVIDOR
			Socket socketCliente = new Socket();								//Creo el socket del cliente.			
			InetSocketAddress direccion = new InetSocketAddress(IP, PUERTO);	//Asigno al socket la direccion y el puerto.
			socketCliente.connect(direccion);
			
			//CREAR ATIENDE_SERVIDOR para leer los mensajes del terminal y enviarselos al servidor.
			AtiendeServidor atiendeServidor = new AtiendeServidor(socketCliente);
			atiendeServidor.start();
			
			DataInputStream datosEntrada = new DataInputStream(socketCliente.getInputStream()); //Recibir mensaje de AtiendeCliente? 
			datosSalida = new DataOutputStream(socketCliente.getOutputStream());
			
			do {
				if(nombreUser == null) {
					System.out.println("Escribe tu nombre de usuario");
					nombreUser = entradaTerminal.nextLine();
					datosSalida.writeUTF(nombreUser + " se acaba de conectar.");
				}else {
					String escriboNombre = "Desde AppCliente" + "[" + nombreUser + "]  ";
					System.out.print(escriboNombre);
					mensajeUser = entradaTerminal.nextLine();
					System.out.println(mensajeUser);
					
					String nombreUserYMensaje = escriboNombre + mensajeUser;
					datosSalida.writeUTF(nombreUserYMensaje);						
				}				
			}while(mensajeUser != "*");
			
			socketCliente.close();							//Cierro el socket del cliente	
			
		} catch (IOException e) {			
			e.printStackTrace();
		}						
		
	}

}
//(Lo pongo en appServidor) 
//AtiendeCliente atiendeCliente = new AtiendeCliente(socketCliente);
//atiendeCliente.start();
//do {
//	if(nombreUser == null) {
//		System.out.println("Escribe tu nombre de usuario");
//		nombreUser = entradaTerminal.nextLine();
//		datosSalida.writeUTF(nombreUser);
//	}else {
//		mensajeUser = "[" + nombreUser + "]  ";
//		System.out.println(mensajeUser);
//		mensajeUser = mensajeUser + entradaTerminal.nextLine();
//		datosSalida.writeUTF(mensajeUser);
//	}
//	
//}while(mensajeUser != "*");

//String mensajeUser = "hhhhhhhhhhhhhhhh";
//
//datosSalida.writeUTF(mensajeUser);
//
//String mensajeServidor = datosEntrada.readUTF();			
//System.out.println("Mensaje desde el servidor: " + mensajeServidor);

//InputStream is = socketCliente.getInputStream();
//OutputStream os = socketCliente.getOutputStream();
