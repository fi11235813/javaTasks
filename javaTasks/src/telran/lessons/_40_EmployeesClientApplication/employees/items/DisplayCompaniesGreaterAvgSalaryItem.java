package telran.lessons._40_EmployeesClientApplication.employees.items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.employees.api.EmployeesService;

public class DisplayCompaniesGreaterAvgSalaryItem extends EmployeesItem {

	public DisplayCompaniesGreaterAvgSalaryItem(EmployeesService employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {
		return "Display companies with the greater than average salary";
	}

	@Override
	public void perform() {
		inputOutput.displayLine(employees.getCompaniesGreaterAvgSalary());

	}

}
