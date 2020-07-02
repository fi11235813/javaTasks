package telran.lessons._46_ThreadsRace2.api;

public interface Item {
	String displayName();

	void perform();

	default boolean isExit() {
		return false;
	}
}
