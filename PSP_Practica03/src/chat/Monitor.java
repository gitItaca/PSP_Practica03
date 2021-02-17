package chat;

import java.net.Socket;
import java.util.ArrayList;

public class Monitor {

	private final int MAX_CONEXIONES_SIMULTANEAS = 5;
	private int conexionesTotales;
	private int conexionesActuales;
	
	private static ArrayList<Socket> sockets = new ArrayList<Socket>();
	private static String mensaje;
	
//CONSTRUCTOR
	public Monitor(int MAX_CONEXIONES_SIMULTANEAS) {
		//Monitor.mensajes = new ArrayList<String>();
	}

//GETTERS Y SETTERS
	public int getConexionesTotales() {
		return conexionesTotales;
	}

	public int getConexionesActuales() {
		return conexionesActuales;
	}
	
	public static ArrayList<Socket> getSockets() {
		return sockets;
	}

	public static void setSocket(Socket socket) {
		Monitor.sockets.add(socket);
	}

	public static String getMensaje() {
		return mensaje;
	}
	
	public static void setMensaje(String mensaje, String nombreUser) {
		Monitor.mensaje = nombreUser + ": " + mensaje;
	}
	
}


//public static void setSockets(Socket[] sockets) {
//	Monitor.sockets = sockets;
//}
//
//public static void setSocket(Socket socket) {
//	for(int x = 0; x<sockets.length; x++) {
//		if(Monitor.sockets[x] == null) {
//			Monitor.sockets[x] = socket;
//		}else {
//			System.out.println("Espacio lleno.");
//		}			
//	}
//	
//}
