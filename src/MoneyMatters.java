import java.util.ArrayList;

public class MoneyMatters {

    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static long sum = 0;
    private static long[] balance;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int m = io.getInt();
        balance = new long[n];


        //create balance list and initialize graph
        for(int i = 0; i < n; i++) {
            long money = io.getLong();
            balance[i] = money;
            adj.add(new ArrayList<>());
        }

        //create graph
        for (int i = 0; i < m; i++) {
            int f1 = io.getInt();
            int f2 = io.getInt();
            adj.get(f1).add(f2);
            adj.get(f2).add(f1);
        }

        visited = new boolean[n];
        //loop checks that balance of each connected component sums to 0
        for(int i = 0; i < n; i++) {
            sum = 0;
            if(!visited[i]) {
                dfs(i);
            }
            if(sum != 0) {
                io.println("IMPOSSIBLE");
                io.close();
                return;
            }
        }
        io.println("POSSIBLE");
        io.close();
    }

    public static void dfs(int node) {
        visited[node] = true;
        sum += balance[node];
        for(int neigh : adj.get(node)) {
            if(!visited[neigh]) {
                dfs(neigh);
            }
        }
    }

}
