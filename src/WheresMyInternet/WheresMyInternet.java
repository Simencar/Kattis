package WheresMyInternet;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class WheresMyInternet {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int n = io.getInt(); // number of houses
		int m = io.getInt(); // number of cables
		Graph graph = new Graph(n);

		for (int i = 0; i < m; i++) {
			graph.addEdge(io.getInt(), io.getInt());
		}

		DepthFirstSearch dfs = new DepthFirstSearch(graph, 1);
		if (dfs.count() == n) { // every house is connected
			io.println("Connected");

		} else {
			StringBuilder s = new StringBuilder();
			for (int i = 1; i < graph.V(); i++) {
				if (!dfs.marked(i)) { // save house-number to string if its not connected(takes less time printing
										// after loop)
					s.append(i + "\n");
				}
			}
			io.print(s);
		}
		io.close();
	}

}
