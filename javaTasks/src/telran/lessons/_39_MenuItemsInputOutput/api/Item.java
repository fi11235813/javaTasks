package telran.lessons._39_MenuItemsInputOutput.api;

public interface Item {
	String displayName();

	void perform();

	default boolean isExit() {
		return false;
	}
}
