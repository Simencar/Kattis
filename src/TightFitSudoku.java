public class TightFitSudoku {
    static String[][] grid;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        grid = new String[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                grid[i][j] = io.getWord();
            }
        }
        solve();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                io.print(grid[i][j] + " ");
            }
            io.println();
        }
        io.close();
    }

    static boolean solve() { //O(9^m) ? m = number of positions not filled
        int row = -1;
        int col = -1;
        boolean done = true;
        outer:
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (!isDone(grid[i][j])) { //not all values are filled
                    done = false;
                    row = i;
                    col = j;
                    break outer;
                }
            }
        }
        if (done) {
            return true;
        }
        for (int i = 1; i < 10; i++) { //loop trough numbers
            if (isValid(grid, row, col, i)) { //number i is a valid solution at this pos
                String old = grid[row][col];
                if (old.length() > 1) {
                    grid[row][col] = setString(grid[row][col], i);
                } else {
                    grid[row][col] = String.valueOf(i);
                }
                if (solve()) {
                    return true;
                }
                grid[row][col] = old; //reset
            }
        }
        return false;
    }

    //checks if all values are filled in this string
    static boolean isDone(String in) {
        if (in.length() > 1) {
            if (!Character.isDigit(in.charAt(0))) {
                return false;
            }
            if (!Character.isDigit(in.charAt(2))) {
                return false;
            }
        }
        return Character.isDigit(in.charAt(0));
    }

    static boolean isValid(String[][] grid, int row, int col, int val) {
        //check for combined number
        if (grid[row][col].length() > 1) {
            if (Character.isDigit(grid[row][col].charAt(0))) {
                if (val < Character.getNumericValue(grid[row][col].charAt(0))) { //cant put smaller number on right of /
                    return false;
                }
            } else if (Character.isDigit(grid[row][col].charAt(2))) {
                if (val > Character.getNumericValue(grid[row][col].charAt(2))) { //cant put larger number to left of /
                    return false;
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            //row check
            if (grid[i][col].length() > 1) {
                String r1 = String.valueOf(grid[i][col].charAt(0));
                String r2 = String.valueOf(grid[i][col].charAt(2));
                if (String.valueOf(val).equals(r1) || String.valueOf(val).equals(r2)) { //number already in row
                    return false;
                }
            } else {
                String r1 = grid[i][col];
                if (String.valueOf(val).equals(r1)) { //number already in row
                    return false;
                }
            }
            //column check
            if (grid[row][i].length() > 1) {
                String c1 = String.valueOf(grid[row][i].charAt(0));
                String c2 = String.valueOf(grid[row][i].charAt(2));
                if (String.valueOf(val).equals(c1) || String.valueOf(val).equals(c2)) {
                    return false;
                }
            } else {
                String c1 = grid[row][i];
                if (String.valueOf(val).equals(c1)) {
                    return false;
                }
            }
        }
        //find box area
        int colStart;
        int colEnd;
        if (col < 3) {
            colStart = 0;
            colEnd = 3;
        } else {
            colStart = 3;
            colEnd = 6;
        }
        int rowStart;
        int rowEnd;
        if (row < 2) {
            rowStart = 0;
            rowEnd = 2;
        } else if (row > 3) {
            rowStart = 4;
            rowEnd = 6;
        } else {
            rowStart = 2;
            rowEnd = 4;
        }
        //box check
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (grid[i][j].length() > 1) {
                    String s1 = String.valueOf(grid[i][j].charAt(0));
                    String s2 = String.valueOf(grid[i][j].charAt(2));
                    if (String.valueOf(val).equals(s1) || String.valueOf(val).equals(s2)) {
                        return false;
                    }
                } else {
                    String s1 = String.valueOf(grid[i][j].charAt(0));
                    if (String.valueOf(val).equals(s1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static String setString(String in, int val) {
        String out;
        if (Character.isDigit(in.charAt(0))) {
            out = in.charAt(0) + "/" + val;
        } else {
            out = val + "/" + in.charAt(2);
        }
        return out;
    }

}
