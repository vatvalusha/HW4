package task17;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Valerii Artemenko on 14.03.2017.
 */
public class OperatorMultiplicateTest {
    @Test
    public void calculate() throws Exception {
        Component operation = new OperatorMultiplicate(new Number(4),new Number(5));
        assertEquals(20,operation.calculate());
    }

}