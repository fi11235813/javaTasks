package telran.additionalTasks.singleTrip;

public class Test {

	public static void main(String[] args) {
		Ticket[] tickets = {
				new Ticket("JPN","PHL"),
				new Ticket("BRA","UAE"),
				new Ticket("USA","BRA"),
				new Ticket("UAE","JPN")
		};
		
		System.out.println(new SingleTrip().determineWay(tickets));
	}

}
