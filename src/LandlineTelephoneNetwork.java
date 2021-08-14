import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class LandlineTelephoneNetwork {
    static int[] comp;
    static int[] rank;


    public static class Edge implements Comparable<Edge> {
        int from;
        int to;
        long weight;

        public Edge(int f, int t, long w) {
            this.from = f;
            this.to = t;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge other) {
            if (this.weight < other.weight) {
                return -1;
            } else if (this.weight > other.weight) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        PriorityQueue<Edge> secure = new PriorityQueue<Edge>();
        PriorityQueue<Edge> insecure = new PriorityQueue<Edge>();
        long weight = 0;

        int n = io.getInt(); //number of buildings
        int m = io.getInt(); //connections
        int p = io.getInt(); //insecure buildings
        comp = IntStream.range(0, n).toArray();
        rank = new int[n];
        boolean[] isInsecure = new boolean[n];

        for (int i = 0; i < p; i++) {
            isInsecure[io.getInt() - 1] = true;
        }
        int secureHouse = -1; // keep track of a secure house
        for (int i = 0; i < m; i++) {
            int x = io.getInt() - 1;
            int y = io.getInt() - 1;
            Edge e = new Edge(x, y, io.getLong());
            if(!isInsecure[x]) {
                secureHouse = x;
            }
            if(!isInsecure[y]) {
                secureHouse = y;
            }
            if(isInsecure[x] ^ isInsecure[y]) { //XOR, one of the buildings are insecure
                insecure.add(e);
            }
            else if((!isInsecure[x] && !isInsecure[y]) || n == p) { //both buldings secure, or the number of buldings equals number of insecure buldings
                secure.add(e);
            }
            //could add check for two insecure buildings when n != p, then solution is impossible
        }

        //complexity prim O(ElogV)
        while (!secure.isEmpty()) { //mst secure houses, prims?
            Edge e = secure.poll(); //sorted by cost
            if (find(e.from) != find(e.to)) { //check if components already connected
                union(e.from, e.to);
                weight += e.weight;

            }
        }

        if (secureHouse != -1) {
            int set = find(secureHouse);
            for (int i = 0; i < n; i++) {
                if (!isInsecure[i] && set != find(i)) { //all secure houses not connected
                    io.println("impossible");
                    io.close();
                    return;
                }
            }
        }

        while (!insecure.isEmpty()) { //add insecure to mst
            Edge e = insecure.poll();
            if (find(e.from) != find(e.to)) {
                union(e.from, e.to);
                weight += e.weight;
            }
        }
        String out = Long.toString(weight);
        int finishedSet = find(0); //find identifier of finished MST
        for(int i = 0; i < n; i++) {
            if(finishedSet != find(i)) { //not all houses connected
                out = "impossible";
                break;
            }
        }
        io.println(out);
        io.close();
    }

    static int find(int u) {
        while (u != comp[u]) {
            comp[u] = comp[comp[u]];
            u = comp[u];
        }
        return u;
    }

    static void union(int u, int v) {
        int r1 = find(u);
        int r2 = find(v);
        if (rank[r1] < rank[r2]) {
            comp[r1] = r2;
        } else if (rank[r2] < rank[r1]) {
            comp[r2] = r1;
        } else {
            comp[r1] = r2;
            rank[r2]++;
        }
    }
}
