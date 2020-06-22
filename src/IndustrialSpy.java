import java.util.HashMap;

public class IndustrialSpy {
    private  static HashMap<String, Integer> primes; //hashmap ensures primes are only added once.

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();

        for(int i = 0; i < n; i++) {
            primes = new HashMap<>();
            String input = io.getWord();
            char[] arr = input.toCharArray();
            for(int j = 1; j <= arr.length; j++ ) {
                heapPermutation(arr, arr.length, j);
            }
            io.println(primes.size());

        }
        io.close();
    }

   public static void heapPermutation(char[] arr, int size, int n) {
        if (size == 1) { // found permutation
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) {
                s.append(arr[i]);
            }
            String perm = removeLeadingZeros(s.toString());
            if(isPrime(Integer.parseInt(perm))) {
                primes.put(perm, 1);
            }
        }
        for (int i=0; i<size; i++) {
            heapPermutation(arr, size-1, n);
            // if size is odd, swap first and last elem
            if (size % 2 == 1) {
                char temp = arr[0];
                arr[0] = arr[size-1];
                arr[size-1] = temp;
            }
            // if size is even, swap ith and last elem
            else {
                char temp = arr[i];
                arr[i] = arr[size-1];
                arr[size-1] = temp;
            }
        }
    }

    public static boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        if(num > 2 && num%2 == 0) {
            return false;
        }
        for(int i = 3; i <= Math.sqrt(num)+1; i+=2) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String removeLeadingZeros(String s) {
        int zeroInd = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                zeroInd++;
            }
            else {
                break;
            }
        }
        if(zeroInd == s.length()) {
            zeroInd--; // leave one zero
        }
        return s.substring(zeroInd);
    }

}
