public class StringMatching {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        String text;
        String pattern;
        while((pattern = io.getLine()) != null && (text = io.getLine()) != null) {
            int[] lps = computeLPSArray(pattern);
            kmp(pattern, text, lps, io);
            io.println();
        }
        io.close();
    }


    public static int[] computeLPSArray(String pat) {
        int n = 0;
        int k = pat.length();
        int idx = 1;
        int[] lps = new int[k];
        while (idx < k) {
            if (pat.charAt(idx) == pat.charAt(n)) {
                n++;
                lps[idx] = n;
                idx++;
            }
            else {
                if (n != 0) {
                    n = lps[n - 1];
                }
                else {
                    lps[idx] = n;
                    idx++;
                }
            }
        }
        return lps;
    }

    public static void kmp(String pattern, String text, int[] lps, Kattio io) {
        int n = text.length();
        int k = pattern.length();
        int idxT = 0;
        int idxP = 0;
        while(idxT < n) {
            if(pattern.charAt(idxP) == text.charAt(idxT)) {
                idxP++;
                idxT++;
            }
            if(idxP == k) {
                io.print(idxT - k + " ");
                idxP = lps[idxP-1];
            }
            else if (idxT < n && pattern.charAt(idxP) != text.charAt(idxT)) {
                if(idxP != 0) {
                    idxP = lps[idxP-1];
                }
                else {
                    idxT++;
                }
            }
        }
    }
}

