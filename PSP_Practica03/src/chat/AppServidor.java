package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetSocketAddress;


public class AppServidor {
	static final int PUERTO = 2010;
	static final int MAX_CONEXIONES = 10;
	
	public static void main(String[] args) {
		new AppServidor().run();
	}//FIN MAIN
	
	public void run() {
		try {
			//ABRO CONEXION
			ServerSocket serverSocket = new ServerSocket();						//Creo el socket servidor.
				
			InetSocketAddress direccion = new InetSocketAddress("localhost", PUERTO);
			serverSocket.bind(direccion);							//Asigno al socket la direccion y el puerto.
			System.out.println("Escuchando puerto " + PUERTO);
			
			while (true) {			
				Socket clienteSocket = serverSocket.accept();		//Creo un socket nuevo y acepto nuevos clientes.
				
				//CREO ATIENDE_CLIENTE 
				AtiendeCliente atiendeCliente = new AtiendeCliente(clienteSocket);
				atiendeCliente.start();		//Arranco el hilo de AtiendeCliente con el socket del servidor. AtiendeCliente recogera la informacion, la leera y la escribira.
				
				//newSocket.close();									//Cierro el nuevo socket.
				//serverSocket.close();									//Cierro el socket servidor.
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}	
	}
	
}

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


//(Lo pongo en appCliente) Abro un hilo de "atiendeServidor" con el socket creado.
//AtiendeServidor atiendeServidor = new AtiendeServidor(newSocket);
//atiendeServidor.start();

//(Fue antes de creat las clases de Atiende)
//DataInputStream datosEntrada = new DataInputStream(newSocket.getInputStream());
//DataOutputStream datosSalida = new DataOutputStream(newSocket.getOutputStream());
//
//
//String mensajeCliente = datosEntrada.readUTF();
//System.out.println("Mensaje recibido: " + mensajeCliente);
//
//datosSalida.writeUTF(mensajeCliente);			
//