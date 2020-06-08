package telran.lessons._40_EmployeesClientApplication.employees.items;

import static telran.lessons._40_EmployeesClientApplication.employees.api.EmployeeApi.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._40_EmployeesClientApplication.employees.api.EmployeesService;
import telran.lessons._40_EmployeesClientApplication.employees.dto.Employee;

public class RandomGenerationItem extends EmployeesItem {

	public RandomGenerationItem(EmployeesService employees, InputOutput inputOutput) {
		super(employees, inputOutput);
	}

	@Override
	public String displayName() {
		return "Random Employees generation";
	}

	@Override
	public void perform() {
		int quantityEmployees = inputOutput.inputInteger("Enter quantity of Employees");
		int minId = inputOutput.inputInteger("Enter minimal employee's id [100000 - 999999]", MIN_ID, MAX_ID);
		int maxId = inputOutput.inputInteger("Enter maximal employee's id [100000 - 999999]", MIN_ID, MAX_ID);
		int quantityCompanies = inputOutput.inputInteger("Enter quantity of companies");
		int minSalary = inputOutput.inputInteger("Enter minimal salary [5000-50000]", MIN_SALARY, MAX_SALARY);
		int maxSalary = inputOutput.inputInteger("Enter maximal salary [5000-50000]", MIN_SALARY, MAX_SALARY);
		LocalDate minBirthDate = inputOutput.inputDate("Enter minimal birth date YYYY-MM-DD");
		LocalDate miaxBirthDate = inputOutput.inputDate("Enter maximal birth date YYYY-MM-DD");

		List<Employee> listEmployees = new LinkedList<>();

		for (int i = 0; i < quantityEmployees; i++) {
			String name = "name" + i;
			long id = randomNumber(minId, maxId);
			while (employees.getEmployee(id) != null) {
				id = randomNumber(minId, maxId);
			}
			String company = "company" + randomNumber(0, quantityCompanies);
			int salary = randomNumber(minSalary, maxSalary);

			long periodInDays = minBirthDate.until(miaxBirthDate, ChronoUnit.DAYS);
			int days = randomNumber(0, (int) periodInDays);
			LocalDate birthDate = minBirthDate.plusDays(days);
			Employee empl = new Employee(id, name, birthDate, company, salary);
			listEmployees.add(empl);
			employees.addEmployee(empl);
		}

		inputOutput.displayLine(listEmployees);
	}

	private int randomNumber(int min, int max) {
		return (int) (min + Math.random() * (max - min));
	}

}
