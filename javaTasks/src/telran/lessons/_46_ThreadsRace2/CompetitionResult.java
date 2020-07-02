package telran.lessons._46_ThreadsRace2;

public class CompetitionResult implements Result {
	
	private String name;
	private long time;
	
	public CompetitionResult(String name, long time) {
		super();
		this.name = name;
		this.time = time;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public long getTime() {
		return time;
	};
	
}
