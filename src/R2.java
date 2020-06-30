public class R2 {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int r = io.getInt();
        int s = io.getInt();
        int r2 = (s*2)-r;
        io.println(r2);
        io.close();
    }
}
