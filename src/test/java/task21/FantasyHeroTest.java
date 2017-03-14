package task21;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Valerii Artemenko on 14.03.2017.
 */
public class FantasyHeroTest {
    @Test
    public void damageTest() throws Exception {
        //damage = (intelligence + agility)/2;
        FantasyHero hero = new Troll(10,15,true);
        hero.damage();
        double expected = (double)(10+15)/2;
        double actual = hero.getDamage();
        assertEquals(expected,actual,0.0);
    }

    @Test
    public void fightTest() throws Exception {
        FantasyHero hero1 = new Orc(10,15);
        FantasyHero hero2 = new Elf(10,15,false);
        hero1.creatorPerformance();
        hero2.creatorPerformance();
        for(int i = 0; i<10;i++) {
            hero1.fight(hero2);
        }
        assertTrue(hero2.heath>hero1.heath);
    }

}