public class HissingMicrophone {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        String word = io.getWord();
        boolean hiss = false;
        for(int i = 0; i < word.length()-1; i++) {
            if(word.charAt(i) == 's' && word.charAt(i+1) == 's') {
                io.println("hiss");
                hiss = true;
                break;
            }
        }
        if(!hiss) {
            io.println("no hiss");
        }
        io.close();
    }
}
