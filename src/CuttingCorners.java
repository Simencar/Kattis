import java.util.ArrayList;

public class CuttingCorners {

    public static class Point {
        final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        while(true) {
            int n = io.getInt();
            ArrayList<Point> ps = new ArrayList<>();
            if(n == 0) {
                break;
            }
            for(int i = 0; i < n; i++) {
                ps.add(new Point(io.getInt(),io.getInt()));
            }
            //info on last removed corner
            double lastMin = 0; //value of last iteration sharpest corner
            int lastPos = -1; //position in array of last removed point
            Point lastPoint = new Point(-1,-1); //the last removed point
            while(true) {
                int pos = 0; //position of sharpest corner in list
                double min = 1000;
                for (int i = 0; i < ps.size(); i++) {
                    int b = i - 1;
                    int c = i + 1;
                    if (i == 0) {
                        b = ps.size() - 1;
                    }
                    if (i == ps.size() - 1) {
                        c = 0;
                    }
                    Point pa = ps.get(i);
                    Point pb = ps.get(b);
                    Point pc = ps.get(c);
                    double angle = getAngle(pa, pb, pc);
                    if (angle < min) {
                        pos = i;
                        min = angle;
                    }
                }
                if(lastMin > min) { //getting sharper, add last removed corner back to list.
                        ps.add(lastPos, lastPoint); //O(n) ?
                        break;

                }
                if(ps.size() > 3) {
                    lastPoint = ps.get(pos);
                    ps.remove(pos);
                    lastMin = min;
                    lastPos = pos;
                }
                else {
                    break;
                }
            }
            StringBuilder sb = new StringBuilder(Integer.toString(ps.size()));
            for(int i = 0; i < ps.size(); i++) {
                sb.append(" " + ps.get(i));
            }
            io.println(sb);
        }
        io.close();
    }

    // gets angle in corner of point a. b and c are the adjacent corners.
    public static double getAngle(Point a, Point b, Point c) {
        double a2 = Math.pow(b.x - c.x,2) + Math.pow(b.y - c.y, 2);
        double b2 = Math.pow(a.x - c.x,2) + Math.pow(a.y - c.y, 2);
        double c2 = Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y, 2);
        double aCos = Math.acos((b2 + c2 - a2) / (2*Math.sqrt(b2)*Math.sqrt(c2)));
        return Math.toDegrees(aCos);
    }
}
