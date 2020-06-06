package telran.lessons._26_PrintCalendarApplication;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalendarAppl {
	private static Locale locale = Locale.US;
	private static int columnWidth = 4;
	private static DayOfWeek[] daysOfWeek = DayOfWeek.values();
	
	public static void main(String[] args) {
		int[] yearMonth; //[0] - number of year, 
						//	[1] - number of month
		try {
			yearMonth = getYearMonth(args);
			printCalendar(yearMonth[0], yearMonth[1]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
/**
 * 
 * @param args : if args.length == 0|1, year - current year,
 * month - current month
 * if args.length > 0 set first day of the week
 * For example: SUN" "day#44-- 2021 2
 * @return [0] - number of year,
 * [1] - number of month
 */
	private static int[] getYearMonth(String[] args) {
		if (args.length == 0) {
			return getCurrentYearMonth();
		}
		var dayOfWeek = DayOfWeek.valueOf(args[0].replaceAll("[^\\p{Alpha}]","").toUpperCase(locale));
		setArrayDaysOfWeek(dayOfWeek);
		
		if (args.length == 1) {
			return getCurrentYearMonth();
		}
		
		int year = Integer.parseInt(args[1]);
		int month = Integer.parseInt(args[2]);
		
		
		return new int[] {year, month};
	}

	private static void setArrayDaysOfWeek(DayOfWeek dayOfWeek) {
		for(int i = 0; i < daysOfWeek.length; i++) {
			daysOfWeek[i] = dayOfWeek;
			dayOfWeek = dayOfWeek.plus(1);
		}
	}
	private static int[] getCurrentYearMonth() {
	LocalDate current = LocalDate.now();
	return new int[] {current.getYear(), current.getMonthValue()};
}
	private static void printCalendar(int year, int month) {
		printTitle(year, month);
		printDaysOfWeek();
		printDates(year, month);
		
	}
	private static void printDates(int year, int month) {
		int firstDayOfWeek = getFirstDayOfWeek(year, month);
		printOffset((firstDayOfWeek - 1) * columnWidth);
		int lastDay = getLastDay(year, month);
		for (int day = 1; day <= lastDay; day++) {
			System.out.printf("%" + columnWidth + "d", day);
			firstDayOfWeek++;
			if(firstDayOfWeek == 8) {
				firstDayOfWeek = 1;
				System.out.println();
			}
		}
	}
	private static int getFirstDayOfWeek(int year, int month) {
		LocalDate date = LocalDate.of(year, month, 1);
		var dayOfWeek = date.getDayOfWeek();
		int i = 0;
		for(;i < daysOfWeek.length; i++) {
			if(daysOfWeek[i] == dayOfWeek) {
				break;
			}
				
		}
		return i + 1;
	}
	private static void printOffset(int offset) {
		// JDK from 11
		
		String space = " ".repeat(offset);
		System.out.print(space);
	}
	private static int getLastDay(int year, int month) {
		YearMonth yearMonth = YearMonth.of(year, month);
		return yearMonth.lengthOfMonth();
	}
	private static void printDaysOfWeek() {
		printOffset(columnWidth / 2);
		
		for(DayOfWeek dayOfWeek : daysOfWeek) {
			System.out.printf(dayOfWeek.getDisplayName(TextStyle.SHORT, locale) + " ");
		}
		System.out.println();
	}
	private static void printTitle(int year, int month) {
		Month monthConst = Month.of(month);
		System.out.printf("\t%s, %d\n", monthConst.getDisplayName(TextStyle.FULL, locale), year);
		
	}
	
	
	
}
