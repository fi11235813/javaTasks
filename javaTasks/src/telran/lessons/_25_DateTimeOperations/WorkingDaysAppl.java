package telran.lessons._25_DateTimeOperations;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WorkingDaysAppl {

	public static void main(String[] args) {
		LocalDate current = LocalDate.parse("2020-05-02");;
		DayOfWeek[] daysOff = {DayOfWeek.SATURDAY, DayOfWeek.SUNDAY};
		System.out.println(current.with (new WorkingDays(31, daysOff)));//16.06
		System.out.println(current.with (new WorkingDays(4, daysOff)));//08.05
		System.out.println(current.with (new WorkingDays(1, daysOff)));//05.05
		
		DayOfWeek[] daysOff2 = {DayOfWeek.WEDNESDAY};
		System.out.println(current.with (new WorkingDays(30, daysOff2)));//07.06
		
	}

}
