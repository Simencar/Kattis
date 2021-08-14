public class CountingTriangles {

    public static class Line {
        final double x1, x2, y1, y2;

        public Line(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public boolean intersects(Line other) {
            double a1 = this.y2 - this.y1;
            double b1 = this.x1 - this.x2;
            double c1 = a1*this.x1 + b1*this.y1;

            double a2 = other.y2 - other.y1;
            double b2 = other.x1 - other.x2;
            double c2 = a2*other.x1 + b2*other.y1;

            double det = a1*b2 - a2*b1;
            if(det == 0) {
                return false;  // Lines are parallel.
            }
            //point of intersection
            double x = (b2*c1 - b1*c2)/det;
            double y = (a1*c2 - a2*c1)/det;

            //check if intersection is in line segments
            if(!(Math.min(this.x1, this.x2) <= x && x <= Math.max(this.x1,this.x2))
            || !(Math.min(other.x1, other.x2) <= x && x <= Math.max(other.x1,other.x2))
            || !(Math.min(this.y1,this.y2) <= y && y <= Math.max(this.y1,this.y2))
            || !(Math.min(other.y1,other.y2) <= y && y <= Math.max(other.y1,other.y2))) {
                return false;
            }
            return true;
        }


    }
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        while(true) {
            int n = io.getInt();
            Line[] segments = new Line[n];
            if(n == 0) {
                break;
            }
            for(int i = 0; i < n; i++) {
                Line l = new Line(io.getDouble(),io.getDouble(),io.getDouble(),io.getDouble());
                segments[i] = l;
            }
            int count = 0;
            for(int i = 0; i < n; i++) { // O(n)
                for(int j = i+1; j < n; j++) { //O(logn) ?
                    for(int k = j+1; k < n; k++) { // O(logn) ?
                        if(segments[i].intersects(segments[j])
                        && segments[j].intersects(segments[k])
                        && segments[k].intersects(segments[i])) {
                            count++;
                        }
                    }
                }
            }
            io.println(count);
        }
        io.close();
    }
}
