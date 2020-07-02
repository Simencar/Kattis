public class ABC {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int[] nums = new int[3];
        int min = 100;
        int max = 0;
        for (int i = 0; i < 3; i++) {
            int num = io.getInt();
            nums[i] = num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        String s = io.getWord();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                sb.append(min).append(" ");
            } else if (c == 'C') {
                sb.append(max).append(" ");
            } else {
                int mid = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] != min && nums[j] != max) {
                        mid = nums[j];
                        break;
                    }
                }
                sb.append(mid).append(" ");
            }
        }
        io.println(sb.toString());
        io.close();
    }
}
