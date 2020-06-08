package telran.lessons._40_EmployeesClientApplication.employees.items;

import java.time.LocalDate;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import static telran.lessons._40_EmployeesClientApplication.employees.api.EmployeeApi.*;
import telran.lessons._40_EmployeesClientApplication.employees.api.EmployeesService;
import telran.lessons._40_EmployeesClientApplication.employees.dto.Employee;
import telran.lessons._40_EmployeesClientApplication.employees.dto.EmployeesReturnCodes;

public class AddEmployeeItem extends EmployeesItem {

	public AddEmployeeItem(EmployeesService employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {
		return "Add Employee";
	}

	@Override
	public void perform() {
		long id = inputOutput.inputInteger("Enter employee's id [100000 - 999999]", MIN_ID, MAX_ID);
		Employee employee = employees.getEmployee(id);
		if (employee != null) {
			inputOutput.displayLine("Employee already exiats");
			return;
		}
		int salary = inputOutput.inputInteger("Enter salary [5000-50000]", MIN_SALARY, MAX_SALARY);
		String company = inputOutput.inputString("Enter company name");
		LocalDate birthDate = inputOutput.inputDate("Enter birthdate YYYY-MM-DD");
		String name = inputOutput.inputString("Enter name");
		Employee empl = new Employee(id, name, birthDate, company, salary);
		EmployeesReturnCodes res = employees.addEmployee(empl);
		inputOutput.displayLine(res);
	}

}
