package telran.lessons._40_EmployeesClientApplication.items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;

public class DisplayCompaniesGreaterAvgSalaryItem extends AbstractEmployeesItem {

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
