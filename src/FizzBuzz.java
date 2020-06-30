public class FizzBuzz {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int x = io.getInt();
        int y = io.getInt();
        int n = io.getInt();
        for(int i = 1; i <= n; i++) {
            if(i%x == 0) {
                io.print("Fizz");
            }
            if(i%y == 0) {
                io.print("Buzz");
            }
            if(i%x != 0 && i%y != 0) {
                io.print(i);
            }
            io.println();
        }
        io.close();
    }
}
