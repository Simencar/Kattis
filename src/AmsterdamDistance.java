import java.awt.*;

import static java.lang.StrictMath.PI;

public class AmsterdamDistance {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        double distance = 0;
        //input
        int segments = io.getInt();
        int circles = io.getInt();
        double rad = io.getDouble();
        Point start = new Point(io.getInt(),io.getInt());
        Point end = new Point(io.getInt(),io.getInt());

        //calc
        double lineDist = rad/circles; // distance between each half-circle
        int yDiff = Math.abs(start.y - end.y);
        int xDiff = Math.abs(start.x - end.x);
        distance = yDiff*lineDist;
        double circleRad;

        //find radius of smallest circle for travel
        if(start.y > end.y) {
            circleRad = end.y*lineDist;
        }
        else {
            circleRad = start.y*lineDist;
        }

        double segmentDist = ((circleRad*2)*PI)/(segments*2); //distance between pie-slices in chosen half-circle
        distance += xDiff * segmentDist;
        distance = Math.min(distance, (start.y+end.y)*lineDist); //check if only straight lines is shorter

        io.println(distance);
        io.close();
    }
}
