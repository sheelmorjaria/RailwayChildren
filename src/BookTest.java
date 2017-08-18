import junit.framework.TestCase;
import org.apache.commons.math3.primes.Primes;
import java.util.Map;

/**
 * Created by user on 8/17/2017.
 */
public class BookTest extends TestCase {
    public BookTest(String name) {
        super(name);
    }

    private RailwayChildren railwayChildren;

    public void setUp() {
        railwayChildren = new RailwayChildren();
    }

    Map<String, Integer> map = railwayChildren.performOperation();

    public void testMap() {
        assertEquals(null, map.get("Markus"));
        assertEquals(3364, map.get("the"), 0);
        assertEquals(2468, map.get("and"), 0);
        assertEquals(1530, map.get("to"), 0);

    }

    public void testPrime() {
        assertEquals(true, Primes.isPrime(map.get("it")));
    }
}
