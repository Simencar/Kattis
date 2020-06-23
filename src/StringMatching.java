import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringMatching {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pattern;
        while((pattern = reader.readLine()) != null) {
            String text = reader.readLine();
            kmpSearch(text, pattern);
            System.out.println();
        }

        reader.close();
    }
    public static void kmpSearch(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0;
        int i = 0;
        computeLPSArray(pat, M, lps);
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.print(i-j + " ");
                j = lps[j - 1];
            }


            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i = i + 1;
                }
            }
        }
    }
    public static void computeLPSArray(String pat, int M, int lps[]) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
