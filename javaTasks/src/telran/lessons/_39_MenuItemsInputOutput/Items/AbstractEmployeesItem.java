package telran.lessons._39_MenuItemsInputOutput.Items;

import java.util.HashMap;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._39_MenuItemsInputOutput.api.Item;
import telran.lessons._39_MenuItemsInputOutput.dto.Employee;

public abstract class AbstractEmployeesItem implements Item {

	protected HashMap<String, Employee> employees;
	protected InputOutput inputOutput;

	public AbstractEmployeesItem(HashMap<String, Employee> employees, InputOutput inputOutput) {
		this.employees = employees;
		this.inputOutput = inputOutput;
	}

	@Override
	public abstract String displayName();

	@Override
	public abstract void perform();

}
