package telran.lessons._36_BooksApplication.personsApplication.dto;

import java.time.LocalDate;

public class Employee extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String company;
	private String title;
	private int salary;

	public Employee() {
		super();
	}

	public Employee(int id, Address address, String name, LocalDate birthDate, String company, String title,
			int salary) {
		super(id, address, name, birthDate);
		this.company = company;
		this.title = title;
		this.salary = salary;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [company=" + company + ", title=" + title + ", salary=" + salary + ", getAddress()="
				+ getAddress() + ", getId()=" + getId() + ", getName()=" + getName() + ", getBirthDate()="
				+ getBirthDate() + "]";
	}

}
