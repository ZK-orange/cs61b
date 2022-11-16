import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {
    OffByN offbyn=new OffByN(5);
    @Test
    public void testoffbyn(){
        assertTrue(offbyn.equalChars('a','f'));
        assertTrue(offbyn.equalChars('f','a'));
        assertFalse(offbyn.equalChars('f','h'));
    }
}
