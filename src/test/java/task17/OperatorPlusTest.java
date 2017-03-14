package task17;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Valerii Artemenko on 14.03.2017.
 */
public class OperatorPlusTest {
    @Test
    public void calculate() throws Exception {
        Component operation = new OperatorPlus(new Number(3),new Number(7));
        int expected = 10;
        int actual = operation.calculate();
        assertEquals(expected,actual);
    }

}