package telran.lessons._25_DateTimeOperations;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;


public class WorkingDays implements TemporalAdjuster  {
	
	int numbersOfWorkingDays;
	DayOfWeek[] daysOff;
	int quantityDaysAWeek = DayOfWeek.values().length;
	
	public WorkingDays(int numbersOfWorkingDays, DayOfWeek[] daysOff) {
		this.numbersOfWorkingDays = numbersOfWorkingDays;
		this.daysOff = daysOff;
	}
	
	@Override
	public Temporal adjustInto(Temporal temporal) {
		var res = getNextWorkingDay(temporal.plus(1, ChronoUnit.DAYS));
		var quantityFullWeeks = this.numbersOfWorkingDays / quantityDaysAWeek;
		if (quantityFullWeeks != 0) {
			var days = (quantityFullWeeks * daysOff.length) + (quantityFullWeeks * quantityDaysAWeek) + daysOff.length;
			res = res.plus(days, ChronoUnit.DAYS);
		}
		
		var days = this.numbersOfWorkingDays % quantityDaysAWeek;
		
		while(days != 0) {
			res = getNextWorkingDay(res.plus(1, ChronoUnit.DAYS));
			days--;
		}
		
		return res;
	}

	private Temporal getNextWorkingDay(Temporal temporal) {
		var res = temporal;
		while(checkForADayOff(res.get(ChronoField.DAY_OF_WEEK))) {
			res = res.plus(1, ChronoUnit.DAYS);
		}
		
		return res;
	}

	private boolean checkForADayOff(int dayOfWeek) {
		for(DayOfWeek d : daysOff) {
			if (d.getValue() == dayOfWeek) return true;
		}
		
		return false;
	}

}
