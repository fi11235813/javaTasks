package telran.lessons._40_EmployeesClientApplication.net;

import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;
import telran.lessons._40_EmployeesClientApplication.net.server.ProtocolJava;
import telran.lessons._40_EmployeesClientApplication.net.server.ServerJava;
import telran.lessons._40_EmployeesClientApplication.service.EmployeesServiceMapsImpl;

public class EmployeesServerAppl {
	public static void main(String[] args) {
		EmployeesService employees = new EmployeesServiceMapsImpl();
		ProtocolJava protocol = new EmployeesTcpProtocol(employees);
		ServerJava server = new ServerJava(protocol, 5000);
		server.run();
	}
}
