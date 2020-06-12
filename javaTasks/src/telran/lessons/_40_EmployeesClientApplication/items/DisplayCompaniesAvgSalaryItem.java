package telran.lessons._40_EmployeesClientApplication.items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;

public class DisplayCompaniesAvgSalaryItem extends AbstractEmployeesItem {

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
