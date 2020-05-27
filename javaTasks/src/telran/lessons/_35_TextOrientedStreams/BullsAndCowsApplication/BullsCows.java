package telran.lessons._35_TextOrientedStreams.BullsAndCowsApplication;

public enum BullsCows {
	COWS("cows"), BULLS("bulls");

	String value;

	BullsCows(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
