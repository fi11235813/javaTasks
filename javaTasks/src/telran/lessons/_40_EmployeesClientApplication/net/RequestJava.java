package telran.lessons._40_EmployeesClientApplication.net;

import java.io.Serializable;

public class RequestJava implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 13L;
	
	public String requestType;
	public Serializable requestData;
	
	public RequestJava(String requestType, Serializable requestData) {
		super();
		this.requestType = requestType;
		this.requestData = requestData;
	}
	
	
}
