

public class VaccineEfficacy {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        Boolean data[][] = new Boolean[n][4];
        double vac = 0;
        double con = 0;
        for(int i = 0; i < n; i++) {
            String line = io.getWord();
            if(line.charAt(0) == 'Y') {
                vac++;
            }
            else {
                con++;
            }
            for(int j = 0; j < 4; j++) {
                if(line.charAt(j) == 'Y') {
                    data[i][j] = true;

                }
                else {
                    data[i][j] = false;

                }
            }
        }
        int count = 1;
        while(true) {
            if(count == 4) {
                break;
            }
            double infectedControl = 0;
            double infectedVaccine = 0;
            for (int i = 0; i < n; i++) {
                if(data[i][0] && data[i][count]) {
                    infectedVaccine++;
                }
                else if(!data[i][0] && data[i][count]){
                    infectedControl++;
                }
            }
            double rateControl = infectedControl/con;
            double rateVaccine = infectedVaccine/vac;
            if(rateControl <= rateVaccine) {
                io.println("Not Effective");
                count++;
                continue;
            }
            double diff = ((rateControl-rateVaccine)/rateControl)*100;
            io.printf("%.6f %n", diff);
            count++;
        }
        io.close();

    }
}
