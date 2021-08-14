public class Sums {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int t = io.getInt();
        for(int i = 0; i < t; i++) {
            long n = io.getLong();
            boolean done = false;
            if((n & (n - 1)) == 0) {
                done = true;
            }
        }
    }
}
