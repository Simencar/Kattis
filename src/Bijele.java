import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bijele {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> wantedPieces = new ArrayList<>();
        wantedPieces.addAll(Arrays.asList(1, 1, 2, 2, 2, 8));

        int count = 0;
        while (st.hasMoreElements()) {
            int n = Integer.parseInt(st.nextToken());
            int diff = wantedPieces.get(count) - n;
            wantedPieces.set(count, diff);
            count++;
        }
        for (int i = 0; i < wantedPieces.size(); i++) {
            System.out.print(wantedPieces.get(i) + " ");
        }



    }
}
