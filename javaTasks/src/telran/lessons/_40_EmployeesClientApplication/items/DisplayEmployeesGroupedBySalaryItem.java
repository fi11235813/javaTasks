package telran.lessons._40_EmployeesClientApplication.items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;

public class DisplayEmployeesGroupedBySalaryItem extends AbstractEmployeesItem {

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
