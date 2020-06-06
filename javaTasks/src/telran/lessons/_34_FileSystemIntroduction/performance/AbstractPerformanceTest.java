package telran.lessons._34_FileSystemIntroduction.performance;


public abstract class AbstractPerformanceTest {
	
	private String testName;
	private	Long lastResult;
	
	public AbstractPerformanceTest(String testName) {
		this.testName = testName;
	}
	
	public  void run() {
		long startTime = System.currentTimeMillis();
		runTest();
		long endTime = System.currentTimeMillis();
		lastResult = endTime - startTime;
		
		System.out.println(toString());
	}

	protected abstract void runTest();
	
	@Override
	public String toString() {
		
		return String.format("Test name: %s \n"
				+ "Time in seconds: %.2f \n", testName, lastResult*0.001);
		
	}
	
}
