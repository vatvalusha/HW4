package task25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Valerii Artemenko on 12.03.2017.
 */
enum Notation {
    X, O, _
}

public class TicTacToe {

    public Object field[] = new Object[9];

    public static void main(String[] args) throws IOException {
        boolean flag = false;
        boolean check;
        TicTacToe toe = new TicTacToe();
        toe.fullingField();
        do {
            flag = !flag;
            toe.showField();
            System.out.println();
            System.out.println("Player " + (flag ? "X" : "O"));
            Integer n = toe.getNumber();
            toe.field[n] = flag ? Notation.X : Notation.O;
            check = !toe.isGameOver(n);
            if (toe.isDraw()) {
                System.out.println("Draw");
                toe.showField();
                return;
            }
        } while (check);
        toe.showField();
        System.out.println();
        System.out.println("The winner is " + (flag ? "X-Player" : "O-Player") + "!");
    }

    boolean isGameOver(Integer n) {
        Integer horizontal = n - n % 3;
        if (field[horizontal] == field[horizontal + 1] && field[horizontal] == field[horizontal + 2])
            return true;
        Integer vertical = n % 3;
        if (field[vertical] == field[vertical + 3] && field[vertical] == field[vertical + 6])
            return true;
        if (field[n % 2] != Notation._) return false;
        if(field[n%4] == Notation._) {
            if (field[0] == field[4] && field[0] == field[8])
                return true;
            if(n!=4) return false;
        }
        return field[2] == field[4] && field[2] == field[6];
    }

    public boolean isDraw() {
        for (Object n : field)
            if (n == Notation._)
                return false;
        return true;
    }

    public Integer getNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            Integer n = Integer.parseInt(reader.readLine());
            if (n >= 0 && n < field.length && field[n] == Notation._) {
                return n;
            }
            System.out.println("Choose free cell and enter its number");
        }
    }

    public void fullingField() {
        for (int i = 0; i < field.length; i++) {
            field[i] = Notation._;

        }
    }

    public void showField() {
        for (int i = 0; i < field.length; i++) {
            if (i == 3 || i == 6) System.out.println();
            System.out.print(field[i] + "  ");
        }
    }
}

