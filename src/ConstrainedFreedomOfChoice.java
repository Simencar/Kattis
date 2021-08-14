public class ConstrainedFreedomOfChoice {
    static char[][] map;
    static int r;
    static int c;
    //memoization tables for each dir
    static boolean[][] visitedUp;
    static boolean[][] visitedDown;
    static boolean[][] visitedRight;
    static long[][] optRight;
    static long[][] optUp;
    static long[][] optDown;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        while(true) {
            r = io.getInt();
            c = io.getInt();
            if(r == 0 && c == 0) {
                break;
            }
            map = new char[r][c];
            visitedUp = new boolean[r][c];
            visitedDown = new boolean[r][c];
            visitedRight = new boolean[r][c];
            optRight = new long[r][c];
            optDown = new long[r][c];
            optUp = new long[r][c];
            for(int i = 0; i < r; i++) {
                String line = io.getWord();
                for(int j = 0; j < c; j++) {
                    map[i][j] = line.charAt(j);
                }
            }
            io.println(uniquePaths(r-1,0, "up"));
        }
        io.close();
    }

    static long uniquePaths(int row, int col, String lastMove) { //runtime O(r*c) because we compute each pos max 3 times
        if (row < 0 || row > r-1 || col > c-1) { //out of bounds
            return 0;
        }

        if(map[row][col] == '#') { //wall
            return 0;
        }
        if(row == 0 && col == c-1) { //goal
            return 1;
        }
        long val;
        if(lastMove == "up") {
            if(visitedUp[row][col]) {
                return optUp[row][col];
            }
            val = uniquePaths(row-1, col, "up") + uniquePaths(row, col+1, "right");
            optUp[row][col] = val;
            visitedUp[row][col] = true;
        }
        else if (lastMove == "down") {
            if(visitedDown[row][col]) {
                return optDown[row][col];
            }
            val = uniquePaths(row+1, col, "down") + uniquePaths(row, col+1, "right");
            optDown[row][col] = val;
            visitedDown[row][col] = true;
        }
        else {
            if(visitedRight[row][col]) {
                return optRight[row][col];
            }
            val = uniquePaths(row-1, col, "up") + uniquePaths(row+1, col, "down")
                    + uniquePaths(row, col+1, "right");
            optRight[row][col] = val;
            visitedRight[row][col] = true;
        }
        return val;
    }
}
