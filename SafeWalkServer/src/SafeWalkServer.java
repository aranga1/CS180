import java.io.*;
import java.net.*;
public class SafeWalkServer implements Runnable {
	private ServerSocket socket;
	/**
	 * Construct the server, and create a server socket, bound to the specified port.
	 * 
	 * @throws IOException IO error when opening the socket..
	 */
	public SafeWalkServer(int port) throws IOException {
	    socket = new ServerSocket(port);
	    socket.setReuseAddress(true);
		//TODO: finish the method
	}
	 
	/**
	 * Construct the server, and create a server socket, bound to a port that is automatically allocated.
	 * 
	 * @throws IOException IO error when opening the socket.
	 */
	public SafeWalkServer() throws IOException {
		socket = new ServerSocket();
		socket.setReuseAddress(true);
		//TODO: finish the method
	}
	
	/**
	 * Return the port number on which the server is listening. 
	 */
	public int getLocalPort() {
	    return socket.getLocalPort();
		//TODO: finish this method
	}
	
	public void run() {
		while (true) {
			try {
				Socket client = socket.accept();
				ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
