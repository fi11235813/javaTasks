package telran.lessons._40_EmployeesClientApplication.employees.items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.employees.api.EmployeesService;

public class DisplayCompaniesAvgSalaryItem extends EmployeesItem {

	public DisplayCompaniesAvgSalaryItem(EmployeesService employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {
		return "Display the average salary by companies";
	}

	@Override
	public void perform() {
		inputOutput.displayLine(employees.getCompaniesAvgSalary());
	}

}
