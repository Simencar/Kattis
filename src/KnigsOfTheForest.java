
import java.util.PriorityQueue;

public class KnigsOfTheForest {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        PriorityQueue<Moose> pq = new PriorityQueue<>();
        int k = io.getInt();
        int n = io.getInt();
        Moose karl = new Moose(io.getInt(), io.getInt());
        pq.add(karl);
        for (int i = 0; i < n+k-2; i++) {
            Moose m = new Moose(io.getInt(), io.getInt());
            pq.add(m);
        }
        String out = "unknown";
        while(pq.size() > 1) {
            Moose winner = pq.poll();
            if (winner.str == karl.str) {
                out = Integer.toString(winner.year);
                break;
            }
            for(int i = 0; i < k-1; i++) {
                Moose oldM = pq.poll();
                Moose newM = new Moose(oldM.year+1, oldM.str);
                pq.add(newM);
            }
        }
        io.println(out);
        io.close();
    }
}


class Moose implements Comparable<Moose> {
    public int year;
    public int str;

    Moose (int y, int s) {
        this.year = y;
        this.str = s;
    }

    public int compareTo(Moose other) {
        if (year < other.year) {
            return -1;
        }
        else if (year == other.year) {
            if (str > other.str) {
                return -1;
            }
            else if (str < other.str) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            return 1;
        }
    }
}
