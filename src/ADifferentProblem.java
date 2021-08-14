public class ADifferentProblem {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        while(io.hasMoreTokens()) {
            long s1 = Long.parseLong(io.getWord());
            long s2 = Long.parseLong(io.getWord());
            io.println(Math.abs(s1 - s2));
            io.flush();
        }
        io.close();
    }
}
