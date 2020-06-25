import java.util.ArrayList;

public class TenKindsOfPeople {
    private static int startR;
    private static int startC;
    private static int endR;
    private static int endC;
    private static boolean done;
    private static String output;
    private static int oldEndR1;
    private static int oldEndC1;
    private static int oldEndR0;
    private static int oldEndC0;
    private static boolean ready1 = false;
    private static boolean ready0 = false;
    private static boolean[][] visited1;
    private static boolean[][] visited0;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int rows = io.getInt();
        int columns = io.getInt();
        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String line = io.getWord();
            for (int j = 0; j < columns; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        int n = io.getInt();
        for (int i = 0; i < n; i++) {
            startR = io.getInt() - 1;
            startC = io.getInt() - 1;
            endR = io.getInt() - 1;
            endC = io.getInt() - 1;
            done = false;
            output = "neither";
            int curVal = map[startR][startC];

            boolean[][] visited = new boolean[rows][columns];
            if (curVal != map[endR][endC]) {
                done = true;
            }
            if (curVal == 0 && ready0) {
                if (visited0[startR][startC] && visited0[endR][endC]) {
                    done = true;
                    output = "binary";
                }
                if (visited0[startR][startC] && visited0[oldEndR0][oldEndC0]) {
                    while (!done) {
                        dfs(map, oldEndR0, oldEndC0, visited0);
                        break;

                    }
                }
            }
            if (curVal == 1 && ready1) {
                if (visited1[startR][startC] && visited1[endR][endC]) {
                    done = true;
                    output = "decimal";
                }
                if(visited1[startR][startC] && visited1[oldEndR1][oldEndC1]) {
                    while (!done) {
                        dfs(map, oldEndR1, oldEndC1, visited1);
                        break;
                    }
                }

            }

            while (!done) {
                dfs(map, startR, startC, visited);
                done = true;
            }

            System.out.println(output);
        }


    }

    public static void dfs(int[][] map, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= map.length || col >= map[0].length || visited[row][col]) {
            return;
        }
        if (map[row][col] != map[startR][startC]) {
            return;
        }
        if (row == endR && col == endC) {
            visited[row][col] = true;
            oldEndR1 = row;
            oldEndC1 = col;
            if (map[row][col] == 1) {
                output = "decimal";
                visited1 = visited;
                ready1 = true;
            } else {
                output = "binary";
                visited0 = visited;
                ready0 = true;
            }
            done = true;
        }

        visited[row][col] = true;
        dfs(map, row - 1, col, visited);
        dfs(map, row + 1, col, visited);
        dfs(map, row, col - 1, visited);
        dfs(map, row, col + 1, visited);
    }

}
