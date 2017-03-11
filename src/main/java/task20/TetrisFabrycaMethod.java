package task20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Valerii Artemenko on 11.03.2017.
 */
public class TetrisFabrycaMethod {

    static final public String INCORRECT_SYMBOL = "Input please number";
    static final public String SHAPE_DOES_NOT_EXIST = "change count field in shape";

    public static void main(String[] args) {
        Field field = new Field(20);
        for(int i = 0; i<6;i++) {
            TetrisMaker tetrisMaker = getTetrisShapeMaker();
            TetrisShape tetrisShape = getConcreteShape(4, tetrisMaker);
            field.addShapeInField(tetrisShape);
        }

        field.showList(field.shapes);

    }

    public static TetrisShape getConcreteShape(int count, TetrisMaker tetrisMaker){
        Scanner scanner = new Scanner(System.in);
        while (count != 4) {
            System.out.println(SHAPE_DOES_NOT_EXIST);
            while (!scanner.hasNextInt()) {
                System.out.println(INCORRECT_SYMBOL);
                scanner.next();
            }
            count = scanner.nextInt();
        }
        return tetrisMaker.createTetris(count);
    }

    public static TetrisMaker getTetrisShapeMaker() {
        int a = (int) ((Math.random() * 7) + 1);
        switch (a) {
            case 1: return new IShapeMaker();
            case 2: return new JShapeMaker();
            case 3: return new ZShapeMaker();
            case 4: return new OShapeMaker();
            case 5: return new TShapeMaker();
            case 6: return new SShapeMaker();
            case 7: return new LShapeMaker();
            default: throw new RuntimeException(SHAPE_DOES_NOT_EXIST);
        }
    }
}

class Field{
    List<TetrisShape> shapes = new ArrayList<>();

    int capacity;

    public Field(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }


    public void showList(List<TetrisShape> shapes){
        for(TetrisShape shape : shapes) System.out.println(shape);
    }

    public void addShapeInField(TetrisShape shape){
        if(capacity != 0) {
            shapes.add(shape);
            capacity-=4;
        }
        else System.out.println("Field is fulling");
    }
}

abstract class TetrisShape {
    int countField;
    String name;
    abstract int countField();

    @Override
    public String toString() {
        return "TetrisShape{" +
                "countField=" + countField +
                ", name='" + name + '\'' +
                '}';
    }
}

class IShape extends TetrisShape {


    public IShape(int countField) {
        this.countField = countField;
        name = "IShape";
    }

    @Override
    public int countField() {
        return countField;
    }


}

class LShape extends TetrisShape {

    public LShape(int countField) {
        this.countField = countField;
        name = "LShape";
    }

    @Override
    public int countField() {
        return countField;
    }
}

class JShape extends TetrisShape {

    public JShape(int countField) {
        this.countField = countField;
        name = "JShape";
    }

    @Override
    public int countField() {
        return countField;
    }
}

class OShape extends TetrisShape {

    public OShape(int countField) {
        this.countField = countField;
        name = "OShape";
    }

    @Override
    public int countField() {
        return countField;
    }
}

class SShape extends TetrisShape {

    public SShape(int countField) {
        this.countField = countField;
        name = "SShape";
    }

    @Override
    public int countField() {
        return countField;
    }
}

class TShape extends TetrisShape {

    public TShape(int countField) {
        this.countField = countField;
        name = "TShape";
    }

    @Override
    public int countField() {
        return countField;
    }
}

class ZShape extends TetrisShape {

    public ZShape(int countField) {
        this.countField = countField;
        name = "ZShape";
    }

    @Override
    public int countField() {
        return countField;
    }
}

interface TetrisMaker {
    TetrisShape createTetris(int count);
}


class IShapeMaker implements TetrisMaker {
    public TetrisShape createTetris(int count) {
        return new LShape(count);
    }
}


class JShapeMaker implements TetrisMaker {
    @Override
    public TetrisShape createTetris(int count) {
        return new JShape(count);
    }
}


class LShapeMaker implements TetrisMaker {
    @Override
    public TetrisShape createTetris(int count) {
        return new LShape(count);
    }
}


class OShapeMaker implements TetrisMaker {
    @Override
    public TetrisShape createTetris(int count) {
        return new OShape(count);
    }
}


class TShapeMaker implements TetrisMaker {
    @Override
    public TetrisShape createTetris(int count) {
        return new TShape(count);
    }
}


class ZShapeMaker implements TetrisMaker {
    @Override
    public TetrisShape createTetris(int count) {
        return new ZShape(count);
    }
}

class SShapeMaker implements TetrisMaker {
    @Override
    public TetrisShape createTetris(int count) {
        return new SShape(count);
    }
}