package task23;

/**
 * Created by Valerii Artemenko on 12.03.2017.
 */
public class StateApp {
    public static void main(String[] args) {
        State withdrawn = new GrandView();
        GrandForStudy study = new GrandForStudy();
        study.setState(withdrawn);
        for (int i = 0; i < 100; i++) {
            study.currentState();
            study.nextSate();
            if(State.getCounter()==0) i =100;
        }
    }
}

/**
 * State
 */
abstract class State {
    private static int counter = 10;

    static State state = new GrandCreate();

    abstract void currentState();

    abstract void nextState();

    public static void setState(State stateIn) {
        state = stateIn;
    }

    public static State getState() {
        return state;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        State.counter = counter;
    }
}

/**
 * Concrete State
 */
class GrandCreate extends State {
    public void currentState() {
        System.out.print("CREATED: ");
    }

    public void nextState()
    {
        if (Math.random() > 0.5)
            setState(new GrandView());
        else
            setState(new GrandDeferred());
    }
}

/**
 * Concrete State
 */
class GrandView extends State {
    double a = Math.random();

    public void currentState() {
        System.out.print("VIEW: ");
    }

    public void nextState() {
        if (a < 0.25)
            setState(new GrandDeferred());
        else if (0.5 > a && a > 0.25)
            setState(new GrandWithdrawn());
        else if (0.75 > a && a > 0.5)
            setState(new GrandConfirmed());
        else
            setState(new GrandRejected());
    }
}

/**
 * Concrete State
 */
class GrandDeferred extends State {
    public void currentState() {
        System.out.print("DEFERRED: ");
    }

    public void nextState() {
        setState(new GrandView());
    }
}

/**
 * Concrete State
 */
class GrandRejected extends State {
    public void currentState() {
        System.out.print("REJECTED: ");
    }

    public void nextState() {
        setState(new GrandView());
    }
}

/**
 * Concrete State
 */
class GrandConfirmed extends State {
    public void currentState() {
        System.out.print("CONFIRMED: ");
    }

    public void nextState() {
        if (State.getCounter() > 0)
        {
            setState(new GrandCreate());
            State.setCounter(State.getCounter() - 1);
            System.out.println("Apply new Grand. " + "Left : " + State.getCounter() + " place.");
        }
        else {
            System.out.print("\n\nAll grand Accepted");
            System.exit(0);
        }
    }
}

/**
 * Concrete State
 */
class GrandWithdrawn extends State {
    public void currentState() {
        System.out.print("WITHDRAWN: ");
    }

    void nextState() {
        setState(new GrandCreate());
        System.out.println("next grand");
    }
}

/**
 * Context
 */
class GrandForStudy {
    public State getState() {
        return State.getState();
    }

    public static void setState(State stateIn) {
        State.setState(stateIn);
    }

    void nextSate() {
        State.getState().nextState();
    }

    void currentState() {
        State.getState().currentState();
    }

    {//        if (state instanceof GrandCreate) {
//            switch ((int) (Math.random() * 2 + 1)) {
//                case 1:
//                    setState(new GrandView());
//                    break;
//                case 2:
//                    setState(new GrandDeferred());
//                    break;
//            }
//        } else if (state instanceof GrandView) {
//            switch ((int) (Math.random() * 4 + 1)) {
//                case 1:
//                    setState(new GrandDeferred());
//                    break;
//                case 2:
//                    setState(new GrandWithdrawn());
//                    break;
//                case 3:
//                    setState(new GrandConfirmed());
//                    break;
//                case 4:
//                    setState(new GrandRejected());
//                    break;
//            }
//        } else if (state instanceof GrandDeferred) setState(new GrandView());
//        else if (state instanceof GrandRejected) {
//            setState(new GrandView());
//            System.out.print("Sorry, but you not fit us. ");
//            System.out.println("View new grand");
//        } else if (state instanceof GrandConfirmed) {
//            if (countMaxGrand > 0) {
//                setState(new GrandCreate());
//                countMaxGrand--;
//                System.out.println("Apply new Grand. " + "Left : " + countMaxGrand + " place.");
//            } else {
//                System.out.println("Sorry, but we have enough student.");
//            }
//        } else if (state instanceof GrandWithdrawn) {
//            setState(new GrandView());
//            System.out.println("View new grand");
//        }
    }


}



