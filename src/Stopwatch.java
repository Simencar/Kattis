public class Stopwatch {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int time = 0;
        boolean run = false;
        int last = 0;
        for(int i = 0; i < n; i++) {
            int t = io.getInt();
            if(run) {
               time += t-last;
               run = false;
            }
            else {
                last = t;
                run = true;
            }
        }
        if(run) {
            io.println("still running");
        }
        else {
            io.println(time);
        }
        io.close();
    }
}
