package telran.lessons._35_TextOrientedStreams.BullsAndCowsApplication;

public enum BullsCowsEnum {
	EXIT("exit"), TEST_MODE("test"), COWS("cows"), BULLS("bulls");

	String value;

	BullsCowsEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
