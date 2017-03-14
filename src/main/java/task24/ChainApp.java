package task24;

/**
 * Created by Valerii Artemenko on 13.03.2017.
 */
public class ChainApp {
    public static void main(String[] args) {
        Money money = new Money(30000);
        Payments payment1 = new Preferential(Type.CONVENTATION);
        Payments payment2 = new Conventional(Type.PREFERENTIAL);
        Payments payment3 = new State(Type.STATE);
        Payments payment4 = new Intrabank(Type.INTRABANK);

        payment1.setNext(payment2);
        payment2.setNext(payment3);
        payment3.setNext(payment4);


        payment1.showInfo(Type.STATE,money,300);
        delimiter();
        payment1.showInfo(Type.PREFERENTIAL,money,400);
        delimiter();
        payment1.showInfo(Type.STATE,money,500);
        delimiter();
        payment1.showInfo(Type.INTRABANK,money,6000);
    }

    public static void delimiter(){
        System.out.println("--------------------------------------");
    }

}

class Type{
    public static final int CONVENTATION = 1;
    public static final int PREFERENTIAL = 2 ;
    public static final int STATE = 3;
    public static final int INTRABANK = 4 ;
}

class Money{
    private int atm;


    public Money(int atm) {
        setAtm(atm);
    }

    public int getAtm() {
        return atm;
    }

    public void setAtm(int atm) {
        if(atm>0 && atm<50000 && atm%50 == 0)
            this.atm = atm;
        else System.out.println("Can't be more then 50_000");
    }
    public int setAfterTakeMoney(int amount){
        if(this.atm>amount)
            return this.atm -= amount;
        else {
            System.out.println("Atm haven't enough money");
            return 0;
        }
    }


    public String toString() {
        return "Atm contain : " + atm+";";
    }
}

abstract class Payments{
    int priority;
    Payments next;

    public Payments(int priority) {
        this.priority = priority;
    }

    public void setNext(Payments next) {
        this.next = next;
    }
    public int takeMoney(Money money,int count) {
        int result = 0;
        if(money.getAtm() == 0) {
            System.out.println("Atm empty!");
        }
        if(count>0 && count<money.getAtm()){
            result =count - (count/100)*percent();
            money.setAfterTakeMoney(result);
        }else {
            System.out.println("count must be more then 0 or Atm haven't enough money");
        }
        return result;
    }
    public int showCurrentAmount(Money money){
        return money.getAtm();
    }
    public abstract int percent();

    public void showInfo(int priority, Money money, int count){
        if(this.priority == priority){
            System.out.println(toString());
            System.out.println("Taken money : " + takeMoney(money,count));
            System.out.println("Current amount in atm: " + showCurrentAmount(money));
        }
        if(next!=null){
            next.showInfo(priority,money,count);
        }
    }
    public abstract String forHwo();

    public String toString(){
        return "For : " + forHwo()+";\n"
                +"Percent : " + percent()+";";
    }
}

class Conventional extends Payments{
    public Conventional(int priority) {
        super(priority);
    }
    public int percent() {
        return 10;
    }

    public String forHwo() {
        return "Conventional";
    }
}

class Preferential extends Payments{

    public Preferential(int priority) {
        super(priority);
    }

    public int percent() {
        return 0;
    }

    public String forHwo() {
        return "Preferential";
    }
}

class State extends Payments{
    public State(int priority) {
        super(priority);
    }

    public int percent() {
        return 15;
    }

    public String forHwo() {
        return "State";
    }
}

class Intrabank extends Payments{

    public Intrabank(int priority) {
        super(priority);
    }

    public int percent() {
        return 2;
    }

    public String forHwo() {
        return "Inside-bank";
    }
}
