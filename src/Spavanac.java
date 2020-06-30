public class Spavanac {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int h = io.getInt();
        int m = io.getInt();
        m = m-45;
        if (m < 0) {
            m = 60 - Math.abs(m);
            h--;
            if(h < 0) {
                h = 23;
            }
        }
        io.println(h + " " + m);
        io.close();
    }
}
