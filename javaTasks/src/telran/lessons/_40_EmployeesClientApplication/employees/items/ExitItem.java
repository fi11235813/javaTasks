package telran.lessons._40_EmployeesClientApplication.employees.items;

import java.io.Closeable;
import java.io.IOException;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.employees.api.EmployeesService;

public class ExitItem extends EmployeesItem {

	public ExitItem(EmployeesService employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {
		return "Exit";
	}

	@Override
	public void perform() {
		if (employees instanceof Closeable) {
			try {
				((Closeable) employees).close();
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	@Override
	public boolean isExit() {
		return true;
	}

}
