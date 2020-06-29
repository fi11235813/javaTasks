package telran.lessons._44_ThreadsRace;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PrinterAppl {
 
	
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			//Printer printer = null;
			HashMap<Integer, Printer> map = new HashMap<Integer, Printer>();
			
			for(int i = 0; i < 1; i++) {
				Printer printer = new Printer();
				map.put(i, printer);
			}
			
			Set<Integer> keySet = map.keySet();
			
			for(Integer i : keySet) {
				map.get(i).setStr(scanner.nextLine());
			}
			
			for(Integer i : keySet) {
				map.get(i).start();
			}
			
			String line = null;
			while(true) {
				line = scanner.nextLine();
				if (line.equals("q")) {
					
					break;
				}
				
				map.get(Integer.parseInt(line)).interrupt();
			}
			
			for(Integer i : keySet) {
				map.get(i).setRunning(false);
			}
			
			
		}
}
