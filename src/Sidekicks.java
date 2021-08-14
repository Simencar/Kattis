import java.util.ArrayList;
import java.util.Arrays;

public class Sidekicks {
    static ArrayList<Long[]> trees = new ArrayList<>();
    static int N;
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        long[] vals = new long[6];
        N = io.getInt();
        int Q = io.getInt();
        for(int i = 0; i < 6; i++) {
            vals[i] = io.getLong();
            trees.add(new Long[N]);
            Arrays.fill(trees.get(i), Long.valueOf(0)); //Why null-pointer if not used??
        }
        String input = io.getWord();
        int[] arrIn = new int[N];
        for(int i = 0; i < N; i++) {
            int type = Character.getNumericValue(input.charAt(i));
            arrIn[i] = type;
            update(type-1, idx(i), 1);
        }
        for(int i = 0; i < Q; i++) {
            int op = io.getInt();
            int x = io.getInt();
            int y = io.getInt();
            if(op == 1) {
                update(arrIn[x-1]-1, idx(x-1), -1);
                update(y-1, idx(x-1), 1);
                arrIn[x-1] = y;
            }
            else if(op == 2) {
                vals[x-1] = y;
            }
            else {
                long sum = 0;
                for(int j = 0; j < 6; j++) {
                    sum += rangeSum(j, idx(x-1), idx(y-1)) * vals[j];
                }
                io.println(sum);
            }
        }
        io.close();
    }

    public static void update(int type, int idx, long val) {
        trees.get(type)[idx] += val;
        idx = parent(idx);
        while(idx > 0) {
            trees.get(type)[idx] = trees.get(type)[left(idx)] + trees.get(type)[right(idx)];
            idx = parent(idx);
        }
    }

    public static long rangeSum(int type, int l, int r) {
        long sum = trees.get(type)[l] + trees.get(type)[r];
        while(true) {
            int pl = parent(l);
            int pr = parent(r);
            if(pl == pr) {
                break;
            }
            if(l % 2 == 0) {
                sum += trees.get(type)[right(pl)];
            }
            if(r % 2 == 1) {
                sum += trees.get(type)[left(pr)];
            }
            l = pl;
            r = pr;
        }
        return sum;
    }

    static int left(int i) {
        return 2*i;
    }

    static int right(int i) {
        return 2*i+1;
    }

    static int parent(int i) {
        return i/2;
    }

    static int idx(int i) {
        return (trees.get(0).length)/2+i;
    }
}
