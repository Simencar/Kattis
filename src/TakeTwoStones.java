public class TakeTwoStones {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        long stones = io.getLong();
        if(stones % 2 == 0) {
            io.println("Bob");
        }
        else {
            io.println("Alice");
        }
        io.close();
    }
}
