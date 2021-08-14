public class Fountain {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int m = io.getInt();
        Character [][] map = new Character[n][m];
        for(int i = 0; i < n; i++) {
            String line = io.getWord();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        while(true) {
            int changes = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 'V') {
                        if (i < n - 1 && map[i + 1][j] == '.') {
                            map[i + 1][j] = 'V';
                            changes++;
                        }
                        if (i < n - 1 && map[i + 1][j] == '#') {
                            if (j > 0 && map[i][j - 1] != 'V' && map[i][j - 1] != '#') {
                                map[i][j - 1] = 'V';
                                changes++;
                            }
                            if (j < m - 1 && map[i][j + 1] != 'V' && map[i][j + 1] != '#') {
                                map[i][j + 1] = 'V';
                                changes++;
                            }
                        }
                    }
                }
            }
            if(changes == 0) {
                break;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                io.print(map[i][j]);
            }
            io.println();
        }
        io.close();
    }
}
