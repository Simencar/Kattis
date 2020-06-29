import java.util.Arrays;

public class PhoneList {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            int N = io.getInt();
            String[] nums = new String[N];
            for (int j = 0; j < N; j++) {
                String num = io.getWord();
                nums[j] = num;
            }
            Arrays.sort(nums);
            boolean prefix = false;
            for (int j = 1; j < N; j++) {
                if (nums[j].startsWith(nums[j - 1])) {
                    prefix = true;
                    break;
                }

            }
            if (prefix) {
                io.println("NO");
            } else {
                io.println("YES");
            }
        }
        io.close();
    }
}
