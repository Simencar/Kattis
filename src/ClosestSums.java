public class ClosestSums {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int c = 1;
        while (io.hasMoreTokens()) {
            int n = io.getInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = io.getInt();
            }

            int m = io.getInt();
            io.println("Case " + c + ":");
            c++;
            for (int i = 0; i < m; i++) {
                int num = io.getInt();
                int closest = findClosest(nums, num);
                io.println("Closest sum to " + num + " is " + closest + ".");
                io.flush();
            }
            
        }
        io.close();
    }

    public static int findClosest(int[] x, int num) {
        int diff = Integer.MAX_VALUE;
        int closest = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (i == j) {
                    continue;
                }
                int sum = x[i] + x[j];
                if (Math.abs(sum - num) == 0) {
                    return sum;
                }
                if (Math.abs(sum - num) < diff) {
                    diff = Math.abs(sum - num);
                    closest = sum;
                }
            }
        }
        return closest;
    }
}
