

public class AlmostPerfect {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);


        while(io.hasMoreTokens()) {
            int sum = 1;
            int i = io.getInt();
            int sqr = (int) Math.ceil(Math.sqrt(i));
            for(int d = 2; d < sqr; d++ ) {
                if (i%d == 0) {
                    sum += d;
                    sum += i/d;
                }
            }
            if(sqr * sqr == i) {
                sum += sqr;
            }
            if(sum == i) {
                io.println(i + " perfect");
            }
            else if (sum >= i-2 && sum <= i+2) {
                io.println(i + " almost perfect");
            }
            else {
                io.println(i + " not perfect");
            }

        }
        io.close();
    }
}
