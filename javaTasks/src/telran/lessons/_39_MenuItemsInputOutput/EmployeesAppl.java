package telran.lessons._39_MenuItemsInputOutput;

import java.util.HashMap;

import telran.lessons._39_MenuItemsInputOutput.Items.AddEmployeeItem;
import telran.lessons._39_MenuItemsInputOutput.Items.DisplayAllEmployeesItem;
import telran.lessons._39_MenuItemsInputOutput.Items.DisplayEmployeeItem;
import telran.lessons._39_MenuItemsInputOutput.Items.ExitItem;
import telran.lessons._39_MenuItemsInputOutput.Items.RemoveEmployeeItem;
import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._39_MenuItemsInputOutput.api.Item;
import telran.lessons._39_MenuItemsInputOutput.api.Menu;
import telran.lessons._39_MenuItemsInputOutput.dto.Employee;

public class EmployeesAppl {

	static InputOutput inputOutput = new ConsoleInputOutput();
	static HashMap<String, Employee> employees = new HashMap<>();

	public static void main(String[] args) {
		Item[] items = { new AddEmployeeItem(employees, inputOutput),
				new DisplayAllEmployeesItem(employees, inputOutput), new DisplayEmployeeItem(employees, inputOutput),
				new RemoveEmployeeItem(employees, inputOutput), new ExitItem() };

		Menu menu = new Menu(items, inputOutput);
		menu.menuRun();

	}
}
