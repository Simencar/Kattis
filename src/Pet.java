public class Pet {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int max = 0;
        int pers = 0;
        for(int i = 0; i < 5; i++) {
            int sum = 0;
            for(int j = 0; j < 4; j++) {
                sum += io.getInt();
            }
            if(sum > max) {
                max = sum;
                pers = i+1;
            }
        }
        io.println(pers + " " + max);
        io.close();
    }
}
