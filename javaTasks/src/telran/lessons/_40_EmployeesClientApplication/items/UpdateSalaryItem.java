package telran.lessons._40_EmployeesClientApplication.items;

import static telran.lessons._40_EmployeesClientApplication.api.EmployeeApi.*;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;
import telran.lessons._40_EmployeesClientApplication.dto.Employee;
import telran.lessons._40_EmployeesClientApplication.dto.EmployeesReturnCodes;

public class UpdateSalaryItem extends EmployeesItem {

	public UpdateSalaryItem(EmployeesService employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {
		return "Update Employee salary";
	}

	@Override
	public void perform() {
		long id = inputOutput.inputInteger("Enter Employee id");
		Employee employee = employees.getEmployee(id);
		if (employee == null)
			inputOutput.displayLine(EmployeesReturnCodes.EMPLOYEE_NOT_FOUND);
		
		int newSalary = inputOutput.inputInteger("Enter new salary [5000-50000]", MIN_SALARY, MAX_SALARY);
		inputOutput.displayLine(employees.updateSalary(id, newSalary));

	}

}
