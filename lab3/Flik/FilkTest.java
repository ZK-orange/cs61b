import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class FilkTest {
    @Test
    public void testSameNumber(){
        int a=128;
        int b=128;
        org.junit.Assert.assertTrue(Flik.isSameNumber(a, b));
    }
}
