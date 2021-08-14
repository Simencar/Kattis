import java.util.ArrayList;
import java.util.Arrays;

public class JustForSidekicks {
    static ArrayList<Long[]> trees = new ArrayList<>();
    static int N;
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        long[] vals = new long[6];
        N = io.getInt(); //number of gems
        int Q = io.getInt(); //number of queries
        for(int i = 0; i < 6; i++) {
            vals[i] = io.getLong();
            trees.add(new Long[N+1]);
            Arrays.fill(trees.get(i), Long.valueOf(0)); //Why null-pointer if not used??
        }
        String input = io.getWord();
        int[] arrIn = new int[N]; //type of gem at each pos
        for(int i = 0; i < N; i++) { // O(NlogN) //create trees
            int type = Character.getNumericValue(input.charAt(i));
            arrIn[i] = type;
            update(type-1, i, 1);
        }
        for(int i = 0; i < Q; i++) {
            int op = io.getInt();
            int x = io.getInt();
            int y = io.getInt();
            if(op == 1) { //replace
                update(arrIn[x-1]-1, x-1, -1); //decrease sum for this range in tree for type x
                update(y-1, x-1, 1); //increase sum for this range in tree for type y
                arrIn[x-1] = y; //update type at pos x to y
            }
            else if(op == 2) { //change value of gem
                vals[x-1] = y;
            }
            else {
                long sum = 0;
                //for each tree get number of gem is range and mult with value of type of gem
                for(int j = 0; j < 6; j++) {
                    sum += rangeSum(trees.get(j), x-1, y-1) * vals[j];
                }
                io.println(sum);
            }
        }
        io.close();

    }

    //Every index in fenwicktree can be represented as a addition of power of 2s

   static long getSum(Long[] tree, int i) { //O(logN)
        i = i+1;
        long sum = 0;
        while(i > 0) {
            sum += tree[i];
            i -= i & (-i); //flip rightmost bit to get next pos/parent in tree
        }
        return sum;
   }

   static void update(int type, int i, int val) {
        i = i+1;
        while(i <= N) {
            trees.get(type)[i] += val;
            i += i & (-i); //move least significant bit to the left to get next pos/parent
        }

   }

   static long rangeSum(Long[] tree, int s, int e) {
        return getSum(tree, e) - getSum(tree, s-1);
   }


}
