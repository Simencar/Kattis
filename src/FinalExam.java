public class FinalExam {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int score = 0;
        String last = "";
        for(int i = 0; i < n; i++) {
            String ans = io.getWord();
            if(ans.equals(last)) {
                score++;
            }
            last = ans;
        }
        io.println(score);
        io.close();
    }
}
