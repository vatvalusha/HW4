package task26;

import java.util.*;

/**
 * Created by Valerii Artemenko on 15.03.2017.
 */
public class FlyweightAPP {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        List<Bacterium> bacteriumList = new ArrayList<>();
        bacteriumList.add(factory.getBacterium("Lactobacillus"));
        bacteriumList.add(factory.getBacterium("Staphylococcusaureus"));
        bacteriumList.add(factory.getBacterium("Bifidobacterium"));
        bacteriumList.add(factory.getBacterium("EscherichiaColi"));
        bacteriumList.add(factory.getBacterium("Bifidobacterium"));
        bacteriumList.add(factory.getBacterium("Lactobacillus"));

        for(Bacterium bacterium:bacteriumList){
            bacterium.display();
        }
    }

}

abstract class Bacterium{
    String name;
    String type;
    int count;
    Random random = new Random();

    public Bacterium() {
    }
    abstract void display();



    @Override
    public String toString() {
        return getClass().getName() +": "+
                " name: " + name + '\'' +
                ", count:" + count + "type: "+type+";";
    }

}

class Lactobacillus extends Bacterium{
    int index = 1;


    public Lactobacillus() {
        count = random.nextInt(100000);
        name = "Lactobacillus";
        type = "Firmikuta";
    }

    @Override
    void display() {
        System.out.println("From Lacto. Count: "+count+" Index: " + index);
    }
}

class Staphylococcusaureus extends Bacterium{
    int index = 2;

    public Staphylococcusaureus() {
        count = random.nextInt(100000);
        name = "Staphylococcusaureus";
        type = "Firmikuta";
    }

    @Override
    void display() {
        System.out.println("From Staphy.Count: "+count+" Index: " + index);
    }
}

class EscherichiaColi extends Bacterium{
    int index = 3;

    public EscherichiaColi() {
        count = random.nextInt(100000);
        name = "EscherichiaColi";
        type = "\n" +
                "Proteobacteria";
    }

    @Override
    void display() {
        System.out.println("From Coli. Count: "+count+" Index: " + index);
    }
}


class Bifidobacterium extends Bacterium{
    int index = 4;

    public Bifidobacterium() {
        count = random.nextInt(100000);
        name = "Bifidobacterium";
        type = "Actinobacteria";
    }

    @Override
    void display() {
        System.out.println("From Bifido. Count: "+count+" Index: " + index);
    }
}

class FlyweightFactory {
    private Map<String, Bacterium> bacteriums = new HashMap<String, Bacterium>();

    public Bacterium getBacterium(String bacteriumName){
        Bacterium bacterium = bacteriums.get(bacteriumName);
        if (bacterium == null){
            switch (bacteriumName){
                case "Lactobacillus" : {
                    bacterium = new Lactobacillus();
                    break;
                }
                case "Staphylococcusaureus" : {
                    bacterium = new Staphylococcusaureus();
                    break;
                }
                case "EscherichiaColi" : {
                    bacterium = new EscherichiaColi();
                    break;
                }
                case "Bifidobacterium" : {
                    bacterium = new Bifidobacterium();
                    break;
                }
            }
            bacteriums.put(bacteriumName, bacterium);
        }
        return bacterium;
    }

}
