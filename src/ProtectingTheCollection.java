import java.util.ArrayList;

public class ProtectingTheCollection {
    public static class Pos {
        public int row;
        public int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }
    static int n; //size of room
    static int c; //column of the laser
    static int r; //row of the sensor
    static String[][] room;
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        n = io.getInt();
        c = io.getInt();
        r = io.getInt();
        room = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                room[i][j] = io.getWord();

            }
        }
        boolean[][] visited = new boolean[n][n];
        int row = 0;
        int col = c - 1;
        String dir = "s";
        boolean hasPath = false;
        //find natural path from start
        while (!hasPath) {
            if (row < 0 || row > n - 1 || col < 0 || col > n - 1) {
                break;
            }
            visited[row][col] = true;
            dir = setDir(dir, room[row][col]); //set next direction according to mirror at this pos
            if (row == r - 1 && col == n - 1 && dir.equals("e")) { //found sensor
                hasPath = true;
                break;
            }
            row = newPos(row, col, dir)[0];
            col = newPos(row, col, dir)[1];
        }
        ArrayList<Pos> intersects = new ArrayList<>();
        row = r - 1;
        col = n - 1;
        dir = "w";
        //find intersections with first path, starting from the finish
        while (!hasPath) {
            if (row < 0 || row > n - 1 || col < 0 || col > n - 1) {
                break;
            }
            if (visited[row][col] && room[row][col].equals(".")) { //found intersection
                intersects.add(new Pos(row, col));
            }
            dir = setDir(dir, room[row][col]);
            row = newPos(row, col, dir)[0];
            col = newPos(row, col, dir)[1];
        }

        //try different mirrors at every intersection
        for (int i = 0; i < intersects.size(); i++) {
            if (hasPath) {
                break;
            }
            row = intersects.get(i).row;
            col = intersects.get(i).col;
            room[row][col] = "/";
            for (int j = 0; j < 2; j++) {
                if (solve()) { //check if this solution creates path from start to finish
                    hasPath = true;
                    break;
                }
                room[row][col] = "\\";
            }
            room[row][col] = ".";
        }
        if (hasPath) {
            io.println("YES");
        } else {
            io.println("NO");
        }
        io.close();
    }


    static boolean solve() { // O(n^2)
        int row = 0;
        int col = c - 1;
        String dir = "s";
        boolean done = false;
        while (true) {
            if (row < 0 || row > n - 1 || col < 0 || col > n - 1) {
                break;
            }
            dir = setDir(dir, room[row][col]);
            if (row == r - 1 && col == n - 1 && dir.equals("e")) {
                done = true;
                break;
            }
            row = newPos(row, col, dir)[0];
            col = newPos(row, col, dir)[1];
        }
        return done;
    }


    static String setDir(String dir, String sym) {
        if (sym.equals(".")) {
            return dir;
        } else if (sym.equals("\\")) {
            if (dir.equals("w")) {
                return "n";
            } else if (dir.equals("s")) {
                return "e";
            } else if (dir.equals("n")) {
                return "w";
            } else {
                return "s";
            }
        } else {
            if (dir.equals("w")) {
                return "s";
            } else if (dir.equals("s")) {
                return "w";
            } else if (dir.equals("n")) {
                return "e";
            } else {
                return "n";
            }
        }
    }

    static int[] newPos(int row, int col, String dir) {
        int[] pos = new int[2];
        if (dir.equals("s")) {
            pos[0] = row + 1;
            pos[1] = col;
        } else if (dir.equals("n")) {
            pos[0] = row - 1;
            pos[1] = col;
        } else if (dir.equals("w")) {
            pos[0] = row;
            pos[1] = col - 1;
        } else {
            pos[0] = row;
            pos[1] = col + 1;
        }
        return pos;
    }

}
