package telran.lessons._46_ThreadsRace2.api;

import java.time.LocalDate;
import java.util.Set;
import java.util.function.Function;

public interface InputOutput {
	String inputString(String prompt);

	void display(Object obj);

	default <T> T inputObject(String prompt, String errorMessage, Function<String, T> mapper) {
		T res;
		while (true) {
			String str = inputString(prompt);

			try {
				res = mapper.apply(str);
			} catch (RuntimeException e) {
				res = null;
			}

			if (res != null) {
				break;
			}
			displayLine(errorMessage);
		}
		return res;
	}

	default Integer inputInteger(String prompt, Integer min, Integer max) throws NumberFormatException {
		return (Integer) (inputObject(prompt, String.format("No number in the range [%d - %d]", min, max), (s) -> {
			Integer res = Integer.parseInt(s);
			return ((res >= min && res <= max) ? res : null);
		}));
	}

	default void displayLine(Object obj) {
		display(obj.toString() + "\n");
	}
	
	default String inputName(String prompt) {
		return (String) inputObject(prompt, "Not a name", s -> s);
	}

	default Integer inputInteger(String prompt) {
		return (Integer) inputObject(prompt, "Not a number", s -> Integer.parseInt(s));
	}

	default String inputOptions(String prompt, Set<String> options) {
		return (String) inputObject(prompt, "Not from the list", s -> options.contains(s) ? s : null);
	}

	default LocalDate inputDate(String prompt) {
		return (LocalDate) inputObject(prompt, "Not a date", s -> LocalDate.parse(s));
	}

	default String inputEmail(String prompt) {
		String strBefore = "([^ \\s,]\\p{ASCII}_*)+";
		String strAfter = "\\p{Alpha}{1}(-\\p{Alpha}|\\p{Alpha})*";
		String str = String.format("%1$s@(%2$s\\.){1,3}%2$s$", strBefore, strAfter);
		return (String) inputObject(prompt, "Not email format", s -> s.matches(str) ? s : null);
	}

	default String inputPhoneNumber(String prompt) {
		String str = "(\\+972\\-?|0)5[02-8](\\-?[0-9]){7}";
		return (String) inputObject(prompt, "Not a phone number", s -> s.matches(str) ? s : null);
	}

	default String inputIpV4(String prompt) {
		String numberLess256 = "[01]\\d{2}|\\d{2}|\\d|2[0-4]\\d|25[0-5]";
		String str = String.format("((%1$s)\\.){3}(%1$s)", numberLess256);
		return (String) inputObject(prompt, "Not a IpV4 format", s -> s.matches(str) ? s : null);
	}

}
