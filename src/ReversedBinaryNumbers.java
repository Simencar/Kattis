import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReversedBinaryNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());

        String revBin = binaryRev(s);
        int revDec = binaryToDec(revBin);
        System.out.println(revDec);
    }

    public static String binaryRev(int i) {
        int currentDiv = i;
        StringBuilder sb = new StringBuilder();
        while (currentDiv > 0) {
            sb.append(currentDiv%2);
            currentDiv = currentDiv/2;
        }
        return sb.toString();
    }

    public static int binaryToDec(String s) {
        int total = 0;
        for(int i = 0; i < s.length(); i++) {
            int current = Character.getNumericValue(s.charAt(i));
            total = 2*total + current;
        }
        return total;
    }
}
