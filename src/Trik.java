public class Trik {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        String s = io.getWord();
        int pos = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                if (pos == 1) {
                    pos = 2;
                    continue;
                }
                if (pos == 2) {
                    pos = 1;
                }
            }
            if (c == 'B') {
                if (pos == 2) {
                    pos = 3;
                    continue;
                }
                if (pos == 3) {
                    pos = 2;
                }
            }
            if (c == 'C') {
                if (pos == 1) {
                    pos = 3;
                    continue;
                }
                if (pos == 3) {
                    pos = 1;
                }
            }
        }
        io.println(pos);
        io.close();
    }
}
