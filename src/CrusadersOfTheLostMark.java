
public class CrusadersOfTheLostMark {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int C = io.getInt();
        int A = io.getInt();
        long[] budget = new long[A];
        long[] R = new long[C+1];
        int[] answer = new int[A];

        for(int i = 0; i < A; i++) {
            budget[i] = io.getLong();
        }
        for(int i = 0; i < A; i++) { // binary search loop for each pony, runtime: O(AlogC), binary search is logn
            int lo = 1;
            int hi = C;
            while(lo <= hi) {
                int mid = lo + (hi-lo)/2;
                if(R[mid] == 0) { //we don't know the cost of living here
                    io.println("Q " + mid);
                    io.flush();
                    R[mid] = io.getLong();
                }
                if(R[mid] == budget[i]) { //cost of living == budget of pony
                    answer[i] = mid;
                    break;
                }
                else if(R[mid] < budget[i]) { //pony can afford to live here
                    answer[i] = Math.max(mid, answer[i]); //max not necessary
                    lo = mid+1;
                }
                else { //budget is too large for pony
                    if(mid == 2) {
                        answer[i] = mid-1; //only city 1 could be valid
                        break;
                    }
                    hi = mid-1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("A");
        for(int i = 0; i < A; i++) {
        sb.append(" " + answer[i]);
    }
        io.println(sb);
        io.close();
}

}
