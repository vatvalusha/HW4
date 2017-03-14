package task24;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Valerii Artemenko on 14.03.2017.
 */
public class PaymentsTest {
    @Test
    public void takeMoneyPreferential() throws Exception {
        Money money = new Money(3000);
        Payments payments = new Preferential(Type.PREFERENTIAL);
        assertTrue(payments.takeMoney(money,200) == 200);
    }

    @Test
    public void takeMoneyIntrabank() throws Exception {
        Money money = new Money(3000);
        Payments payments = new Intrabank(Type.INTRABANK);
        assertTrue(payments.takeMoney(money,200) == 196);
    }

    @Test
    public void takeMoneyState() throws Exception {
        Money money = new Money(3000);
        Payments payments = new State(Type.STATE);
        assertTrue(payments.takeMoney(money,200) == 170);
    }
    @Test
    public void takeMoneyConventional() throws Exception {
        Money money = new Money(3000);
        Payments payments = new Conventional(Type.CONVENTATION);
        assertTrue(payments.takeMoney(money,200) == 180);
    }


}