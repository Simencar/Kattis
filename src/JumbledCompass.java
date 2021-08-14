public class JumbledCompass {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int start = io.getInt();
        int end = io.getInt();
        int clockwise = 0;
        int counter = 0;
        if(end < start) {
            clockwise = 360 - start + end;
        }
        else {
            clockwise = end - start;
        }
        if(start < end) {
            counter = 360 + start - end;
        }
        else {
            counter = start - end;
        }
        if(counter < clockwise) {
            io.println(-counter);
        }
        else {
            io.println(clockwise);
        }
        io.close();
    }
}
