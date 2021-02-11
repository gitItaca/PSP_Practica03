package chat;

import java.net.Socket;

public class Monitor {

	private final int MAX_CONEXIONES_SIMULTANEAS = 5;
	private int conexionesTotales;
	private int conexionesActuales;
	
	private static Socket[] sockets;
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

	public static String getMensaje() {
		return mensaje;
	}

	public static void setSockets(Socket[] sockets) {
		Monitor.sockets = sockets;
	}
	
	public static void setMensaje(String mensaje, String nombreUser) {
		Monitor.mensaje = nombreUser + ": " + mensaje;
	}
	
}
