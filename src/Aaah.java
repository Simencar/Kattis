public class Aaah {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        String s1 = io.getWord();
        String s2 = io.getWord();
        if(s1.length() < s2.length()) {
            io.println("no");
        }
        else {
            io.println("go");
        }
        io.close();
    }
}
