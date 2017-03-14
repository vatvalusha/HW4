package task25;


import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Valerii Artemenko on 12.03.2017.
 */
enum Notation {
    X, O, _
}

class GameTicTacToe {

    /**
     * Game field view
     */
    public Object field[] = new Object[9];

    /**
     * @param n input value
     * @return true or false depends on the combination
     */
    boolean isGameOver(Integer n) {
        Integer horizontal = n - n % 3;
        if (field[horizontal] == field[horizontal + 1] && field[horizontal] == field[horizontal + 2])
            return true;
        Integer vertical = n % 3;
        if (field[vertical] == field[vertical + 3] && field[vertical] == field[vertical + 6])
            return true;
        if (field[0] != Notation._ || field[8] != Notation._) {
            if (field[0] == field[4] && field[0] == field[8])
                return true;
            if (n != 4) return false;
        }
        if (field[2] != Notation._ || field[6] != Notation._) {
            if (field[2] == field[4] && field[2] == field[6])
                return true;
            if (n != 4) return false;
        }
        return false;
    }

    /**
     * @return Full field
     */
    public boolean isDraw() {
        for (Object n : field)
            if (n == Notation._)
                return false;
        return true;
    }

    /**
     * @return input value
     * @throws IOException
     */
    public Integer getNumber() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Integer n = 0;
        while (true) {

            if (checkIntegerValueIncorrect(scanner)) {
                n = scanner.nextInt();
            }
            if (n >= 0 && n < field.length) {
                return n;
            } else System.out.println("Big value, choose pleas between 0-8.");
            System.out.println("Choose free cell and enter its number");
        }

    }

    boolean checkIntegerValueIncorrect(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Incorrect form, repeat: ");
            scanner.next();
        }
        return true;
    }

    boolean checkIntegerValueNegative(Scanner scanner) {
        while (scanner.nextInt() < 0) {
            System.out.println("Negative form, repeat");
            scanner.next();
        }
        return true;
    }

    /**
     * fulling field @Notation '_'
     */
    public void fullingField() {
        for (int i = 0; i < field.length; i++) {
            field[i] = Notation._;

        }
    }

    /**
     * current status field
     */
    public void showField() {
        for (int i = 0; i < field.length; i++) {
            if (i == 3 || i == 6) System.out.println();
            System.out.print(field[i] + "  ");
        }
    }

    public void load(Save save) {
        field = save.getField();
    }

    public Save save() {
        return new Save(field);
    }

}

/**
 * Memento
 * will be save our step, and load if we have an error
 */
class Save {
    private final Object[] fieldSave = new Object[9];

    public Save(Object field[]) {
        System.arraycopy(field, 0, this.fieldSave, 0, 9);
    }

    public Object[] getField() {
        return fieldSave;
    }
}

/**
 * Caretaker save our Save inside you-self
 */
class Caretaker {
    Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}

public class TicTacToe {
    static Caretaker caretaker = new Caretaker();
    static GameTicTacToe toe = new GameTicTacToe();


    public static void main(String[] args) throws IOException {
        toe.fullingField();
        playGame();
    }

    public static void loadGame() {
        System.out.println("Load");
        toe.load(caretaker.getSave());
    }

    public static void playGame() throws IOException {
        boolean flag = false;
        boolean check;
        do {
            toe.showField();
            flag = !flag;
            System.out.println();
            System.out.println("Player is: " + (flag ? "X" : "O"));
            Integer n = toe.getNumber();
            toe.field[n] = flag ? Notation.X : Notation.O;
            check = !toe.isGameOver(n);
            if (toe.isDraw()) {
                System.out.print("Field is Full");
                return;
            }
            toe.showField();
            System.out.println("\nChoose: ");
            System.out.print("1.Load \n2.Save \n3.Continue");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    loadGame();
                    break;
                case 2:
                    caretaker.setSave(toe.save());
                    break;
            }
        } while (check);
        toe.showField();
        System.out.println("\nThe winner is " + (flag ? "X-Player" : "O-Player") + "!");
    }
}


