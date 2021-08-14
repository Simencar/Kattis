public class Inquiry {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        long[] sum = new long[n];
        long[] sumSq = new long[n];
        for(int i = 0; i < n; i++) {
            long num = io.getLong();
            if(i == 0) {
                sum[i] = num;
                sumSq[i] = num*num;
            }
            else {
                sum[i] = sum[i - 1] + num;
                sumSq[i] = sumSq[i -1] + num*num;
            }
        }
        long max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(sumSq[i]*(sum[n-1]-sum[i]), max);
        }
        io.println(max);
        io.close();
    }
}
