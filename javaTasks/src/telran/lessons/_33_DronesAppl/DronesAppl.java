package telran.lessons._33_DronesAppl;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class DronesAppl {
	private static final int N_DRONES = 20;
	private static final int N_HEIGHTS = 15;
	private static final int MIN_PASSENGER_TIME = 1;
	private static final int MAX_PASSENGER_TIME = 15;
	private static final int MODEL_TIME = 240;
	static Drone[] drones;
	static List<Drone> dronesInAir;
	static Queue<Drone> dronesInQueue;
	static final Height[] heights = new Height[N_HEIGHTS];	

		public static void main(String[] args) {
			preProcessing();
			play();
			postProcessing();
			displayResults();

		}

		private static void displayResults() {
			displayDronesInfo();
			displayHeightsCountsInfo();
			displayMostPopularHeights();
		}

		private static void displayMostPopularHeights() {
			List<Height> list = Arrays.stream(heights).collect(Collectors.groupingBy(i -> i.getVisitCounts())).entrySet()
			.stream().max((i, j) -> Integer.compare(i.getKey(), j.getKey())).stream()
			.flatMap(h -> h.getValue().stream()).collect(Collectors.toList());
			
			System.out.println(list);
}

		private static void displayHeightsCountsInfo() {
			for(Height height : heights) {
				System.out.println(String.format("%s: %d flights", height, height.getVisitCounts()));
			}
		}

		private static void displayDronesInfo() {
			for(Drone drone : drones) {
				System.out.println(drone.toString());
			}
		}

		private static void postProcessing() {
			landingAllDrones();
			closingShop();
		}

		private static void closingShop() {
			Iterator<Drone> it = dronesInQueue.iterator(); 
			while(it.hasNext()) {
				Drone drone = it.next();
				drone.off();
				it.remove();
			}
		}

		private static void landingAllDrones() {
			Iterator<Drone> it = dronesInAir.iterator(); 
			while(it.hasNext()) {
				Drone drone = it.next();
				drone.landingOn();
				it.remove();
			}
		}

		private static void play() {
			for (int i = 1; i <= MODEL_TIME; i++) {
				Drone.nIteration++;
				List<Height> freedHeights = landingOnIteration();
				takingOffOnIteration(freedHeights);
				
			}
			
		}

		private static void takingOffOnIteration(List<Height> freedHeights) {
			if (freedHeights.isEmpty()) {
				return;
			}
			
			for (Height height : freedHeights) {
					takeOff(dronesInQueue.remove(), height);
			}
		}

		private static List<Height> landingOnIteration() {
			List<Height> res = new ArrayList<>();
			Iterator<Drone> it = dronesInAir.iterator();
			while(it.hasNext()) {
				Drone drone = it.next();
				if (drone.isFinishIteration()) {
					it.remove();
					drone.landingOn();
					putInQueue(drone);
					res.add(drone.clearHeight());
				}
			}
			return res;
		}

		private static void preProcessing() {
			createDrones();
			createHeights();
			initializeInAir();
			startDronesInAir();
			startDronesInQueue();
			
		}

		private static void startDronesInQueue() {
			for(int i = N_HEIGHTS; i < N_DRONES; i++) {
				putInQueue(drones[i]);
			}
			
		}

		private static void putInQueue(Drone drone) {
			dronesInQueue.add(drone);
		}

		private static void startDronesInAir() {
			for (int i = 0; i < N_HEIGHTS; i++) {
				takeOff(drones[i], heights[i]);
			}
			
		}

		private static void takeOff(Drone drone, Height height) {
			dronesInAir.add(drone);
			int iterationsInAir = getIterationsInAir();
			drone.setFinishIteration(iterationsInAir);
			drone.setHeight(height);
			drone.takeOff();
		}

		private static int getIterationsInAir() {
			
			return (int) (MIN_PASSENGER_TIME +
					Math.random() * (MAX_PASSENGER_TIME -
							MIN_PASSENGER_TIME + 1));
		}

		
		
		private static void initializeInAir() {
			dronesInAir = new LinkedList<Drone>();
			dronesInQueue = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getStartQueueIteration(), e2.getStartQueueIteration()));
		}
		
		private static void createDrones() {
			drones = IntStream.range(1, N_DRONES + 1).mapToObj(i -> new Drone(i)).toArray(Drone[]::new);
		}
		
		private static void createHeights() {
			for(int i = 0; i < N_HEIGHTS; i++) {
				heights[i] = new Height("Height", i + 1);
			}
		}
		


}
