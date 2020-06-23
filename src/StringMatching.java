import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatching {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pattern;
        while((pattern = reader.readLine()) != null) {
            String text = reader.readLine();
            Pattern patt = Pattern.compile(pattern);
            Matcher matcher = patt.matcher(text);
            System.out.println(matcher.matches());
        }
    }
}
