import java.util.Iterator;
import java.util.PriorityQueue;

public class FroshWeek {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int m = io.getInt();
        PriorityQueue<Integer> jobs = new PriorityQueue();
        PriorityQueue<Integer> time = new PriorityQueue();
        for (int i = 0; i < n; i++) {
            int t = io.getInt();
            jobs.add(t);
        }
        for (int i = 0; i < m; i++) {
            int t = io.getInt();
            time.add(t);
        }
        int count = 0;
        Iterator itj = jobs.iterator();
        Iterator itt = time.iterator();
        while (itj.hasNext() && itt.hasNext()) {
            int minJ = jobs.peek();
            int minT = time.peek();
            if (minJ <= minT) {
                count++;
                jobs.poll();
                time.poll();
            }
            else if (minJ > minT) {
                time.poll();
            }
            else {
                jobs.poll();
            }
        }
        io.println(count);
        io.close();
    }
}
