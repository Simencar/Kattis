package Grid;

import java.util.LinkedList;

public class Digraph {
	private final int V; // number of vertices
	private int E; // number of edges
	private LinkedList<Integer> adj []; // adjacency lists

	public Digraph(int V) {
		this.V = V;
		this.E = 0;
		adj = new LinkedList[V]; // Create array of lists.
		for (int v = 0; v < V; v++) // Initialize all lists
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
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}