package task24;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Valerii Artemenko on 14.03.2017.
 */
public class MoneyTest {
    @Test(expected = IllegalArgumentException.class)
    public void setAtmTest() throws Exception {
        Money money = new Money(40);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setAtmZeroValueTest() throws Exception {
        Money money = new Money(0);
    }
    @Test
    public void setAtmCorrectTest() throws Exception {
        assertEquals(Money.setAtm(100),100);
    }

    @Test
    public void setAfterTakeMoneyCorrectValueTest() throws Exception {
        Money money = new Money(200);
        assertEquals(100,Money.setAfterTakeMoney(100));
    }

    @Test
    public void setAfterTakeMoneyATMHaveNotEnoughMoneyTest() throws Exception {
        Money money = new Money(200);
        assertEquals(0,Money.setAfterTakeMoney(300));
    }

}