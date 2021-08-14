import java.util.HashMap;


public class BridgesAndTunnels {
    static int[] comp;
    static int[] size;
    static HashMap<String,Integer> vals = new HashMap<>();
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        comp = new int[2*n];
        size = new int[2*n];
        for(int i = 0; i < 2*n; i++) {
            comp[i] = i;
            size[i] = 1;
        }
        int count = 0; //counter for building number
        for(int i = 0; i < n; i++) {
            String x = io.getWord();
            String y = io.getWord();
            int xi;
            int yi;
            if(vals.containsKey(x)) {
                xi = vals.get(x);
            }
            else {
                xi = count;
                vals.put(x,xi);
                count++;
            }
            if(vals.containsKey(y)) {
                yi = vals.get(y);
            }
            else {
                yi = count;
                vals.put(y, yi);
                count++;
            }
            if(find(xi) != find(yi)) {
                union(xi, yi);
            }
            io.println(size[find(xi)]);
        }
        io.close();
    }

    static int find(int u) {
        while (u != comp[u]) {
            comp[u] = comp[comp[u]];
            u = comp[u];
        }
        return u;
    }

    //Union by rank always attaches the shorter tree to the root of the taller tree
    //in this case smaller tree?
    static void union(int u, int v) { //near constant time?
        int r1 = find(u);
        int r2 = find(v);
        if (size[r1] < size[r2]) {
            comp[r1] = r2;
            size[r2] += size[r1];
        } else if (size[r2] < size[r1]) {
            comp[r2] = r1;
            size[r1] += size[r2];
        } else {
            comp[r1] = r2;
            size[r2] += size[r1];
        }
    }
}
