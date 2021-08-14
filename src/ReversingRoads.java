import java.util.LinkedList;

public class ReversingRoads {
    private static int[][] adj;
    private static LinkedList <Integer> com; //to keep track of edges given
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int c = 1;
        while(io.hasMoreTokens()) {
            int m = io.getInt(); //vertices
            int n = io.getInt(); //edges
            adj = new int[m][m];
            com = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                int a = io.getInt();
                int b = io.getInt();
                adj[a][b] = 1;
                com.add(a);
                com.add(b);
            }


            String out = "valid";
            int a = -1;
            int b = -1;
            //loop checks that every vertex is reachable from every source/root.
            //if not, then start reversing edges and restart the loop.
            for(int i = 0; i < m; i++) { //worst case runtime O(m*(m+n)) ?
                visited = new boolean[m];
                count = 0;
                dfs(i,m);
                if(count != m) { //cant reach every other vertex from vertex i
                    if(a!=-1) { //redo last reverse
                        adj[a][b] = 1;
                        adj[b][a] = 0;
                    }
                    if(!com.isEmpty()) {
                        a = com.remove();
                        b = com.remove();
                        adj[b][a] = 1;
                        adj[a][b] = 0;
                        i = -1; //restart loop to check if this reverse solves
                        out = a + " " + b; //set this reverse in output
                    }
                    else {
                        out = "invalid";
                    }
                }
            }
            io.println("Case " + c + ": " + out);
            io.flush();
            c++;
        }
        io.close();

    }

    public static void dfs(int node, int size) {
        visited[node] = true;
        count++;
        for(int i = 0; i < size; i++) {
            if(adj[node][i] == 1 && !visited[i]) {
                dfs(i, size);
            }
        }
    }
}
