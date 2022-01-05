package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) { 
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		final int PORT = 2345;
		BufferedReader input = null;
		PrintWriter output = null;
		
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server socket: " + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());
			
			socket = serverSocket.accept();
			System.out.println("Connection established...");
			
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			
			String client = input.readLine();
			
			output.println(client);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				System.out.println("Client connection terminated.");
				input.close();
				output.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
