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
			//ESTABLEZCO CONEXION CON APP_SERVIDOR
			Socket socketCliente = new Socket();								//Creo el socket del cliente.			
			InetSocketAddress direccion = new InetSocketAddress(IP, PUERTO);	//Asigno al socket la direccion y el puerto.
			socketCliente.connect(direccion);			
			
			//CREAR ATIENDE_SERVIDOR (como se indica, yo lo tenia al reves)
			AtiendeServidor atiendeServidor = new AtiendeServidor(socketCliente);
			atiendeServidor.start();
			
//			DataInputStream datosEntrada = new DataInputStream(socketCliente.getInputStream()); //Creo que no hace falta. 
			datosSalida = new DataOutputStream(socketCliente.getOutputStream());
			
			//MIRAR: No se si desde aqui se tienen que escribir o tiene que mandar los datos a otra clase para que aparezcan
			do {
				if(nombreUser == null) {
					System.out.println("Escribe tu nombre de usuario");
					nombreUser = entradaTerminal.nextLine();
					datosSalida.writeUTF(nombreUser);
				}else {
					String escriboNombre = "Desde AppCliente" + "[" + nombreUser + "]  ";
					System.out.print(escriboNombre);
					mensajeUser = entradaTerminal.nextLine();
					System.out.println(mensajeUser);
					
					String nombreUserYMensaje = escriboNombre + mensajeUser;
					datosSalida.writeUTF(nombreUserYMensaje);
					
					
				}				
			}while(mensajeUser != "*");
			
			
			//(Lo pongo en appServidor) 
//			AtiendeCliente atiendeCliente = new AtiendeCliente(socketCliente);
//			atiendeCliente.start();
//			do {
//				if(nombreUser == null) {
//					System.out.println("Escribe tu nombre de usuario");
//					nombreUser = entradaTerminal.nextLine();
//					datosSalida.writeUTF(nombreUser);
//				}else {
//					mensajeUser = "[" + nombreUser + "]  ";
//					System.out.println(mensajeUser);
//					mensajeUser = mensajeUser + entradaTerminal.nextLine();
//					datosSalida.writeUTF(mensajeUser);
//				}
//				
//			}while(mensajeUser != "*");
			
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
