package telran.lessons._40_EmployeesClientApplication.items;

import java.io.Closeable;
import java.io.IOException;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;

public class ExitItem extends AbstractEmployeesItem {

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
				throw new RuntimeException("Wrong closing" + e.getMessage());
			}
		}
	}

	@Override
	public boolean isExit() {
		return true;
	}

}
