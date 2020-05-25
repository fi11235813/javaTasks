package telran.lessons._35_TextOrientedStreams.BullsAndCowsApplication;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;


public class BullsAndCows {
	private final int ALL_BULLS_QUANTITY = 4;
	private final ArrayList<Integer> GUESS_NUMBERS;
	private TreeMap<Integer, String> historyMap = new TreeMap<>();
	
	
	public BullsAndCows() {
		GUESS_NUMBERS = creatGuessNumbers();
	}


	private ArrayList<Integer> creatGuessNumbers() {
		var res = new ArrayList<Integer>();
		new Random().ints(1, 10).distinct().limit(ALL_BULLS_QUANTITY).forEach(res::add);
		historyMap.put(0, "");
		return res;
	}
	

	public void play() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("The game begin:");
		while(true) {
			String line = scanner.nextLine();
				if(line.equalsIgnoreCase(BullsCowsEnum.EXIT.value)) {
					creatSaveFile();
					break;
				}
				
				if(line.equalsIgnoreCase(BullsCowsEnum.TEST_MODE.value)) {
					GUESS_NUMBERS.forEach(System.out::print);
					System.out.println();
					continue;
				}
				
				int[] inputNumbers = setInputNumberArray(line);
				
				var bullsCowsMap = findBullsAndCows(inputNumbers);
				
				String str = String.format("%d cows, %d bulls", bullsCowsMap.get(BullsCowsEnum.COWS), bullsCowsMap.get(BullsCowsEnum.BULLS));
				
				System.out.println(str);
				
				updateHistoryMap(inputNumbers, bullsCowsMap);
				
				if (bullsCowsMap.get(BullsCowsEnum.BULLS) == ALL_BULLS_QUANTITY) {
					System.out.println("You win!");
					creatSaveFile();
					break;
				}
				
		}
	}
	
	private void updateHistoryMap(int[] inputNumbers, HashMap<BullsCowsEnum, Integer> bullsCowsMap) {
		String str = getStringFromArray(inputNumbers);
		str += String.format("(%d cows, %d bulls)", bullsCowsMap.get(BullsCowsEnum.COWS), bullsCowsMap.get(BullsCowsEnum.BULLS));	
		
		historyMap.put(historyMap.lastKey() + 1, str);
	}


	private String getStringFromArray(int[] inputNumbers) {
		String str = "";
		for(int i = 0; i < inputNumbers.length; i++) {
			if (inputNumbers[i] != 0) str += inputNumbers[i];
			else str += " ";
		}
		return str;
	}
	
	private void creatSaveFile() {
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		String str = String.format("%d-%d-%d_%d_%d_%d", ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth()
				, lt.getHour(), lt.getMinute(), historyMap.size() - 1);
		
		try (PrintWriter printWriter = new PrintWriter(str)) {
			for (int i = 1; i < historyMap.size(); i++) {
				printWriter.println(historyMap.get(i));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private HashMap<BullsCowsEnum, Integer> findBullsAndCows(int[] inputNumbers) {
		var res =  new HashMap<BullsCowsEnum, Integer>();
		res.put(BullsCowsEnum.COWS, 0);
		res.put(BullsCowsEnum.BULLS, 0);
		
		for (int i = 0; i < inputNumbers.length; i++) {
			int indexOf = GUESS_NUMBERS.lastIndexOf(inputNumbers[i]);
			
			if (indexOf == i) {
				res.merge(BullsCowsEnum.BULLS, 1, Integer::sum);
			} else if (indexOf != -1) {
				res.merge(BullsCowsEnum.COWS, 1, Integer::sum);
			}
		}
		
		return res;
	}

	private int[] setInputNumberArray(final String line) {
		int[] res = new int[ALL_BULLS_QUANTITY];
		
		for (int i = 0; i < ALL_BULLS_QUANTITY; i++) {
			String str = String.valueOf(line.charAt(i));
			if (str.matches("\\d")) {
				res[i] = Integer.parseInt(str);
			}
		}
		
		return res;
	}
	
	
	
	
}
