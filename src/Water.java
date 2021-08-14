import java.util.LinkedList;

public class Water {
    static int n;
    static int[][] adj;
    static int flow;
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        n = io.getInt(); //number of stations
        int p = io.getInt(); //number of initial pipes
        int k = io.getInt(); //number of improvements
        adj = new int[n][n];
        for(int i = 0; i < p; i++) {
            int a = io.getInt()-1;
            int b = io.getInt()-1;
            int c = io.getInt();
            adj[a][b] = c;
            adj[b][a] = c;
        }
        flow = fordfulk(adj, 0,1); //initial flow
        io.println(flow);
        for(int i = 0; i < k; i++) {
            int a = io.getInt()-1;
            int b = io.getInt()-1;
            int c = io.getInt();
            adj[a][b] += c;
            adj[b][a] += c;
            flow += fordfulk(adj, 0,1); //additional flow after changing/adding edge
            io.println(flow);
        }
        io.close();
    }

    static int fordfulk(int[][] graph, int s, int t) { // O(p*f)
        int[][] rGraph = new int[n][n]; //residual graph
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                rGraph[i][j] = graph[i][j];
            }
        }
        int[] parent = new int[n]; //for saving current explored path
        int maxFlow = 0;
        while(stPath(rGraph, s, t, parent)) {
            int curFlow = Integer.MAX_VALUE;
            for(int i = t; i != s; i = parent[i]) {
                int j = parent[i];
                curFlow = Math.min(rGraph[j][i], curFlow); //find bottleneck capacity of path
            }
            for(int i = t; i != s; i = parent[i]) { //update residual graph
                int j = parent[i];
                rGraph[i][j] += curFlow;
                rGraph[j][i] -= curFlow;
            }
            maxFlow += curFlow;
        }
        adj = rGraph; //update org. graph so we don't have to recompute the flow
        return maxFlow;
    }

    static boolean stPath(int[][] rGraph, int s, int t, int[] parent) { //bfs loop O(n+p)
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        parent[s] = -1;
        visited[s] = true;
        while(!queue.isEmpty()) {
            int next = queue.poll();
            for(int i = 0; i < n; i++) {
                if(!visited[i] && rGraph[next][i] > 0) {
                    parent[i] = next;
                    if(i == t) { //found sink
                        return true;
                    }
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }
}
