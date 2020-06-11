package telran.lessons._40_EmployeesClientApplication.net.server;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import telran.lessons._40_EmployeesClientApplication.net.RequestJava;
import telran.lessons._40_EmployeesClientApplication.net.ResponseJava;

public class ServerClientJava implements Runnable {
	private ProtocolJava protocol;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	

	public ServerClientJava(Socket socket, ProtocolJava protocol) {
		this.protocol = protocol;
		try {
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while(true) {
			RequestJava request = (RequestJava) input.readObject();
			ResponseJava response = protocol.getResponse(request);
			output.writeObject(response);
			}
		} catch (EOFException e) {
			System.out.println("client closed connection");
		}

		catch (Exception e) {
			System.out.println("illegal closing exception");
			throw new RuntimeException(e.getMessage());
		}
	}
}
