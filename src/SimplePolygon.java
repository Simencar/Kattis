import java.util.Arrays;

public class SimplePolygon {

    public static class Point implements Comparable<Point> {
        double x, y;
        int pos;

        public Point(double x, double y, int pos) {
            this.x = x;
            this.y = y;
            this.pos = pos;
        }

        @Override
        public int compareTo(Point o) {
            double angleT = angle(center, this);
            double angleO = angle(center, o);
            if (angleT == angleO) {
                return (dist(center, this) < dist(center, o)) ? (-1) : (1);
            }
            return (angleT < angleO) ? (-1) : (1);
        }

        @Override
        public String toString() {
            return String.valueOf(pos);
        }
    }

    public static Point center;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int c = io.getInt();
        for (int i = 0; i < c; i++) {
            int n = io.getInt();
            double xCen = 0;
            double yCen = 0;
            Point[] points = new Point[n];
            for (int j = 0; j < n; j++) {
                int x = io.getInt();
                int y = io.getInt();
                xCen += x;
                yCen += y;
                points[j] = new Point(x, y, j);
            }
            center = new Point(xCen / n, yCen / n, 0);
            Arrays.sort(points); //sort all points based on their angle to center
            for (int j = 0; j < n; j++) {
                io.print(points[j] + " ");
            }
            io.println();
        }
        io.close();

    }

    static double dist(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    static double angle(Point a, Point b) {
        double degrees = Math.atan2(a.y - b.y, b.x - a.x) * (180.0 / Math.PI);
        return (degrees < 0) ? (degrees + 360.0) : degrees;
    }


}
