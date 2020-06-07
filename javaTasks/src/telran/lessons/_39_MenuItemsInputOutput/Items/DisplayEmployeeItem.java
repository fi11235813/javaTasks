package telran.lessons._39_MenuItemsInputOutput.Items;

import java.util.HashMap;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._39_MenuItemsInputOutput.dto.Employee;

public class DisplayEmployeeItem extends AbstractEmployeesItem {

	public DisplayEmployeeItem(HashMap<String, Employee> employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {
		return "Display employee";
	}

	@Override
	public void perform() {
		String email = inputOutput.inputEmail("Enter employee email");

		Employee empl = employees.get(email);

		if (empl == null)
			inputOutput.display("Not found");
		else
			inputOutput.displayLine(empl);

	}

}
