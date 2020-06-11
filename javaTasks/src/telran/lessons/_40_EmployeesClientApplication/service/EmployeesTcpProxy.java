package telran.lessons._40_EmployeesClientApplication.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;
import telran.lessons._40_EmployeesClientApplication.controllers.TcpClientJava;
import telran.lessons._40_EmployeesClientApplication.dto.*;


public class EmployeesTcpProxy extends TcpClientJava implements EmployeesService {

	public EmployeesTcpProxy(String hostName, int port) {
		super(hostName, port);
	}

	@Override
	public EmployeesReturnCodes addEmployee(Employee empl) {
		return sendRequest("addEmployee", empl);
	}

	@Override
	public EmployeesReturnCodes removeEmployee(long id) {
		return sendRequest("removeEmployee", id);
	}

	@Override
	public Employee getEmployee(long id) {
		return sendRequest("getEmployee", id);
	}

	@Override
	public Iterable<Employee> getEmployeesSalary(int salaryFrom, int salaryTo) {
		var requestData = new HashMap<String, Integer>();
		requestData.put("salaryFrom", salaryFrom);
		requestData.put("salaryTo", salaryTo);
		
		return sendRequest("getEmployeesSalary", requestData);
	}

	@Override
	public List<CompanySalary> getCompaniesAvgSalary() {
		return sendRequest("getCompaniesAvgSalary", "");
	}

	@Override
	public Map<String, List<Employee>> getEmployeesGroupedBySalary(int interval) {
		return sendRequest("getEmployeesGroupedBySalary", interval);
	}

	@Override
	public List<CompanySalary> getCompaniesGreaterAvgSalary() {
		return sendRequest("getCompaniesGreaterAvgSalary", "");
	}

	@Override
	public Iterable<Employee> getEmployeesAges(int ageFrom, int ageTo) {
		var requestData = new HashMap<String, Integer>();
		requestData.put("ageFrom", ageFrom);
		requestData.put("ageTo", ageTo);
		
		return sendRequest("getEmployeesAges", requestData);
	}

	@Override
	public EmployeesReturnCodes updateCompany(long id, String newCompany) {
		var requestData = new HashMap<String, Object>();
		requestData.put("id", id);
		requestData.put("newCompany", newCompany);
		return sendRequest("updateCompany", requestData);
	}

	@Override
	public EmployeesReturnCodes updateSalary(long id, int newSalary) {
		var requestData = new HashMap<String, Object>();
		requestData.put("id", id);
		requestData.put("newSalary", newSalary);
		return sendRequest("updateSalary", requestData);
	}
	
}
