package telran.lessons._36_BooksApplication.personsApplication.dto;

import java.time.LocalDate;

public class Child extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private String garten;

	public Child() {
		super();
	}

	public Child(int id, Address address, String name, LocalDate birthDate, String garten) {
		super(id, address, name, birthDate);
		this.garten = name;
	}

	public String getGarten() {
		return garten;
	}

	@Override
	public String toString() {
		return "Child [garten=" + garten + ", getAddress()=" + getAddress() + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getBirthDate()=" + getBirthDate() + "]";
	}

	public void setGarten(String garten) {
		this.garten = garten;
	}

}
