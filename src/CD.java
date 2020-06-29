import java.util.HashMap;

public class CD {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N;
        int M;
        while((N = io.getInt()) != 0 && (M = io.getInt())!= 0) {
            HashMap<Long, Integer> map = new HashMap<>();
            int count = 0;
            for(int i = 0; i < N; i++) {
                map.put(io.getLong(), 0);
            }
            for(int i = 0; i < M; i++) {
                if (map.containsKey(io.getLong())) {
                    count++;
                }
            }
            io.println(count);
            io.flush();
        }
        io.close();

    }
}
