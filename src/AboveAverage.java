public class AboveAverage {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int C = io.getInt();
        for(int i = 0; i < C; i++) {
            int N = io.getInt();
            int[] grades = new int[N];
            int sum = 0;
            for(int j = 0; j < N; j++) {
                int grade = io.getInt();
                grades[j] = grade;
                sum += grade;
            }
            double average = (double) sum/N;
            int count = 0;
            for(int j = 0; j < N; j++) {
                if (grades[j] > average) {
                    count++;
                }
            }
            double aboveAverage = (double) count/N;
            double percent = (double) 100*aboveAverage;
            String symb = "%";
            io.format("%.3f%s%n", percent, symb);
            io.flush();
        }
        io.close();
    }
}
