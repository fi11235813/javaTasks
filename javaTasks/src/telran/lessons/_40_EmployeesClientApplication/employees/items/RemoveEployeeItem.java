package telran.lessons._40_EmployeesClientApplication.employees.items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.employees.api.EmployeesService;

public class RemoveEployeeItem extends EmployeesItem {

	public RemoveEployeeItem(EmployeesService employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {
		return "Remove employee";
	}

	@Override
	public void perform() {
		long id = inputOutput.inputInteger("Enter employee id");
		inputOutput.displayLine(employees.removeEmployee(id));
	}

}
