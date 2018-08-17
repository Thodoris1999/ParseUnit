import com.ttyrovou.utils.parse.ParseUnit;
import org.junit.Test;

public class ParseTest {
    @Test
    public void testNonOptional() {
        String testString = "Some elephant drinks water";
        ParseUnit<?, String> root = new ParseUnit(testString);
        ParseUnit<String, String> child = new ParseUnit<>(root, s -> s.substring(s.indexOf('w')));
        ParseUnit<String, String> child2 = new ParseUnit<>(child, s -> s.substring(s.indexOf('t')));
        ParseUnit<String, String> child3 = new ParseUnit<>(child2, s -> s.substring(s.indexOf('w')));
        System.out.println(child3.get());
    }

    @Test
    public void testOptional() {
        String testString = "Some elephant drinks water";
        ParseUnit<?, String> root = new ParseUnit(testString);
        ParseUnit<String, String> child = new ParseUnit<>(root, s -> s.substring(s.indexOf('w')));
        ParseUnit<String, String> child2 = new ParseUnit<>(child, s -> s.substring(s.indexOf('t')));
        ParseUnit<String, String> child3 = new ParseUnit<>(child2, s -> s.substring(s.indexOf('w')), true);
        System.out.println(child3.get());
    }
}
