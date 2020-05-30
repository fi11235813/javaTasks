package telran.lessons._36_BooksApplication.personsApplication.controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import telran.lessons._36_BooksApplication.personsApplication.dto.*;

public class PersonRendomCreationAppl {

	private static final long PERSONS_LIMIT = 10;
	private static final int PROBABILITY_OF_CHILD = 30;
	private static final int MAX_ID = 1000;
	private static final CharSequence EPOCH = "1900-01-01";
	private static final long MAX_CHILD_AGE = 18;
	private static final int MAX_nCITY = 5;
	private static final int MAX_nSTREET = 300;

	private static final int MAX_nBUILDING = 300;
	private static final int MAX_nAPRT = 1500;
	private static final int MAX_nNAME = 70;
	private static final int MAX_nCOMPANY = 5;
	private static final int MAX_SALARY = 10_000;
	private static final int MIN_SALARY = 1000;
	private static final int MAX_nGARTEN = 50;
	private static TreeSet<Integer> idSet = new TreeSet<>();
	private static LinkedList<String> titleList = new LinkedList<>();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		setTitles();
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persons.data"))) {
			oos.writeObject(getPersonsArray());
		}

	}

	private static void setTitles() {
		titleList.add("QA tester");
		titleList.add("Development Programmer");
		titleList.add("Developmant Manager");
		titleList.add("QA Manager");
	}

	private static List<Person> getPersonsArray() {
		return Stream.generate(PersonRendomCreationAppl::getPerson).distinct().limit(PERSONS_LIMIT)
				.collect(Collectors.toList());
	}

	private static Person getPerson() {
		return PROBABILITY_OF_CHILD > new Random().nextInt(100) ? creatChild() : creatEmployee();
	}

//	private static LocalDate getDayOfMajority() {
//		return LocalDate.now().minusYears(MAX_CHILD_AGE);
//	}

	private static Person creatEmployee() {
		LocalDate dateMax = LocalDate.now().minusYears(MAX_CHILD_AGE);
		LocalDate dateMin = LocalDate.parse(EPOCH);

		LocalDate birthDate = creatBirthDate(dateMin, dateMax);

		return creatEmployee(birthDate);
	}

	private static Person creatChild() {
		LocalDate dateMax = LocalDate.now();
		LocalDate dateMin = dateMax.minusYears(MAX_CHILD_AGE);

		LocalDate birthDate = creatBirthDate(dateMin, dateMax);

		String garten = creatChildName();

		return creatChild(birthDate, garten);
	}

	private static String creatChildName() {
		return "garten" + genNumber(1, MAX_nGARTEN);
	}

	private static Child creatChild(LocalDate birthDate, String garten) {

		return new Child(creatPersonId(), creatPersonAdress(), creatPersonName(), birthDate, garten);
	}

	private static int creatPersonId() {
		int id = new Random().nextInt(MAX_ID);
		while (!idSet.add(id)) {
			id = new Random().nextInt(MAX_ID);
		}

		return id;
	}

	private static LocalDate creatBirthDate(LocalDate dateMin, LocalDate dateMax) {
		long periodInDays = dateMin.until(dateMax, ChronoUnit.DAYS);
		int days = new Random().nextInt((int) periodInDays);

		return dateMin.plusDays(days);
	}

	private static Address creatPersonAdress() {
		String city = "city" + genNumber(1, MAX_nCITY);
		String street = "street" + genNumber(1, MAX_nSTREET);
		int building = genNumber(1, MAX_nBUILDING);
		int aprt = genNumber(1, MAX_nAPRT);

		return new Address(city, street, building, aprt);
	}

	private static int genNumber(int min, int max) {
		return (int) (min + Math.random() * (max - min));
	}

	private static String creatPersonName() {
		return "name" + genNumber(1, MAX_nNAME);
	}

	private static Employee creatEmployee(LocalDate birthDate) {
		String company = "company" + genNumber(1, MAX_nCOMPANY);
		String title = titleList.get(genNumber(0, titleList.size() - 1));
		int salary = genNumber(MIN_SALARY, MAX_SALARY);

		return new Employee(creatPersonId(), creatPersonAdress(), creatPersonName(), birthDate, company, title, salary);
	}
}
