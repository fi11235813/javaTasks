package telran.lessons._45_PrintersShcedulingPortiions;

public class PrinterController {
	private final static int N_PRINTERS = 4;
	private final static int N_NUMBERS = 9;
	private final static int N_PORTIONS = 5;
	private static Printer[] printers = new Printer[N_PRINTERS];
	
	public static void main(String[] args) {
		
		Printer.setnPortions(N_PORTIONS);
		Printer.setnNumbers(N_NUMBERS);
		for (int i = 0; i < N_PRINTERS; i++) {
			printers[i] = new Printer(i + 1);
			printers[i].start();
		}
		
		for (int i = N_PRINTERS - 2; i >= 0; i--) {
			printers[i].setNextThread(printers[i + 1]);
		}
		printers[printers.length - 1].setNextThread(printers[0]);
		
		printers[0].interrupt();
	}

}
