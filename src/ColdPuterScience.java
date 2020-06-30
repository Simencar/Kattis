public class ColdPuterScience {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int count = 0;
        for(int i = 0; i < n; i++) {
            int temp = io.getInt();
            if (temp < 0) {
                count++;
            }
        }
        io.println(count);
        io.close();
    }
}
