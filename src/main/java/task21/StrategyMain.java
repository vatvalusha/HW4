package task21;

/**
 * Created by Valerii Artemenko on 11.03.2017.
 */


public class StrategyMain {
    public static void main(String[] args) {
        FantasyHero vampire = new Vampire(10, 15, false);
        vampire.creatorPerformance();
        FantasyHero troll = new Troll(13, 20, true);
        troll.creatorPerformance();
        for(int i = 0; i < 10; i++) {
            troll.fight(vampire);
        }

        System.out.println(vampire.toString());
        System.out.println(troll.toString());
    }

}

/**
 * Strategy
 */
interface WalkAble {
    String walk();
}

/**
 * Strategy
 */
interface FlyAble {
    String fly();
}

class UnableWalk implements WalkAble {
    public String walk() {
        return "I can't walk";
    }
}

class FourUngulatesWalk implements WalkAble {

    public String walk() {
        return "I'm is four ungulates";
    }
}

class WalkCrawl implements WalkAble {
    public String walk() {
        return "I'm crawling";
    }
}

class WalkStright implements WalkAble {
    public String walk() {
        return "I'm the upright creature";
    }
}

class FlyWithWings implements FlyAble {
    public String fly() {
        return "I'm using wings for fly ";
    }
}

class FlyUseMagic implements FlyAble {
    public String fly() {
        return "I'm fly using super magic";
    }
}

class FlyWithCloak implements FlyAble {
    public String fly() {
        return "I'm using cloak for fly";
    }
}

class FlyNoWay implements FlyAble {
    public String fly() {
        return "I can't fly";
    }
}

/**
 * Context
 */
abstract class FantasyHero {
    boolean magic;
    String name;
    double damage;
    double heath = 100;
    double intelligence;
    double agility;

    FlyAble flyAble;
    WalkAble walkAble;

    public double damage() {
        damage = (intelligence + agility)/2;
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
                ",\nagility : " + agility + ",\nmagic : " + magic
                + ",\nFlyAbility : " + flyAble.fly()
                + ",\nWalkAbility : " + walkAble.walk();
    }

    public void creatorPerformance() {
        this.damage();
        this.performFly();
        this.performWalk();
    }

    public void fight(FantasyHero hero) {
        if (this.heath <= 0) {
            System.out.println(this.name + " KILLED");
            return;
        }
        if (hero.heath <= 0) {
            System.out.println(hero.name + " KILLED");
            return;
        }
        this.heath -= hero.damage;
        if (this.heath <= 0) {
            System.out.println(this.name + " KILLED");
            return;
        }
        hero.heath -= this.damage;
        if (hero.heath <= 0) {
            System.out.println(hero.name + " KILLED");
            return;
        }

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

    public Troll(double intelligence, double agility, boolean magic) {
        this.magic = magic;
        name = "Troll";
        this.agility = agility;
        this.intelligence = intelligence;
        if (magic) {
            flyAble = new FlyUseMagic();
        } else flyAble = new FlyNoWay();
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

    public Elf(double intelligence, double agility, boolean magic) {
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
    public Vampire(double intelligence, double agility, boolean magic) {
        this.magic = magic;
        name = "Vampire";
        this.agility = agility;
        this.intelligence = intelligence;
        flyAble = new FlyWithCloak();
        walkAble = new WalkStright();

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
    public Harpy(double intelligence, double agility, boolean magic) {
        this.magic = magic;
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

