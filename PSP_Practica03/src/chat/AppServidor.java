package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.net.InetSocketAddress;


public class AppServidor {
	static final int PUERTO = 2070;
	static final int MAX_CONEXIONES = 10;
	
	public static void main(String[] args) {
		try {
			//ABRO CONEXION
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket();						//Creo el socket servidor.
				
			InetSocketAddress direccion = new InetSocketAddress("localhost", PUERTO);
			serverSocket.bind(direccion);							//Asigno al socket la direccion y el puerto.
			System.out.println("Escuchando puerto " + PUERTO);
			
			int conexionesContador = 0;
			while (conexionesContador<MAX_CONEXIONES) {					
				Socket clienteSocket = serverSocket.accept();		//Creo un socket nuevo y acepto nuevos clientes.
				conexionesContador++;
				Monitor.setConexionesActuales(conexionesContador);	
				
				//CREO ATIENDE_CLIENTE 
				AtiendeCliente atiendeCliente = new AtiendeCliente(clienteSocket);
				atiendeCliente.start();		//Arranco el hilo de AtiendeCliente con el socket del servidor. AtiendeCliente recogera la informacion, la leera y la escribira.
				
				Monitor.setSocket(clienteSocket);					//Guardo el socket del cliente en el arrayList del Monitor.

//				clienteSocket.close();									//Cierro el nuevo socket.
//				serverSocket.close();									//Cierro el socket servidor.
			}
			System.out.println("Máximas conexiones alcanzadas.");
		} catch (IOException e) {			
			e.printStackTrace();
		}	
	}//FIN MAIN
	
	
}
