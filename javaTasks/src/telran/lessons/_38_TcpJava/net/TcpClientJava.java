package telran.lessons._38_TcpJava.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientJava implements Closeable {

	protected ObjectOutputStream output;
	protected ObjectInputStream input;
	protected Socket socket;

	public TcpClientJava(String hostName, int port) {
		try {
			socket = new Socket(hostName, port);
			output = new ObjectOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());

		} catch (UnknownHostException e) {
			throw new RuntimeException("Start game...unknown host " + hostName);
		} catch (IOException e) {
			throw new RuntimeException("Start game..." + e.getMessage());
		}
	}

	protected <T> T sendRequest(String requestType, Serializable requestData) {
		
			try {
			output.writeObject(new RequestJava(requestType, requestData));
			ResponseJava response = (ResponseJava) input.readObject();
			if (response.code == TcpResponseCode.UNKNOWN) {
				close();
				throw new RuntimeException("Unknown request");
			}

			if (response.code == TcpResponseCode.WRONG_REQUEST) {
				close();
				throw new RuntimeException("WRONG_REQUEST");
			}
			return (T) response.responseData;
		} catch (IOException e) {
			throw new RuntimeException("Start game..." + e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Class not found..." + e.getMessage());
		}

	}

	@Override
	public void close() throws IOException {
		output.close();
		input.close();
		socket.close();
	}
}
