public class TenKindsOfPeople {
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
            int startX = io.getInt();
            int startY = io.getInt();
            int endX = io.getInt();
            int endY = io.getInt();
        }
        

    }
}
