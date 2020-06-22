import java.time.LocalDateTime;
import java.time.LocalTime;

public class Astro {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        String[] days = {"placeholder", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        LocalDateTime xTime = LocalDateTime.parse("2020-06-20T"+io.getWord());
        LocalDateTime yTime = LocalDateTime.parse("2020-06-20T"+io.getWord());
        LocalTime xDur = LocalTime.parse(io.getWord());
        LocalTime yDur = LocalTime.parse(io.getWord());

        int count = 0;
        while (count < ((int) 1e7)) {
            if(count == ((int) 1e7) -1) {
                io.println("Never");
                break;
            }
            if(xTime.equals(yTime)) {
                io.println(days[xTime.getDayOfWeek().getValue()]);
                io.println(xTime.toLocalTime());
                break;
            }
            else if(xTime.isBefore(yTime)) {
                xTime = xTime.plusHours(xDur.getHour());
                xTime = xTime.plusMinutes(xDur.getMinute());
            }
            else {
                yTime = yTime.plusHours(yDur.getHour());
                yTime = yTime.plusMinutes(yDur.getMinute());
            }
            count++;

        }
        io.close();
    }
}
