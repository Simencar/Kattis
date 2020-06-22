import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class TravelingSalesperson {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        double[] xs = new double[n];
        double[] ys = new double[n];
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            xs[i] = io.getDouble();
            ys[i] = io.getDouble();

        }
        // calc distance matrix
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dist[i][j] = (int) Math.round(Math.sqrt(Math.pow((xs[j]-xs[i]),2) + Math.pow((ys[j] - ys[i]), 2)));
            }
        }

    }
}
