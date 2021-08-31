import java.math.BigInteger;
import java.util.ArrayList;

public class NameThatPermutation {
    static BigInteger[] facts = new BigInteger[51];

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        factorial(); //initialize factorial array
        while (io.hasMoreTokens()) {
            int n = io.getInt(); // number of digits
            BigInteger k = new BigInteger(io.getWord()); //permutation number
            io.println(createPerm(n, k));
        }
        io.close();
    }

    public static StringBuilder createPerm(int n, BigInteger k) {
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            nums.add(i+1);
        }
        StringBuilder ans = new StringBuilder();
        while(n > 0) {
            n--;
            BigInteger index = k.divide(facts[n]); // find the block. first pos equal for all perms in a block
            k = k.mod(facts[n]); //update k for one less digit
            ans.append(nums.remove(index.intValue())).append(" "); //append digit to ans and remove from list(auto shift)
        }
        return ans;
    }


    public static void factorial() {
        for(int i = 0; i < 51; i++) {
            if(i < 2) {
                facts[i] = new BigInteger("1");
            }
            else {
                facts[i] = new BigInteger(String.valueOf(i)).multiply(facts[i-1]);
            }
        }

    }
}
