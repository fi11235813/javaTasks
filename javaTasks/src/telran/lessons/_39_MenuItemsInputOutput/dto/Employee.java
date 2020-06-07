package telran.lessons._39_MenuItemsInputOutput.dto;

import java.time.LocalDate;

public class Employee {
	String email;
	String phone;
	String title;
	LocalDate birthDate;
	int salary;
	public Employee(String email, String phone, String title, LocalDate birthDate, int salary) {
		this.email = email;
		this.phone = phone;
		this.title = title;
		this.birthDate = birthDate;
		this.salary = salary;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getEmail() {
		return email;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	@Override
	public String toString() {
		return "Employee [email=" + email + ", phone=" + phone + ", title=" + title + ", birthDate=" + birthDate
				+ ", salary=" + salary + "]";
	}
}
