package telran.additionalTasks.singleTrip;

import java.util.HashMap;
import java.util.LinkedList;

public class SingleTrip {
		
	public String determineWay(Ticket[] tickets) {
			var arrival = new HashMap<String, String>();
			
			for(Ticket t : tickets) {
				arrival.put(t.SOURSE, t.DESTINATION);
			}
			
			var ticketList = new LinkedList<String>();
			String destination = null;
			
			for(Ticket t : tickets) {
				if(!arrival.containsValue(t.SOURSE)) {
					destination = t.DESTINATION;
					ticketList.add(t.SOURSE);
					break;
				}
				
			}
			
			while(destination != null) {
				ticketList.add(destination);
				destination = arrival.get(destination);
			}
			
			return ticketList.toString();
		}
		
}
