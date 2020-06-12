package telran.lessons._40_EmployeesClientApplication.items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;

public class RemoveEployeeItem extends AbstractEmployeesItem {

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
