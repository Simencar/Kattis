import java.util.Arrays;

public class GuessingGame {


    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        Boolean[] values = new Boolean[11];
        Arrays.fill(values, true);


        while(true) {
            int guess = io.getInt();
            if(guess == 0) {
                break;
            }
            String word1 = io.getWord();
            String word2 = io.getWord();
            String response = word1.concat(" " +word2);

            if(response.equals("too low")) {
                for(int i = 0; i <= guess; i++) {
                    values[i] = false;
                }
            }
            else if(response.equals("too high")) {
                for(int i = guess; i < 11; i++) {
                    values[i] = false;
                }
            }
            else {
                if(values[guess]) {
                    io.println("Stan may be honest");
                }
                else {
                    io.println("Stan is dishonest");
                }
                Arrays.fill(values, true);
            }

        }
        io.close();
    }


}
