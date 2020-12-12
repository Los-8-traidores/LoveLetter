package server.models;

import java.io.IOException;
import java.net.ServerSocket;



public class Server extends Thread {
	private ServerSocket serverSocket;
	private RoomSynchronizer roomSynchronizer;
	private UserSynchronizer userSynchronizer;

	public Server (int port) {
		try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Error al crear el socket.");
        }
	}
	
	@Override
    public void run() {
        try {
            while (true) {
                new Flow(serverSocket.accept(), roomSynchronizer, userSynchronizer).start();
            }
        } catch (IOException e) {
        	System.out.println("Error al correr el socket.");
        } finally {
            try {
                this.serverSocket.close();
            } catch (IOException e) {
            	System.out.println("Error al cerrar el socket.");
            }
        }
    }
}
