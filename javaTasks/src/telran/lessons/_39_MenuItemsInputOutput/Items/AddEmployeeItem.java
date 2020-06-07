package telran.lessons._39_MenuItemsInputOutput.Items;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._39_MenuItemsInputOutput.dto.Employee;

public class AddEmployeeItem extends AbstractEmployeesItem {

	public AddEmployeeItem(HashMap<String, Employee> employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {
		return "Add new Employee";
	}

	@Override
	public void perform() {
		String email = inputOutput.inputEmail("Enter email of new Employee");
		String phone = inputOutput.inputPhoneNumber("Enter phone of new Employee");

		Set<String> titleSet = Set.of("Developer", "QA_Tester", "Development_Manager", "QA_Manager");
		String str = String.format("Choose title: %s", titleSet.toString());
		String title = inputOutput.inputOptions(str, titleSet);

		LocalDate birthDate = inputOutput.inputDate("enter date of birth in format YYYY-MM-DD");
		int salary = inputOutput.inputInteger("Enter salary");

		Employee empl = employees.putIfAbsent(email, new Employee(email, phone, title, birthDate, salary));

		if (empl == null)
			inputOutput.display("added");
		else
			inputOutput.display("already exists");
	}

}
