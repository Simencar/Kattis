import java.util.ArrayList;

public class CitrusIntern {
    static long[] cost;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static long[] pick;
    static long[] skip;
    static long[] skipC;
    static boolean[] visited;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        cost = new long[n];
        visited = new boolean[n];
        pick = new long[n];
        skip = new long[n];
        skipC = new long[n];
        boolean notRoot[] = new boolean[n];
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            cost[i] = io.getLong();
            int u = io.getInt();
            for(int j = 0; j < u; j++) {
                int c = io.getInt();
                adj.get(i).add(c);
                notRoot[c] = true;
            }
        }
        int root = 0;
        for(int i = 0; i < n; i++) {
            if(!notRoot[i]) {
                root = i;
                break;
            }
        }
        minCost(root);
        long cost = Math.min(pick[root], skipC[root]);
        io.println(cost);
        io.close();

     }
     //modified min weight vertex cover

     static void minCost(int root) { //O(n^2) ?
        if(adj.get(root).isEmpty()) { //is leaf
            skip[root] = 0;
            pick[root] = cost[root];
            skipC[root] = cost[root]; // special case: don't pick root, cover root by picking at least one child
            visited[root] = true;
            return;
        }
        pick[root] = cost[root];//pick root
        skip[root] = 0; //skip root
        for(int c : adj.get(root)) { //loop children
            if(!visited[c]) {
                minCost(c); //set values for child if not visited
            }
            pick[root] += skip[c]; //don't pick any children
            skip[root] += Math.min(pick[c], skipC[c]); //pick children or cover child by grandchild depending on cost
        }

        skipC[root] = Long.MAX_VALUE; //cost of skipping root but picking at least one child
        for(int c : adj.get(root)) {
            long costPickC = skip[root] - Math.min(pick[c], skipC[c]); //remove calc for this child in skip
            costPickC += pick[c]; //pick this child
            skipC[root] = Math.min(skipC[root], costPickC);
        }
        visited[root] = true;
     }
}
