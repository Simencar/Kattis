package WheresMyInternet;

import java.util.LinkedList;

public class Graph {
	private final int V; // number of vertices
	private int E; // number of edges
	private LinkedList<Integer> adj []; // adjacency lists

	public Graph(int V) {
		this.V = V+1;
		this.E = 0;
		adj = new LinkedList[V+1]; // Create array of lists.
		for (int v = 1; v < V+1; v++) // Initialize all lists
			adj[v] = new LinkedList(); // to empty.
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v’s list.
		adj[w].add(v); // Add v to w’s list.
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}