package telran.lessons._40_EmployeesClientApplication.net;

import java.io.Serializable;
import telran.lessons._40_EmployeesClientApplication.net.server.TcpResponseCode;

public class ResponseJava implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 13L;
	public TcpResponseCode responseCode;
	public Serializable responseData;

	public ResponseJava(TcpResponseCode responseCode, Serializable responseData) {
		super();
		this.responseCode = responseCode;
		this.responseData = responseData;
	}
	
}
