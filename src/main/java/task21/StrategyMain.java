package task21;

/**
 * Created by Valerii Artemenko on 11.03.2017.
 */


public class StrategyMain {
    public static void main(String[] args) {
        FantasyHero hero = new Vampire(10, 15);
        System.out.println(hero.toString());
        hero.performFly();
        hero.performWalk();
    }
}

interface WalkAble {
    void walk();
}

interface FlyAble {
    void fly();
}

class UnableWalk implements WalkAble {
    public void walk() {
        System.out.println("I can't walk");
    }
}

class FourUngulatesWalk implements WalkAble {

    public void walk() {
        System.out.println("I'm is four ungulates");
    }
}


class WalkCrawl implements WalkAble {
    public void walk() {
        System.out.println("I'm crawling");
    }
}

class WalkStright implements WalkAble {
    public void walk() {
        System.out.println("I'm the upright creature");
    }
}

class FlyWithWings implements FlyAble {
    public void fly() {
        System.out.println("I'm using wings for fly ");
    }
}

class FlyWithCloak implements FlyAble {
    public void fly() {
        System.out.println("I'm using cloak for fly");
    }
}

class FlyNoWay implements FlyAble {
    public void fly() {
        System.out.println("I can't fly");
    }
}


abstract class FantasyHero {
    String name;
    double damage;
    double heath = 100;
    double intelligence;
    double agility;

    FlyAble flyAble;
    WalkAble walkAble;

    public double damage() {
        damage = intelligence * (agility / 4.9);
        return damage;
    }

    abstract public void display();

    public void setFlyAble(FlyAble flyAble) {
        this.flyAble = flyAble;
    }

    public void setWalkAble(WalkAble walkAble) {
        this.walkAble = walkAble;
    }

    public void performFly() {
        flyAble.fly();
    }

    public void performWalk() {
        walkAble.walk();
    }

    public double getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "heath : " + heath +
                ",\nintelligence : " + intelligence +
                ",\nagility : " + agility;
    }
}

class Orc extends FantasyHero {

    public Orc(double intelligence, double agility) {
        name = "Orc";
        this.agility = agility;
        this.intelligence = intelligence;
        flyAble = new FlyNoWay();
        walkAble = new WalkStright();
    }

    @Override
    public void display() {
        System.out.println("Angry Orc");
    }

    @Override
    public String toString() {
        return super.toString() + ",\nname : " + name + ",\ndamage : " + damage;
    }
}

class Troll extends FantasyHero {

    public Troll(double intelligence, double agility) {
        name = "Troll";
        this.agility = agility;
        this.intelligence = intelligence;
        flyAble = new FlyNoWay();
        walkAble = new WalkStright();
    }

    @Override
    public void display() {
        System.out.println("Pray for the priest");
    }

    @Override
    public String toString() {
        return super.toString() + ",\nname : " + name + ",\ndamage : " + damage;
    }
}

class Pegasus extends FantasyHero {

    public Pegasus(double intelligence, double agility) {
        name = "Pegasus";
        this.agility = agility;
        this.intelligence = intelligence;
        flyAble = new FlyWithWings();
        walkAble = new FourUngulatesWalk();
    }

    @Override
    public void display() {
        System.out.println("good soul");
    }

    @Override
    public String toString() {
        return super.toString() + ",\nname : " + name + ",\ndamage : " + damage;
    }
}

class Elf extends FantasyHero {

    public Elf(double intelligence, double agility) {
        name = "Elf";
        this.agility = agility;
        this.intelligence = intelligence;
        flyAble = new FlyNoWay();
        walkAble = new WalkStright();
    }

    @Override
    public void display() {
        System.out.println("quick runner");
    }

    @Override
    public String toString() {
        return super.toString() + ",\nname : " + name + ",\ndamage : " + damage;
    }
}


class Vampire extends FantasyHero {
    public Vampire(double intelligence, double agility) {
        name = "Vampire";
        this.agility = agility;
        this.intelligence = intelligence;
        flyAble = new FlyWithCloak();
        walkAble = new WalkStright();
        damage();
    }

    @Override
    public void display() {
        System.out.println("like blood");
    }

    @Override
    public String toString() {
        return super.toString() + ",\nname : " + name + ",\ndamage : " + damage;
    }
}

class Harpy extends FantasyHero {
    public Harpy(double intelligence, double agility) {
        name = "Harpy";
        this.agility = agility;
        this.intelligence = intelligence;
        flyAble = new FlyWithWings();
        walkAble = new WalkCrawl();
    }

    @Override
    public void display() {
        System.out.println("good soul");
    }

    @Override
    public String toString() {
        return super.toString() + ",\nname : " + name + ",\ndamage : " + damage;

    }
}

