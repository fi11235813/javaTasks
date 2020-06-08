package telran.lessons._40_EmployeesClientApplication.items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;
import telran.lessons._40_EmployeesClientApplication.dto.Employee;
import telran.lessons._40_EmployeesClientApplication.dto.EmployeesReturnCodes;

public class DisplayEmployeeItem extends EmployeesItem {

	public DisplayEmployeeItem(EmployeesService employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {
		return "Display employee";
	}

	@Override
	public void perform() {
		long id = inputOutput.inputInteger("Enter employee id");

		Employee empl = employees.getEmployee(id);

		if (empl == null)
			inputOutput.displayLine(EmployeesReturnCodes.EMPLOYEE_NOT_FOUND);
		else
			inputOutput.displayLine(empl);

	}

}
