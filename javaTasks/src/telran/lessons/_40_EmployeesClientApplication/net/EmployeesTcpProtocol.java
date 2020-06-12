package telran.lessons._40_EmployeesClientApplication.net;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;
import telran.lessons._40_EmployeesClientApplication.dto.CompanySalary;
import telran.lessons._40_EmployeesClientApplication.dto.Employee;
import telran.lessons._40_EmployeesClientApplication.dto.EmployeesReturnCodes;
import telran.lessons._40_EmployeesClientApplication.net.server.ProtocolJava;
import static telran.lessons._40_EmployeesClientApplication.net.server.TcpResponseCode.*;

public class EmployeesTcpProtocol implements ProtocolJava {

	private HashMap<String, Function<Serializable, ResponseJava>> funMap;
	EmployeesService employees;

	public EmployeesTcpProtocol(EmployeesService employees) {
		this.employees = employees;
		fillFunMap();
	}

	private void fillFunMap() {
		funMap = new HashMap<>();
		funMap.put("addEmployee", this::addEmployee);
		funMap.put("removeEmployee", this::removeEmployee);
		funMap.put("getEmployee", this::getEmployee);
		funMap.put("getEmployeesSalary", this::getEmployeesSalary);
		funMap.put("getCompaniesAvgSalary", this::getCompaniesAvgSalary);
		funMap.put("getEmployeesGroupedBySalary", this::getEmployeesGroupedBySalary);
		funMap.put("getCompaniesGreaterAvgSalary", this::getCompaniesGreaterAvgSalary);
		funMap.put("getEmployeesAges", this::getEmployeesAges);
		funMap.put("updateCompany", this::updateCompany);
		funMap.put("updateSalary", this::updateSalary);
	}

	@Override
	public ResponseJava getResponse(RequestJava request) {
		try {
			ResponseJava response = funMap.getOrDefault(request.requestType, this::wrongRequest)
					.apply(request.requestData);
			return response;
		} catch (Exception e) {
			return new ResponseJava(UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava addEmployee(Serializable requestData) {
		EmployeesReturnCodes returnCode = employees.addEmployee((Employee) requestData);
		return new ResponseJava(OK, returnCode);
	}

	private ResponseJava removeEmployee(Serializable requestData) {
		EmployeesReturnCodes returnCode = employees.removeEmployee((long) requestData);
		return new ResponseJava(OK, returnCode);
	}

	private ResponseJava getEmployee(Serializable requestData) {
		Employee employee = employees.getEmployee((long) requestData);
		return new ResponseJava(OK, employee);
	}

	@SuppressWarnings("unchecked")
	private ResponseJava getEmployeesSalary(Serializable requestData) {
		int salaryFrom = ((Map<String, Integer>) requestData).get("salaryFrom");
		int salaryTo = ((Map<String, Integer>) requestData).get("salaryTo");
		Iterable<Employee> employeesSalary = employees.getEmployeesSalary(salaryFrom, salaryTo);
		return new ResponseJava(OK, (Serializable) employeesSalary);
	}

	private ResponseJava getCompaniesAvgSalary(Serializable requestData) {
		List<CompanySalary> companiesAvgSalary = employees.getCompaniesAvgSalary();
		return new ResponseJava(OK, (Serializable) companiesAvgSalary);
	}

	private ResponseJava getEmployeesGroupedBySalary(Serializable requestData) {
		Map<String, List<Employee>> employeesGroupedBySalary = employees.getEmployeesGroupedBySalary((int) requestData);
		return new ResponseJava(OK, (Serializable) employeesGroupedBySalary);
	}

	private ResponseJava getCompaniesGreaterAvgSalary(Serializable requestData) {
		List<CompanySalary> companiesGreaterAvgSalary = employees.getCompaniesGreaterAvgSalary();
		return new ResponseJava(OK, (Serializable) companiesGreaterAvgSalary);
	}

	@SuppressWarnings("unchecked")
	private ResponseJava getEmployeesAges(Serializable requestData) {
		int ageFrom = ((Map<String, Integer>) requestData).get("ageFrom");
		int ageTo = ((Map<String, Integer>) requestData).get("ageTo");
		Iterable<Employee> employeesAges = employees.getEmployeesAges(ageFrom, ageTo);
		return new ResponseJava(OK, (Serializable) employeesAges);
	}

	@SuppressWarnings("unchecked")
	private ResponseJava updateCompany(Serializable requestData) {
		long id = (long) ((Map<String, Object>) requestData).get("id");
		String newCompany = (String) ((Map<String, Object>) requestData).get("newCompany");
		EmployeesReturnCodes updateCompany = employees.updateCompany(id, newCompany);
		return new ResponseJava(OK, updateCompany);
	}

	@SuppressWarnings("unchecked")
	private ResponseJava updateSalary(Serializable requestData) {
		long id = (long) ((Map<String, Object>) requestData).get("id");
		int newSalary = (int) ((Map<String, Object>) requestData).get("newSalary");
		EmployeesReturnCodes updateSalary = employees.updateSalary(id, newSalary);
		return new ResponseJava(OK, updateSalary);
	}

	private ResponseJava wrongRequest(Serializable requestData) {
		return new ResponseJava(WRONG_REQUEST, "Type of request not found");
	}

}
