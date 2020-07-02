package telran.lessons._46_ThreadsRace2.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Competition<T> {
	private Instant start;
	private final int DISTANCE;
	private List<T> resultsTable = new ArrayList<>();
	private final String name;

	public Competition(String name, int distance) {
		this.name = name;
		this.DISTANCE = distance;
	}

	public Instant getStart() {
		return start;
	}

	public void setStart(Instant start) {
		this.start = start;
	}

	public int getDISTANCE() {
		return DISTANCE;
	}

	public List<T> getResultsTable() {
		return resultsTable;
	}

	public String getName() {
		return name;
	}
}
