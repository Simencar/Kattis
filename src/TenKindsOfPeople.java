public class TenKindsOfPeople {
   private static int startR;
   private static int startC;
   private static int endR;
   private static int endC;
   private static boolean done;
   private static String output;
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int rows = io.getInt();
        int columns = io.getInt();
        int[][] map = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            String line = io.getWord();
            for(int j = 0; j < columns; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        int n = io.getInt();
        for(int i = 0; i < n; i++) {
            startR = io.getInt()-1;
            startC = io.getInt()-1;
            endR = io.getInt()-1;
            endC = io.getInt()-1;
            done = false;
            output = "neither";
            boolean[][] visited = new boolean[rows][columns];
            if(map[startR][startC] != map[endR][endC]) {
                done = true;
            }
            while(!done) {
                dfs(map, startR, startC, visited);
                done = true;
            }
            System.out.println(output);
        }


        

    }
    public static void dfs(int[][] map, int row, int col, boolean[][] visited) {
        if(row < 0 || col < 0 || row >= map.length || col >= map[0].length || visited[row][col]) {
            return;
        }
        if(map[row][col] != map[startR][startC]) {
            return;
        }
        if(row == endR && col == endC) {
            if (map[row][col] == 1) {
                output = "decimal";
            }
            else {
                output = "binary";
            }
            done = true;
        }

        visited[row][col] = true;
        dfs(map, row-1, col, visited);
        dfs(map, row+1, col, visited);
        dfs(map, row, col-1, visited);
        dfs(map, row, col+1, visited);
    }

}
