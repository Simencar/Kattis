public class Tarifa {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int x = io.getInt();
        int n = io.getInt();
        int save = 0;
        for(int i = 0; i < n; i++) {
            int use = io.getInt();
            save += x-use;
        }
        save += x;
        io.println(save);
        io.close();
    }
}
