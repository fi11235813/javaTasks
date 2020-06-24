package telran.lessons._45_PrintersShcedulingPortiions;

public class Printer extends Thread {
	private static int nPortions;
	private final int ID;
	volatile Thread nextThread;
	private static int nNumbers;

	public Printer(int ID) {
		this.ID = ID;
	}

	@Override
	public void run() {
		int length = 0;
		int nNumbers = Printer.nNumbers;
		
		while (nNumbers > 0) {
			try {
				sleep(500000);
			} catch (InterruptedException e) {
				
			}

			length = nPortions <= nNumbers ? nPortions : nNumbers;

			for (int j = 0; j < length; j++) {
				System.out.print(ID);
			}
			System.out.println();
			nNumbers -= length;
			nextThread.interrupt();
		}

	}
	
	public void setNextThread(Thread nextThread) {
		this.nextThread = nextThread;
	}

	public static void setnPortions(int nPortions) {
		Printer.nPortions = nPortions;
	}

	public static void setnNumbers(int nNumbers) {
		Printer.nNumbers = nNumbers;
	}
	
}
