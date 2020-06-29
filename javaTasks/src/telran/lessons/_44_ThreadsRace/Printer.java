package telran.lessons._44_ThreadsRace;

public class Printer extends Thread {
	private String str;
	private volatile boolean running = true;
	private final int ID = (int) getId();
	
	@Override
	public void run() {
		int index = 0;
		int length = str.length();
		while(running) {
			System.out.println(ID + ": " + str.charAt(index));
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				index++;
				if (index == length) {
					index = 0;
				}
			}
		}
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}
