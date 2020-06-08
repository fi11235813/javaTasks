package telran.lessons._40_EmployeesClientApplication.api;

import java.util.List;
import java.util.Map;

import telran.lessons._40_EmployeesClientApplication.dto.CompanySalary;
import telran.lessons._40_EmployeesClientApplication.dto.Employee;
import telran.lessons._40_EmployeesClientApplication.dto.EmployeesReturnCodes;

public interface EmployeesService {
	EmployeesReturnCodes addEmployee(Employee empl);

	EmployeesReturnCodes removeEmployee(long id);

	Employee getEmployee(long id);

	Iterable<Employee> getEmployeesSalary(int salaryFrom, int salaryTo);

	List<CompanySalary> getCompaniesAvgSalary();

	Map<String, List<Employee>> getEmployeesGroupedBySalary(int interval);

	List<CompanySalary> getCompaniesGreaterAvgSalary();

	Iterable<Employee> getEmployeesAges(int ageFrom, int ageTo);

	EmployeesReturnCodes updateCompany(long id, String newCompany);

	EmployeesReturnCodes updateSalary(long id, int newSalary);

}
