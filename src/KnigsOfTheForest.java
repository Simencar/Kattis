import WheresMyInternet.Kattio;

public class KnigsOfTheForest {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int k = io.getInt();
        int n = io.getInt();

    }
}
class Moose {
    public int year;
    public int str;

    Moose (int y, int s) {
        this.year = y;
        this.str = s;
    }

    public int compareTo(Moose other) {
        if (year < other.year) {
            return -1;
        }
        else if (year == other.year) {
            if (str > other.str) {
                return -1;
            }
            else if (str < other.str) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            return 1;
        }
    }
}
