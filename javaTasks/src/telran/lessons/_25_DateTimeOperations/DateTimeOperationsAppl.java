package telran.lessons._25_DateTimeOperations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeOperationsAppl {
	private static String[] ids = TimeZone.getAvailableIDs();
	
	static public void displayCompleteAge(String strBirthdate) {
		LocalDate birthDate = null;
		var builder = new DateTimeFormatterBuilder();
		builder.appendOptional(DateTimeFormatter.ISO_DATE);
		builder.appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		try {
			birthDate = LocalDate.parse(strBirthdate, builder.toFormatter());
		} catch (DateTimeParseException e) {
			System.err.println("Birth date format not recognized, try again");
		}
		
		if (birthDate != null) {
			LocalDate localDate = LocalDate.now();
			Period p = Period.between(birthDate, localDate); 
			System.out.println(p.getYears() + "\\" + p.getMonths() + "\\" + p.getDays());
		}
	}
	
	
	static public void displayTimeZoneId(String zonePattern) {
		LinkedList<String> listIDs = new LinkedList<>();
		for (String id : ids) {
			if(id.toLowerCase(Locale.US).contains(zonePattern.toLowerCase(Locale.US))) {
				listIDs.add(id);
			}
		}
		for(String id : listIDs) {
			LocalTime localTime = LocalTime.now(ZoneId.of(id));
			System.out.println(String.format("%s %.8s", id, localTime));
		}
		
		
	}
	
	public static void main(String[] args) {
		displayCompleteAge ("1799-06-06");
		displayCompleteAge ("06/06/1799");
		displayCompleteAge ("06.06.1799");
		
		displayTimeZoneId("CAnada");
	}
}
