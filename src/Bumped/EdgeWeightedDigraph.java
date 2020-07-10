package Bumped;

import java.util.LinkedList;

public class EdgeWeightedDigraph {

	    LinkedList<DirectedEdge>[] graph;
	    LinkedList<DirectedEdge> edgeList = new LinkedList<>();

	    public EdgeWeightedDigraph(int n) {
	        this.graph = new LinkedList[n];
	        for (int i = 0; i < n; i++) {
	            this.graph[i] = new LinkedList<>();
	        }
	    }

	    public void addEdge(DirectedEdge e) {
	        graph[e.from].add(e);
	        edgeList.add(e);
	    }

	    public int n() {
	        return this.graph.length;
	    }

	    public int m() {
	        return 0;
	    }

	    public Iterable<DirectedEdge> adj(int u) {
	        return this.graph[u];
	    }

	    public Iterable<DirectedEdge> edges() {
	        return this.edgeList;
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < this.n(); i++) {
	            sb.append(i);
	            sb.append(":");
	            for (DirectedEdge e : graph[i]) {
	                sb.append(e.toString());
	            }
	            sb.append("\n");
	        }
	        return sb.toString();
	    }

	}

