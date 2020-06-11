package telran.lessons._40_EmployeesClientApplication.net.server;

import telran.lessons._40_EmployeesClientApplication.net.RequestJava;
import telran.lessons._40_EmployeesClientApplication.net.ResponseJava;

public interface ProtocolJava {
	ResponseJava getResponse(RequestJava request);
}
