package task17;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Valerii Artemenko on 14.03.2017.
 */
public class TreeFactoryTest {
    @Test
    public void getCalculateTree() throws Exception {
        Component plus1 = new OperatorPlus(new Number(1),new Number(2));
        Component plus2 = new OperatorPlus(new Number(3),new Number(6));
        Component multy1 = new OperatorMultiplicate(plus1, new Number(4));
        Component multy2 = new OperatorMultiplicate(plus2,new Number(5));
        Component res = new OperatorPlus(multy1,multy2);
        double actual = res.calculate();
        double expected = (1+2)*4 + 5*(3+6);
        assertEquals(expected,actual,0.1);
    }

}