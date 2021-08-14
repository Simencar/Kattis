import java.util.ArrayList;

public class ExcavatorExpedition {
    private static int[] opt;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static int[] score;
    private static boolean[] done;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int V = io.getInt();
        int E = io.getInt();
        score = new int[V];
        opt = new int[V];
        done = new boolean[V];
        String sites = io.getWord();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            if(i > 0 && i < V-1) {
                if (sites.charAt(i) == 'X') {
                    score[i] = 1;
                } else {
                    score[i] = -1;
                }
            }
        }

        for(int i = 0; i < E; i++) {
            int f = io.getInt();
            int t = io.getInt();
            adj.get(f).add(t);
        }
        io.println(longestPath(0));
        io.close();
    }
    static int longestPath(int v) { //dfs loop O(V+E)
        if(done[v] || v == opt.length-1) { //already computed or reached end
            return opt[v];
        }
        int max = Integer.MIN_VALUE;
        for(int child : adj.get(v)) {
            max = Math.max(longestPath(child), max);
        }
        done[v] = true;
        if(max == Integer.MIN_VALUE) { //because minvalue + score did something weird
           opt[v] = max;
           return max;
        }
        opt[v] = score[v] + max;
        return score[v] + max;

    }
}
