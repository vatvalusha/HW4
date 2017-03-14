package task25;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Valerii Artemenko on 14.03.2017.
 */
public class GameTicTacToeTest {
    GameTicTacToe toe;
    @Before
    public void init(){
        toe = new GameTicTacToe();
        toe.fullingField();
    }

    @After
    public void clear(){
        toe = null;
    }

    @Test
    public void isGameOverHorizontalUp() throws Exception {
        toe.field[0] = 1;
        toe.field[1] = 1;
        toe.field[2] = 1;
        assertTrue(toe.isGameOver(0));
    }
    @Test
    public void isGameOverHorizontalMiddle() throws Exception {
        toe.field[3] = 1;
        toe.field[4] = 1;
        toe.field[5] = 1;
        assertTrue(toe.isGameOver(0));
    }
    @Test
    public void isGameOverHorizontalDown() throws Exception {
        toe.field[6] = 1;
        toe.field[7] = 1;
        toe.field[8] = 1;
        assertTrue(toe.isGameOver(0));
    }

    @Test
    public void isGameOverVerticalFirst() throws Exception {
        toe.field[0] = 1;
        toe.field[3] = 1;
        toe.field[6] = 1;
        assertTrue(toe.isGameOver(0));
    }

    @Test
    public void isGameOverVerticalSecond() throws Exception {
        toe.field[1] = 1;
        toe.field[4] = 1;
        toe.field[7] = 1;
        assertTrue(toe.isGameOver(0));
    }

    @Test
    public void isGameOverVerticalThird() throws Exception {
        toe.field[2] = 1;
        toe.field[5] = 1;
        toe.field[8] = 1;
        assertTrue(toe.isGameOver(0));
    }

    @Test
    public void isGameOverDiagonalLeft() throws Exception {
        toe.field[0] = 1;
        toe.field[4] = 1;
        toe.field[8] = 1;
        assertTrue(toe.isGameOver(0));
    }

    @Test
    public void isGameOverDiagonalRight() throws Exception {
        toe.field[2] = 1;
        toe.field[4] = 1;
        toe.field[6] = 1;
        assertTrue(toe.isGameOver(0));
    }
    @Test
    public void isGameOverIncorrectCombination() throws Exception {
        toe.field[1] = 1;
        toe.field[4] = 1;
        toe.field[3] = 1;
        assertFalse(toe.isGameOver(0));
    }


    @Test
    public void getNumber() throws Exception {
        System.out.println("Expected 5!!!");
       assertEquals(toe.getNumber(),Integer.valueOf(5));

    }

}