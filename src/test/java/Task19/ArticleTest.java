package Task19;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by Valerii Artemenko on 14.03.2017.
 */
public class ArticleTest {

    public int[] arrey(){
        int a[] = new int[7];
        for(int i = 3;i<a.length;i++){
            a[i]=i;
        }
        return a;
    }

    public boolean check(int number, int a[]){
        boolean b = false;
        for(int i = 0; i<a.length;i++){
            if (number == a[i])
                b = true;
        }
        return b;
    }
    @Test
    public void checkPagesSmallCount() throws Exception {
        assertEquals(Article.checkPages(3),3);
    }

    @Test
    public void checkPagesBigCount() throws Exception {
        assertEquals(Article.checkPages(10),10);
    }

}