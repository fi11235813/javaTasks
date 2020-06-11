package telran.lessons._40_EmployeesClientApplication.controllers;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;


import telran.lessons._40_EmployeesClientApplication.net.RequestJava;
import telran.lessons._40_EmployeesClientApplication.net.ResponseJava;
import telran.lessons._40_EmployeesClientApplication.net.server.TcpResponseCode;

public class TcpClientJava implements Closeable {

	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;

	public TcpClientJava(String hostName, int port) {
		try {
			socket = new Socket(hostName, port);
			output = new ObjectOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} 
	}

	@SuppressWarnings("unchecked")
	protected <T> T sendRequest(String requestType, Serializable requestData) {
		try {
			output.writeObject(new RequestJava(requestType, requestData));
			ResponseJava response = (ResponseJava) input.readObject();

			if (response.responseCode == TcpResponseCode.UNKNOWN) {
				throw new RuntimeException("UNKNOWN request " + response.responseData.toString());
			}

			if (response.responseCode == TcpResponseCode.WRONG_REQUEST) {
				throw new RuntimeException("WRONG_REQUEST " + response.responseData.toString());
			}
			return (T) response.responseData;

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());

		}
	}

	@Override
	public void close() throws IOException {
		socket.close();
	}
}
