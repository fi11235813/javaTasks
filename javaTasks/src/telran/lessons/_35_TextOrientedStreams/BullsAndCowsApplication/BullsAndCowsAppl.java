package telran.lessons._35_TextOrientedStreams.BullsAndCowsApplication;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class BullsAndCowsAppl {
	private static boolean testMode; 
	private static BullsAndCowsGame game;
	private static Scanner scanner;
	private static HashMap<BullsCows, Integer> moveResult;
	private static LinkedList<Move> moves = new LinkedList<>();
	private static final String FILE_NAME_PATTERN = "YYYY-MM-dd_HH_mm";
	
	public static void main(String[] args) {
		testMode = args.length > 0 && args[0].equalsIgnoreCase("test");
		scanner = new Scanner(System.in);
		while(startGame());
	}

	private static boolean startGame() {
		game = new BullsAndCowsGame();
		if(testMode) System.out.println(Arrays.deepToString(game.getGUESS_NUMBERS()));
		moves.clear();
		play();
		
		System.out.println("Do you want to start a new game Y/N");
		
		return scanner.nextLine().equalsIgnoreCase("Y");
	}

	private static void play() {
		System.out.println("The game is starting, you should guess 4 numbers");
		while(true) {
			String line = scanner.nextLine();
			
			if(!moves.isEmpty()) {
				moves.forEach(System.out::println);
			}
			moveResult = game.getMoveResult(line);
			nextMove(line);
			
			if (moveResult.getOrDefault(BullsCows.BULLS, 0) == game.getALL_BULLS_QUANTITY()) {
				System.out.println("Congratulations you have guessed number for " + moves.size() + "move(s)");
				finishGame();
				break;
			}
		}
	}

	private static void finishGame() {
		String fileName = creatFileName();
		try (PrintWriter writer = new PrintWriter(fileName)) {
			moves.forEach(writer::println);
		} catch (FileNotFoundException e) {
			System.out.println("Save file can't be created " + e.getMessage());
		}
	}

	private static String creatFileName() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern(FILE_NAME_PATTERN);
		
		return ldt.format(f) + "_" + moves.size();
	}

	private static void nextMove(String line) {
		Move move = new Move(line, moveResult);
		moves.addLast(move);
		System.out.println(move);
	}

}
