package telran.lessons._40_EmployeesClientApplication.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 13L;
	private long id;
	private String name;
	private LocalDate birthDate;
	private String company;
	private int salary;

	public Employee() {
		super();
	}

	public Employee(long id, String name, LocalDate birthDate, String company, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.company = company;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public int getSalary() {
		return salary;
	}

	public String getCompany() {
		return company;
	}

	public LocalDate getBirthYear() {
		return birthDate;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", company=" + company + ", birthYear=" + birthDate
				+ ", name=" + name + "]";
	}

}
