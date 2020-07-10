package Bumped;

public class Bumped {

	private static int CITIES;
	private static int ROADS; 
	private static int FLIGHTS;
	private static int START;
	private static int DESTINATION;
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		CITIES = io.getInt();
		ROADS = io.getInt();
		FLIGHTS = io.getInt();
		START = io.getInt();
		DESTINATION = io.getInt();
		EdgeWeightedDigraph ewd = new EdgeWeightedDigraph(CITIES);
		for (int i = 0; i < ROADS; i++) {
			int p = io.getInt(); // City1
			int j = io.getInt(); // City2
			int c = io.getInt(); // Cost
			DirectedEdge diEdge = new DirectedEdge(p, j, c);
			DirectedEdge diEdge2 = new DirectedEdge(j, p, c);
			ewd.addEdge(diEdge);
			ewd.addEdge(diEdge2);
			
		}
		Dijkstra dijkstraStart = new Dijkstra(ewd, START);
		Dijkstra dijkstraDest = new Dijkstra(ewd, DESTINATION);
		
		double costTotal = dijkstraStart.distTo(DESTINATION);

		
		
		
		for (int i = 0; i < FLIGHTS; i++) {
			int u = io.getInt(); // City1
			int v = io.getInt(); // City2
			double from = dijkstraStart.distTo(u);
			double to = dijkstraDest.distTo(v);
			double costFlights = from+to;
			if (costFlights < costTotal) {
				costTotal = costFlights; 
			}
			
		}
		io.print((long) costTotal);
		io.close();
	}
	
}
