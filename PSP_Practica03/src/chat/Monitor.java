package chat;

import java.net.Socket;
import java.util.ArrayList;

public class Monitor {

	private final int MAX_CONEXIONES_SIMULTANEAS = 5;
	private int conexionesTotales;
	private int conexionesActuales = 0;
	
	private static ArrayList<Socket> sockets = new ArrayList<Socket>();
	private static ArrayList<String> mensajes;
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
	
	public static void setConexionesActuales(int conexionesActuales) {
		conexionesActuales = conexionesActuales;
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
	
	public static void setMensaje(String mensaje) {
		Monitor.mensaje = mensaje;
//		Monitor.mensajes.add(mensaje);
	}
	
}

