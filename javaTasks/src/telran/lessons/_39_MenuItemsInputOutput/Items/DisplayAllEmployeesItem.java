package telran.lessons._39_MenuItemsInputOutput.Items;

import java.util.HashMap;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._39_MenuItemsInputOutput.dto.Employee;

public class DisplayAllEmployeesItem extends AbstractEmployeesItem {

	public DisplayAllEmployeesItem(HashMap<String, Employee> employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {

		return "Display all employees";
	}

	@Override
	public void perform() {
		inputOutput.displayLine(employees);
	}

}
