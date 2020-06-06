package telran.lessons._35_TextOrientedStreams.BullsAndCowsApplication;

import java.util.HashMap;

public class Move {

	private String line;
	private HashMap<BullsCows, Integer> move;
	
	public Move(String line, HashMap<BullsCows, Integer> move) {
		this.line = line;
		this.move = move;
	}

	@Override
	public String toString() {
		return String.format("Your attempt: %s (%d bulls, %d cows)"
				,line, move.getOrDefault(BullsCows.BULLS, 0), move.getOrDefault(BullsCows.COWS, 0));
	}

}
