
public class Alphabet {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        String input = io.getWord();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] a1 = input.toCharArray();
        char[] a2 = alphabet.toCharArray();
        int[][] mat = new int[a1.length+1][a2.length+1];

        for(int i = 0; i < a1.length+1; i++) {
            for (int j = 0; j < a2.length+1; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0;
                }
                else if (a1[i-1] == a2[j-1]) {
                    mat[i][j] = mat[i-1][j-1] + 1;
                }
                else {
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }
        io.println(26-mat[input.length()][alphabet.length()]);
        io.close();

    }
}
