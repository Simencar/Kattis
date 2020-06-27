public class ADifferentProblem {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        while(io.hasMoreTokens()) {
            String x = io.getWord();
            String y = io.getWord();
            String ans = diff(x,y);
            ans = removeLeadingZeros(ans);
            io.println(ans);
            io.flush();

        }
        io.close();




    }

    /**
     *
     * @param s1 String representing an Int
     * @param s2 String representing an Int
     * @return True if s1 is a larger number than s2
     */
    public static boolean isLarger(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return true;
        }
        if(s1.length() == s2.length()) {
            for(int i = 0; i < s1.length(); i++) {
                int i1 = Integer.parseInt(s1.substring(i, i + 1));
                int i2 = Integer.parseInt(s2.substring(i, i + 1));
                if(i1 > i2) {
                    return true;
                }
                if (i1 < i2) {
                    break;
                }
            }
        }
        return false;
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            sb.insert(0, s.charAt(i));
        }
        return sb.toString();
    }

    public static String diff(String s1, String s2) {
        String x; // larger number
        String y; // smaller number
        StringBuilder ans = new StringBuilder();
        if (isLarger(s1,s2)) {
            x = reverse(s1);
            y = reverse(s2);
        }
        else {
            x = reverse(s2);
            y = reverse(s1);
        }

        for(int i = 0; i < x.length(); i++) {
            int xi = Integer.parseInt(x.substring(i, i + 1));
            if(i < y.length()) {
                int yi = Integer.parseInt(y.substring(i, i + 1));
                if (xi >= yi) {
                    ans.insert(0, xi - yi);
                } else {
                    for (int j = i + 1; j < x.length(); j++) {
                        int borrow = Integer.parseInt(x.substring(j, j + 1));
                        if (borrow != 0) {
                            borrow -= 1;
                            x = x.substring(0, j) + borrow + x.substring(j + 1);
                            xi += 10;
                            ans.insert(0, xi - yi);
                            break;
                        } else {
                            x = x.substring(0, j) + "9" + x.substring(j + 1);
                        }
                    }
                }
            }
            else {
                ans.insert(0,xi);
            }
        }
        return ans.toString();
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
