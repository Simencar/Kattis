package Bumped;

import java.util.Stack;

public class Dijkstra {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;

	public Dijkstra(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.n()];
		distTo = new double[G.n()];
		pq = new IndexMinPQ<Double>(G.n());
		for (int v = 0; v < G.n(); v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		pq.add(s, 0.0);
		while (!pq.isEmpty())
			relax(G, pq.poll());
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to;
			if (distTo[w] > distTo[v] + e.weight) {
				distTo[w] = distTo[v] + e.weight;
				edgeTo[w] = e;
				if (pq.contains(w)) {
					pq.changeKey(w, distTo[w]);
				}
				else {
					pq.add(w, distTo[w]);
				}
			}
		}
	}

	public double distTo(int v) {

		return distTo[v];

	}

	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectedEdge> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from])
			path.push(e);
		return path;
	}
}
