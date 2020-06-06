package telran.lessons._36_BooksApplication.personsApplication.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import telran.lessons._36_BooksApplication.personsApplication.dto.Employee;
import telran.lessons._36_BooksApplication.personsApplication.dto.Person;

public class PersonRestoreAppl {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persons.data"))) {
			@SuppressWarnings("unchecked")
			List<Person> persons = (List<Person>) ois.readObject();
			persons.forEach(System.out::println);
			System.out.println();

			displayMostPopularCity(persons);
			Map<String, Double> avgSal = getAvgSalaryByTheCompanies(persons);
			displayAvgSalaryByTheCompanies(avgSal);
			displayEmployeesSalaryMoreAvg(persons, avgSal);
		}
	}

	private static void displayEmployeesSalaryMoreAvg(List<Person> persons, Map<String, Double> avgSal) {
		System.out.println("Employees whose salary is higher than the average for the company");
		String str = "Company name: %s, Employees: ";
		getEmployeesStream(persons).collect(Collectors.groupingBy(v -> v.getCompany()
				, Collectors.filtering(v -> Double.compare(v.getSalary(), avgSal.get(v.getCompany())) > 0, Collectors.toList())))
				.forEach((k, v) -> {
					if (!v.isEmpty())
						System.out.println(String.format(str, k) + v);
				});
	}

	private static void displayAvgSalaryByTheCompanies(Map<String, Double> avgSal) {
		System.out.println("Average salary by the companies");
		String str = "Company name: %s, Average salary: %.2f";
		avgSal.forEach((k, v) -> System.out.println(String.format(str, k, v)));
	}

	private static Map<String, Double> getAvgSalaryByTheCompanies(List<Person> persons) {
		return getEmployeesStream(persons).collect(Collectors.groupingBy(
				v -> v.getCompany(), Collectors.averagingInt(v -> v.getSalary())));
	}

	private static void displayMostPopularCity(List<Person> persons) {
		System.out.println("MostPopularCity");
		String str = "City name: %s, Peoples from there: %2d";
		persons.stream().collect(Collectors.groupingBy(v -> v.getAddress().getCity(), Collectors.counting())).entrySet()
				.stream().max((k1, k2) -> Long.compare(k1.getValue(), k2.getValue())).stream()
				.forEach((k) -> System.out.println(String.format(str, k.getKey(), k.getValue())));
	}
	
	private static Stream<Employee> getEmployeesStream(List<Person> persons) {
		return persons.stream().filter(v -> v instanceof Employee).map(v -> (Employee) v);
	}

}
