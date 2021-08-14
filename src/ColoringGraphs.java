import java.util.ArrayList;

public class ColoringGraphs {
    static int n;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[][] adjMatrix;
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        n = io.getInt();
        adjMatrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            String line = io.getLine();
            String[] arr = line.split("\\s+");
            for(int j = 0; j < arr.length; j++) {
                //using both adjacency list and matrix to get best of both worlds
                adj.get(i).add(Integer.parseInt(arr[j]));
                adj.get(Integer.parseInt(arr[j])).add(i);
                adjMatrix[i][Integer.parseInt(arr[j])] = 1;
                adjMatrix[Integer.parseInt(arr[j])][i] = 1;
            }
        }

        int[] color = new int[n];
        for(int i = findClique(); i <= n; i++) { //set lower bound to arbitrary clique including vertex 0
            if(kColor(color, 0, i)) {
                io.println(i);
                break;
            }
        }
        io.close();
    }

    //true if graph can be colored with k colors
    static boolean kColor(int[] color, int v, int k) {
        if(v == n) { //all vertices has been given color
            return true;
        }
        for(int i = 1; i <= k; i++) { //loop each color for each vertex until valid coloring is found
            if(isValid(v, color, i)) { //no adjacent vertices of v has same color i
                color[v] = i;
                if(kColor(color, v+1, k)) { //go to next vertex
                    return true;
                }
                color[v] = 0;
            }
        }
        return false;
    }


    //check if adjacent vertices to v has used same color
    static boolean isValid(int v, int[] color, int c) { //O(deg(v))
        for(int i = 0; i < adj.get(v).size(); i++) {
            if (color[adj.get(v).get(i)] == c) {
                return false;
            }
        }
        return true;
    }

    //true if v can be added to clique and still be a clique
    static boolean isClique(ArrayList<Integer> clique, int v) {
        for(int i = 0; i < clique.size(); i++) {
            if(adjMatrix[clique.get(i)][v] == 0) {
                return false;
            }
        }
        return true;
    }


    static int findClique() { // O(n^2)?
        ArrayList<Integer> clique = new ArrayList<>();
        clique.add(0);
        for(int i = 1; i < n; i++) {
            if(isClique(clique, i)) {
                clique.add(i);
            }
        }
        return clique.size();
    }
}
