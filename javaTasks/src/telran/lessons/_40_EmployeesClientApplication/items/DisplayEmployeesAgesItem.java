package telran.lessons._40_EmployeesClientApplication.items;

import static telran.lessons._40_EmployeesClientApplication.api.EmployeeApi.*;
import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;

public class DisplayEmployeesAgesItem extends EmployeesItem {

	public DisplayEmployeesAgesItem(EmployeesService employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {
		return "Display all Employees with a given ages";
	}

	@Override
	public void perform() {
		int ageFrom = inputOutput.inputInteger("Enter age from");
		int ageTo = inputOutput.inputInteger("Enter age to", ageFrom, MAX_AGE);
		inputOutput.displayLine(employees.getEmployeesAges(ageFrom, ageTo));
	}

}
