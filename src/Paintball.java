import java.util.ArrayList;

public class Paintball {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = io.getInt();
        int m = io.getInt();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = io.getInt();
            int b = io.getInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] targets = new int[n+1]; //pos i contains the person shooting i.
        int count = 0;
        for(int i = 1; i <= n; i++) {
            boolean visited[] = new boolean[n+1];
            if(canShoot(adj, i, visited, targets)) {
               count++;
            }
        }
        if(count == n) {
            for(int i = 1; i < n+1; i++) {
                io.println(targets[i]);
            }
        }
        else {
            io.println("Impossible");
        }
        io.close();

    }

    static boolean canShoot(ArrayList<ArrayList<Integer>> adj, int shooter, boolean[] visited, int[] targets) {
        for(int target : adj.get(shooter)) {
            if(!visited[target]) {
                visited[target] = true; //make sure we don't assign the same target again recursively
                //assign this shooter this target if no one else is assigned,
                // OR if the currently assigned shooter can shoot someone else
                if(targets[target] == 0 || canShoot(adj, targets[target], visited, targets)) {
                    targets[target] = shooter;
                    return true;
                }
            }
        }
        return false;
    }
}