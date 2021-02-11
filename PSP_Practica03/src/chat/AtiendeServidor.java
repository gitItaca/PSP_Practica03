package chat;

import java.io.DataInputStream;
import java.net.Socket;

public class AtiendeServidor extends Thread{
	
	DataInputStream entrada;
	Socket conexion;

//CONSTRUCTOR
	public AtiendeServidor(DataInputStream entrada, Socket conexion) {
		this.entrada = entrada;
		this.conexion = conexion;
	}


//METODOS
	@Override
	public void run() {
		
		
	}

}
