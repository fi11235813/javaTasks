package lessons._33_DronesAppl;

public class Drone {
	
	public static int nIteration = 0;
	
	private final int seqNumber;
	private Height height;
	private int nPassengers;
	private int startIteration;
	private int finishIteration;
	private int startQueueIteration;
	private int totalAirIterations;
	private int totalQueueIterations;
	public Drone(int seqNumber) {
		this.seqNumber = seqNumber;
	}
	
	public void setHeight(Height height) {
		height.addVisiter();
		this.height = height;
	}
	
	public boolean isFinishIteration() {
		return finishIteration == nIteration;
	}
	
	public int getnPassengers() {
		return nPassengers;
	}
	
	public void takeOff() {
		off();
		startIteration = nIteration;
		nPassengers++;
		
	}
	
	public void off() {
		totalQueueIterations += (nIteration - startQueueIteration); 
	}
	
	public void landingOn() {
		totalAirIterations += (nIteration -  startIteration);
		startQueueIteration = nIteration;
	}

	public void setFinishIteration(int finishIteration) {
		this.finishIteration = nIteration + finishIteration;
	}
	
	public int getTotalAirIterations() {
		return totalAirIterations;
	}
	
	public int getTotalQueueIterations() {
		return totalQueueIterations;
	}
	
	public int getSeqNumber() {
		return seqNumber;
	
	}
	
	public Height clearHeight() {
		height.removeObjectsOnHeight();
		return height;
	}
	
	public int getStartQueueIteration() {
		return startQueueIteration;
	}
	
	@Override
	public String toString() {
		return String.format("Drone Id: %d in air: %d min. transferred: %d pas. in waiting queue: %d min",
				seqNumber, totalAirIterations, nPassengers, totalQueueIterations);
	}
	
}
