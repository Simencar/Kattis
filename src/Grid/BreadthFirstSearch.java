package Grid;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class BreadthFirstSearch {
	private boolean[] marked; 
	private int[] edgeTo; 
	private final int s; 

	public BreadthFirstSearch(Digraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Digraph G, int s) {
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		marked[s] = true; // Mark the source
		queue.add(s); // and put it on the queue.
		while (!queue.isEmpty()) {
			int v = queue.poll(); // Remove next vertex from the queue.
			for (int w : G.adj(v))
				if (!marked[w]) // For every unmarked adjacent vertex,
				{
					edgeTo[w] = v; // save last edge on a shortest path,
					marked[w] = true; // mark it because path is known,
					queue.add(w); // and add it to the queue.
				}
		}
	}

public boolean hasPathTo(int v)
{ return marked[v]; }

public Iterable<Integer> pathTo(int v) {
	if (!hasPathTo(v)) return null;
	Stack<Integer> path = new Stack<Integer>();
	for (int x = v; x != s; x = edgeTo[x])
	path.push(x);
	path.push(s);
	return path;
	}
	
}