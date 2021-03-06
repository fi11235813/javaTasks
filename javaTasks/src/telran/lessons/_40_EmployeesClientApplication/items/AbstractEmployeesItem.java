package telran.lessons._40_EmployeesClientApplication.items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._39_MenuItemsInputOutput.api.Item;
import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;

public abstract class AbstractEmployeesItem implements Item {

	protected EmployeesService employees;
	protected InputOutput inputOutput;

	public AbstractEmployeesItem(EmployeesService employees, InputOutput inputOutput) {
		super();
		this.employees = employees;
		this.inputOutput = inputOutput;
	}
	
}
