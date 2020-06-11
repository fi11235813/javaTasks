package telran.lessons._40_EmployeesClientApplication.controllers;

import telran.lessons._39_MenuItemsInputOutput.ConsoleInputOutput;
import telran.lessons._39_MenuItemsInputOutput.api.*;
import telran.lessons._40_EmployeesClientApplication.api.EmployeesService;
import telran.lessons._40_EmployeesClientApplication.items.*;
import telran.lessons._40_EmployeesClientApplication.service.EmployeesTcpProxy;

public class EmployeesClientAppl {
	
	public static void main(String[] args) {
		InputOutput inputOutput = new ConsoleInputOutput();
		EmployeesService employees = new EmployeesTcpProxy("localhost", 5000);
		Item[] items = {
					new AddEmployeeItem(employees, inputOutput),
					new DisplayCompaniesAvgSalaryItem(employees, inputOutput),
					new DisplayCompaniesGreaterAvgSalaryItem(employees, inputOutput),
					new DisplayEmployeeItem(employees, inputOutput),
					new DisplayEmployeesAgesItem(employees, inputOutput),
					new DisplayEmployeesGroupedBySalaryItem(employees, inputOutput),
					new DisplayEmployeesSalaryItem(employees, inputOutput),
					new RandomGenerationItem(employees, inputOutput),
					new RemoveEployeeItem(employees, inputOutput),
					new UpdateCompanyItem(employees, inputOutput),
					new UpdateSalaryItem(employees, inputOutput),
					new ExitItem(employees, inputOutput)
			};
			Menu menu = new Menu(items, inputOutput);
			menu.menuRun();
		}

}
