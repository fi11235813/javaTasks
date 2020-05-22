package telran.lessons._33_DronesAppl;

public class Height {
	
	private final String NAME;
	private final int HIGHT_LEVEL;
	private int visitCounts;
	private int numbersOfObjectsOnHeight;
	private int permissibleObjectsOnHeight;
	
	public Height(String name, int heightLevel) {
		this(name, heightLevel, 1);
	}
	public Height(String name, int heightLevel, int permissibleObjectsOnHeight) {
		NAME = name;
		HIGHT_LEVEL = heightLevel;
		this.permissibleObjectsOnHeight = permissibleObjectsOnHeight;
	}
	
	public int isFree() {
		return permissibleObjectsOnHeight - numbersOfObjectsOnHeight;
	}
	
	public int getVisitCounts() {
		return visitCounts;
	}
	public void addVisiter() {
		visitCounts++;
	}
	
	public int getNumbersOfObjectsOnHeight() {
		return numbersOfObjectsOnHeight;
	}
	public void addObjectsOnHeight() {
		numbersOfObjectsOnHeight++;
	}
	public void removeObjectsOnHeight() {
		numbersOfObjectsOnHeight--;
	}


	public int getPermissibleObjectsOnHeight() {
		return permissibleObjectsOnHeight;
	}

	public void setPermissibleObjectsOnHeight(int permissibleObjectsOnHeight) {
		this.permissibleObjectsOnHeight = permissibleObjectsOnHeight;
	}
	
	@Override
	public String toString() {
		return String.format("%s%d", NAME, HIGHT_LEVEL);
	}

}
