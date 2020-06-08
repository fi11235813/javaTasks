package telran.lessons._40_EmployeesClientApplication.employees.items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.employees.api.EmployeesService;

public class DisplayEmployeesGroupedBySalaryItem extends EmployeesItem {

	public DisplayEmployeesGroupedBySalaryItem(EmployeesService employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {
		return "Display employees groupe by salary";
	}

	@Override
	public void perform() {
		int interval = inputOutput.inputInteger("Enter interval");
		inputOutput.displayLine(employees.getEmployeesGroupedBySalary(interval));
	}

}
