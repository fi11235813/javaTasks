package telran.lessons._40_EmployeesClientApplication.employees.items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.employees.api.EmployeesService;

public class DisplayEmployeesSalaryItem extends EmployeesItem {

	public DisplayEmployeesSalaryItem(EmployeesService employees, InputOutput inputOut) {
		super(employees, inputOut);

	}

	@Override
	public String displayName() {

		return "Display all employees with a given salary";
	}

	@Override
	public void perform() {
		int salaryFrom = inputOutput.inputInteger("Enter salary from");
		int salaryTo = inputOutput.inputInteger("Enter salary to", salaryFrom, Integer.MAX_VALUE);
		inputOutput.displayLine(employees.getEmployeesSalary(salaryFrom, salaryTo));
	}

}
