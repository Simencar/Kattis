public class JoinStrings {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt();
        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = io.getWord();
        }
        int lastOp = 0;
        for(int i = 0; i < N-1; i++) {
            StringBuilder sb = new StringBuilder();
            int op1 = io.getInt()-1;
            int op2 = io.getInt()-1;
            arr[op1] = (sb.append(arr[op1]).append(arr[op2])).toString();
            arr[op2] = "";
            lastOp = op1;
        }
        io.println(arr[lastOp]);
        io.close();
    }

}
