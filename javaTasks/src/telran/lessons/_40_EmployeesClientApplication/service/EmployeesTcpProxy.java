package telran.lessons._40_EmployeesClientApplication.service;

import java.util.List;
import java.util.Map;

import telran.lessons._38_TcpJava.net.TcpClientJava;
import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;
import telran.lessons._40_EmployeesClientApplication.dto.*;


public class EmployeesTcpProxy extends TcpClientJava implements EmployeesService {

	public EmployeesTcpProxy(String hostName, int port) {
		super(hostName, port);
	}

	@Override
	public EmployeesReturnCodes addEmployee(Employee empl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeesReturnCodes removeEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Employee> getEmployeesSalary(int salaryFrom, int salaryTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanySalary> getCompaniesAvgSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Employee>> getEmployeesGroupedBySalary(int interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanySalary> getCompaniesGreaterAvgSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Employee> getEmployeesAges(int ageFrom, int ageTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeesReturnCodes updateCompany(long id, String newCompany) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeesReturnCodes updateSalary(long id, int newSalary) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
