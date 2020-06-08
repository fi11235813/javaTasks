package telran.lessons._40_EmployeesClientApplication.employees.items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.employees.api.EmployeesService;
import telran.lessons._40_EmployeesClientApplication.employees.dto.Employee;
import telran.lessons._40_EmployeesClientApplication.employees.dto.EmployeesReturnCodes;

public class UpdateCompanyItem extends EmployeesItem {

	public UpdateCompanyItem(EmployeesService employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {
		return "Update Employee company";
	}

	@Override
	public void perform() {
		long id = inputOutput.inputInteger("Enter Employee id");
		Employee employee = employees.getEmployee(id);
		if (employee == null)
			inputOutput.displayLine(EmployeesReturnCodes.EMPLOYEE_NOT_FOUND);

		String newCompany = inputOutput.inputString("Enter new company name");
		inputOutput.displayLine(employees.updateCompany(id, newCompany));
	}

}