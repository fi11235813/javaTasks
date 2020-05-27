package telran.lessons._35_TextOrientedStreams.BullsAndCowsApplication;


import java.util.HashMap;
import java.util.Random;


public class BullsAndCowsGame {
	private final int ALL_BULLS_QUANTITY = 4;
	private final Character[] GUESS_NUMBERS;

	public BullsAndCowsGame() {
		GUESS_NUMBERS = generateGuessNumbers();
	}

	public int getALL_BULLS_QUANTITY() {
		return ALL_BULLS_QUANTITY;
	}

	private Character[] generateGuessNumbers() {
		return new Random().ints('1', '9' + 1).distinct().limit(ALL_BULLS_QUANTITY).mapToObj(v -> (char) v)
				.toArray(Character[]::new);
	}

	public Character[] getGUESS_NUMBERS() {
		return GUESS_NUMBERS;
	}

	public HashMap<BullsCows, Integer> getMoveResult(String line) {
		var res = new HashMap<BullsCows, Integer>();
		int limit = line.length() < ALL_BULLS_QUANTITY ? line.length() : ALL_BULLS_QUANTITY;
		line = line.substring(0, limit);
		for (int i = 0; i < GUESS_NUMBERS.length; i++) {
			int index = line.indexOf(GUESS_NUMBERS[i]);
			if (index >= 0) {
				if (index == i) {
					res.merge(BullsCows.BULLS, 1, Integer::sum);
				} else {
					res.merge(BullsCows.COWS, 1, Integer::sum);
				}
			}
		}
		
		return res; 
	}
}
