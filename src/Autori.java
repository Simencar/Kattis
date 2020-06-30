public class Autori {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        String name = io.getWord();
        StringBuilder sb = new StringBuilder();
        sb.append(name.charAt(0));
        for(int i = 1; i < name.length(); i++) {
            if(name.charAt(i) == '-') {
                sb.append(name.charAt(i+1));
            }
        }
        io.println(sb.toString().toUpperCase());
        io.close();
    }
}
