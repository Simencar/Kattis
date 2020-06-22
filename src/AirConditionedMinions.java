
import java.util.ArrayList;
import java.util.Collections;


public class AirConditionedMinions {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        ArrayList<cmpPoint> intervals = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            cmpPoint interval = new cmpPoint(io.getInt(), io.getInt());
            intervals.add(interval);
        }
        Collections.sort(intervals);
        int rooms = 1;
        int max = intervals.get(0).y;
        for(int i = 0; i < intervals.size(); i++) {
            if(intervals.get(i).x <= max) {
                if (intervals.get(i).y < max) {
                    max = intervals.get(i).y;
                }
            }
                else {
                    max = intervals.get(i).y;
                    rooms++;
                }
        }
        io.println(rooms);
        io.close();
    }
}

class cmpPoint implements Comparable<cmpPoint> {
    int x,y;
    cmpPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(cmpPoint o) {
        if(this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}
