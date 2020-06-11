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
		return funMap.getOrDefault(request.requestType, this::wrongRequest).apply(request.requestData);
	}

	private ResponseJava addEmployee(Serializable requestData) {
		try {
			EmployeesReturnCodes returnCode = employees.addEmployee((Employee) requestData);
			return new ResponseJava(OK, returnCode);
		} catch (Exception e) {
			return new ResponseJava(UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava removeEmployee(Serializable requestData) {
		try {
			EmployeesReturnCodes returnCode = employees.removeEmployee((long) requestData);
			return new ResponseJava(OK, returnCode);
		} catch (Exception e) {
			return new ResponseJava(UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava getEmployee(Serializable requestData) {
		try {
			Employee employee = employees.getEmployee((long) requestData);
			return new ResponseJava(OK, employee);
		} catch (Exception e) {
			return new ResponseJava(UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava getEmployeesSalary(Serializable requestData) {
		try {
			int salaryFrom = ((Map<String, Integer>) requestData).get("salaryFrom");
			int salaryTo = ((Map<String, Integer>) requestData).get("salaryTo");
			Iterable<Employee> employeesSalary = employees.getEmployeesSalary(salaryFrom, salaryTo);
			return new ResponseJava(OK, (Serializable) employeesSalary);
		} catch (Exception e) {
			return new ResponseJava(UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava getCompaniesAvgSalary(Serializable requestData) {
		try {
			List<CompanySalary> companiesAvgSalary = employees.getCompaniesAvgSalary();
			return new ResponseJava(OK, (Serializable) companiesAvgSalary);
		} catch (Exception e) {
			return new ResponseJava(UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava getEmployeesGroupedBySalary(Serializable requestData) {
		try {
			Map<String, List<Employee>> employeesGroupedBySalary = employees
					.getEmployeesGroupedBySalary((int) requestData);
			return new ResponseJava(OK, (Serializable) employeesGroupedBySalary);
		} catch (Exception e) {
			return new ResponseJava(UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava getCompaniesGreaterAvgSalary(Serializable requestData) {
		try {
			List<CompanySalary> companiesGreaterAvgSalary = employees.getCompaniesGreaterAvgSalary();
			return new ResponseJava(OK, (Serializable) companiesGreaterAvgSalary);
		} catch (Exception e) {
			return new ResponseJava(UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava getEmployeesAges(Serializable requestData) {
		try {
			int ageFrom = ((Map<String, Integer>) requestData).get("ageFrom");
			int ageTo = ((Map<String, Integer>) requestData).get("ageTo");
			Iterable<Employee> employeesAges = employees.getEmployeesAges(ageFrom, ageTo);
			return new ResponseJava(OK, (Serializable) employeesAges);
		} catch (Exception e) {
			return new ResponseJava(UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava updateCompany(Serializable requestData) {
		try {
			long id = (long) ((Map<String, Object>) requestData).get("id");
			String newCompany = (String) ((Map<String, Object>) requestData).get("newCompany");
			EmployeesReturnCodes updateCompany = employees.updateCompany(id, newCompany);
			return new ResponseJava(OK, updateCompany);
		} catch (Exception e) {
			return new ResponseJava(UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava updateSalary(Serializable requestData) {
		try {
			long id = (long) ((Map<String, Object>) requestData).get("id");
			int newSalary = (int) ((Map<String, Object>) requestData).get("newSalary");
			EmployeesReturnCodes updateSalary = employees.updateSalary(id, newSalary);
			return new ResponseJava(OK, updateSalary);
		} catch (Exception e) {
			return new ResponseJava(UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava wrongRequest(Serializable requestData) {
		return new ResponseJava(WRONG_REQUEST, "Type of request not found");
	}

}
