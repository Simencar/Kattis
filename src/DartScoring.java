import java.util.*;

public class DartScoring {
    static Point min = null;

    public static class Point implements Comparable<Point> {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Point o) {
            int val = orientation(min, this, o);
            if (val == 0) { //points are colinear, closest point should be first
                double dist1 = Math.pow(min.x - this.x, 2) + Math.pow(min.y - this.y, 2);
                double dist2 = Math.pow(min.x - o.x, 2) + Math.pow(min.y - o.y, 2);
                return (dist1 >= dist2) ? (1) : (-1);
            }
            return (val == 1) ? (1) : (-1); //if 1 then "this" is more to the left then "other"
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        String line;
        while ((line = io.getLine()) != null) {
            String[] words = line.split(" ");
            double minY = Double.MAX_VALUE;
            double minX = Double.MAX_VALUE;
            ArrayList<Point> points = new ArrayList<>();
            for (int i = 1; i <= words.length; i += 2) {
                double x = Double.valueOf(words[i - 1]);
                double y = Double.valueOf(words[i]);
                Point newP = new Point(x, y);
                if (y < minY || (y == minY && x < minX)) { //find bottom leftmost point
                    points.add(0, newP); //maybe nlogn?
                    minY = y;
                    minX = x;
                } else {
                    points.add(newP);
                }

            }
            double s = (points.size() == 1) ? (0) : grahamScan(points);
            double score = 100 * points.size() / (1 + s);
            io.print(String.format(Locale.ROOT, "%.10f\n", score));
        }
        io.close();
    }

    static double grahamScan(ArrayList<Point> points) {
        if (points.size() == 2) {
            return dist(points.get(0), points.get(1)) * 2;
        }
        min = points.get(0);
        Collections.sort(points.subList(1, points.size())); //sort by polar angle against min, counterclockwise first

        Stack<Point> s = new Stack<>();
        s.push(points.get(0));
        s.push(points.get(1));
        s.push(points.get(2));
        for (int i = 3; i < points.size(); i++) {
            //remove top of stack if orientation of top-1, top and pi is clockwise
            while (s.size() > 1 && orientation(secondTop(s), s.peek(), points.get(i)) == 1) {
                s.pop();
            }
            s.push(points.get(i));
        }
        //compute the circumference of the points in the stack
        double dist = 0;
        Point last = min;
        while (!s.empty()) {
            Point p = s.pop();
            dist += dist(last, p);
            last = p;
        }
        return dist;
    }

    public static int orientation(Point p, Point q, Point r) {
        //if val is negative then slope of segment p -> q < slope of segment q -> r(counterclockwise turn)
        //opposite if positive
        //points are colinear if == 0
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) {
            return 0;
        }
        return (val > 0) ? (1) : (2); //1 == clockwise, 2 == counterclockwise
    }

    //retrives first element after top of stack
    static Point secondTop(Stack<Point> s) {
        Point top = s.pop();
        Point second = s.peek();
        s.push(top);
        return second;
    }

    //euc dist between two points
    static double dist(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
}
