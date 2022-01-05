package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) {
		
		InetAddress address = null;
		Socket socket = null;
		BufferedReader input = null;
		PrintWriter output = null;
		final int PORT = 2345;
		
		try {
			address = InetAddress.getByName("127.0.0.1");
			System.out.println("Address: " + address.getHostAddress());
			
			socket = new Socket(address, PORT);
			System.out.println("Socket: " + socket.getInetAddress());
			
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			
			output.println("Hello");
			String response = input.readLine();
			System.out.println(response);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
