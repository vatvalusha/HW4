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
        }
    }
}

/**
 * State
 */
interface State {
    void currentState();
}

class GrandCreate implements State {
    public void currentState() {
        System.out.print("CREATED: ");
    }
}

class GrandView implements State {
    public void currentState() {
        System.out.print("VIEW: ");
    }
}

class GrandDeferred implements State {
    public void currentState() {
        System.out.print("DEFERRED: ");
    }
}

class GrandRejected implements State {
    public void currentState() {
        System.out.print("REJECTED: ");
    }
}

class GrandConfirmed implements State {
    public void currentState() {
        System.out.print("CONFIRMED: ");
    }
}

class GrandWithdrawn implements State {
    public void currentState() {
        System.out.print("WITHDRAWN: ");
    }
}

/**
 * Context
 */
class GrandForStudy {
    State state = new GrandCreate();

    public State getState() {
        return state;
    }

    private int countMaxGrand = 10;

    public void setState(State state) {
        this.state = state;
    }

    public int getCountMaxGrand() {
        return countMaxGrand;
    }

    void nextSate() {
        if (state instanceof GrandCreate) {
            switch ((int) (Math.random() * 2 + 1)) {
                case 1:
                    setState(new GrandView());
                    break;
                case 2:
                    setState(new GrandDeferred());
                    break;
            }
        } else if (state instanceof GrandView) {
            switch ((int) (Math.random() * 4 + 1)) {
                case 1:
                    setState(new GrandDeferred());
                    break;
                case 2:
                    setState(new GrandWithdrawn());
                    break;
                case 3:
                    setState(new GrandConfirmed());
                    break;
                case 4:
                    setState(new GrandRejected());
                    break;
            }
        } else if (state instanceof GrandDeferred) setState(new GrandView());
        else if (state instanceof GrandRejected) {
            setState(new GrandView());
            System.out.print("Sorry, but you not fit us. ");
            System.out.println("View new grand");
        } else if (state instanceof GrandConfirmed) {
            if (countMaxGrand > 0) {
                setState(new GrandCreate());
                countMaxGrand--;
                System.out.println("Apply new Grand. " + "Left : " + countMaxGrand + " place.");
            } else {
                System.out.println("Sorry, but we have enough student.");
            }
        } else if (state instanceof GrandWithdrawn) {
            setState(new GrandView());
            System.out.println("View new grand");
        }
    }

    void currentState() {
        state.currentState();
    }
}
