import java.util.HashMap;

public class PhoneList {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int cases = io.getInt();
        for(int i = 0; i < cases; i++) {
            int N = io.getInt();
            String[] nums = new String[N];
            HashMap<String, Integer> map = new HashMap<>();
            for(int j = 0; j < N; j++) {
                String num = io.getWord();
                nums[j] = num;
                map.put(num,0);
            }
            boolean prefix = false;
            
            if (prefix) {
                io.println("NO");
            }
            else {
                io.println("YES");
            }
        }
        io.close();
    }
}
