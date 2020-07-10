package Grid;

import java.util.HashMap;
import java.util.Stack;

public class Grid {

	private static int COLUMNS;
	private static int ROWS;

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);

		ROWS = io.getInt();
		COLUMNS = io.getInt();
		HashMap map = new HashMap<>();
		Digraph graph = new Digraph(ROWS * COLUMNS);
		
		for (int i = 0; i < ROWS; i++) {
			String s = io.getWord();
			for (int j = 0; j < COLUMNS; j++) {
				int value = Character.getNumericValue(s.charAt(j)); // splitting the string into integers
				map.put(vertex(i, j), value);
			}
		}

		for (int i = 0; i < ROWS * COLUMNS; i++) {
			int vertexValue = (int) map.get(i);
			int row = getRow(i); // current row
			int col = getCol(i); // current column

			// adding edge to every vertex(coordinate) we can step to.
			// we don't want to add edges if coordinate is outside of the grid
			if (row - vertexValue >= 0) {
				graph.addEdge(i, vertex(row - vertexValue, col));
			}
			if (row + vertexValue < ROWS) {
				graph.addEdge(i, vertex(row + vertexValue, col));
			}
			if (col - vertexValue >= 0) {
				graph.addEdge(i, vertex(row, col - vertexValue));
			}
			if (col + vertexValue < COLUMNS) {
				graph.addEdge(i, vertex(row, col + vertexValue));
			}
		}
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
		int target = vertex(ROWS - 1, COLUMNS - 1); // bottom right coordinate in grid
		if (bfs.hasPathTo(target)) {
			io.println(((Stack) bfs.pathTo(target)).size() - 1); // size of the iterable, -1 because it includes target
		} else {
			io.println(-1);
		}
		io.close();
	}

	/**
	 * convert a coordinate(row, col) to a vertex
	 * @param row
	 * @param col
	 * @return
	 */
	public static int vertex(int row, int col) {
		int vertex = row * COLUMNS + col;
		return vertex;
	}

	/**
	 * get the row at this vertex
	 * @param vertex
	 * @return
	 */
	public static int getRow(int vertex) {
		int row = vertex / COLUMNS;
		return row;
	}

	/**
	 * get the column at this vertex
	 * @param vertex
	 * @return
	 */
	public static int getCol(int vertex) {
		int col = vertex % COLUMNS;
		return col;
	}
}
