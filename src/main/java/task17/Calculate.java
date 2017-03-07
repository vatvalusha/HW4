package task17;

/**
 * Created by Valerii Artemenko on 07.03.2017.
 */
abstract class Component{
    public abstract int calculate();
}

class Number extends Component{

    int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int calculate() {
        return value;
    }
}

class OperatorPlus extends Component{
    Component left;
    Component right;

    public OperatorPlus(Component left, Component right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public int calculate() {
        return left.calculate()+right.calculate();
    }
}


class OperatorMultiplicate extends Component{
    Component left;
    Component right;

    public OperatorMultiplicate(Component left, Component right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public int calculate() {
        return left.calculate()*right.calculate();
    }
}

class TreeFactory{
    public static Component getCalculateTree(){
        Component plus1 = new OperatorPlus(new Number(1),new Number(2));
        Component plus2 = new OperatorPlus(new Number(3),new Number(6));
        Component multy1 = new OperatorMultiplicate(plus1, new Number(4));
        Component multy2 = new OperatorMultiplicate(plus2,new Number(5));
        return new OperatorPlus(multy1,multy2);
    }
}

public class Calculate {
    public static void main(String[] args) {
        Component  component = TreeFactory.getCalculateTree();
        System.out.println(component.calculate());
    }
}
