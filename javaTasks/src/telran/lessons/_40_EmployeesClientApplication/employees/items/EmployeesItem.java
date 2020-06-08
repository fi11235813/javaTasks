package telran.lessons._40_EmployeesClientApplication.employees.items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._39_MenuItemsInputOutput.api.Item;
import telran.lessons._40_EmployeesClientApplication.employees.api.EmployeesService;

public abstract class EmployeesItem implements Item {

	EmployeesService employees;
	InputOutput inputOutput;

	public EmployeesItem(EmployeesService employees, InputOutput inputOutput) {
		super();
		this.employees = employees;
		this.inputOutput = inputOutput;
	}
}
