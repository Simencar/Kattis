import java.util.LinkedList;

public class JoinStrings {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt();
        String[] arr = new String[N];
        LinkedList<LinkedList<Integer>> concat = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            arr[i] = io.getWord();
            LinkedList<Integer> pos = new LinkedList<>();
            concat.add(i, pos);
        }
        int op1 = 0;
        for(int i = 0; i < N-1; i++) {
            op1 = io.getInt()-1;
            int op2 = io.getInt()-1;
            concat.get(op1).add(op2);

        }
        printRec(concat, arr, op1, io);
        io.close();
    }

    public static void printRec(LinkedList<LinkedList<Integer>> c, String[] s, int index, Kattio io) {
        io.print(s[index]);
        for(int i : c.get(index)) {
            printRec(c, s, i, io);
        }
    }


}
