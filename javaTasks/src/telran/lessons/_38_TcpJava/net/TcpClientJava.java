package telran.lessons._38_TcpJava.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientJava implements Closeable {

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket socket;

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

	@SuppressWarnings("unchecked")
	protected <T> T sendRequest(String requestType, Serializable requestData) {
		try {
			output.writeObject(new RequestJava(requestType, requestData));
			ResponseJava response = (ResponseJava) input.readObject();
			if (response.code == TcpResponseCode.UNKNOWN) {
				throw new RuntimeException("Unknown request " + response.responseData.toString());
			}

			if (response.code == TcpResponseCode.WRONG_REQUEST) {
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
