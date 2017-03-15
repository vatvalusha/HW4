package task27;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Valerii Artemenko on 15.03.2017.
 */
public class ArrayTask {
    public static void main(String[] args) {
        List<Integer> month = new ArrayList<Integer>();
        month.add(1);
        month.add(2);
        month.add(3);
        month.add(4);
        month.add(5);
        month.add(6);
        month.add(7);
        month.add(8);
        month.add(9);
        month.add(10);
        month.add(11);
        month.add(12);
        List<Integer> month2 = new ArrayList<Integer>();
        month2.add(13);
        month2.add(14);
        month2.add(15);
        month2.add(16);
        month2.add(17);
        month2.add(18);
        month2.add(19);
        month2.add(20);
        month2.add(21);
        month2.add(22);
        month2.add(23);
        month2.add(24);
        List<Integer> month3 = new ArrayList<Integer>();
        month3.add(25);
        month3.add(26);
        month3.add(27);
        month3.add(28);
        month3.add(29);
        month3.add(30);
        month3.add(31);
        month3.add(32);
        month3.add(33);
        month3.add(34);
        month3.add(35);
        month3.add(36);
        List<List<Integer>> product = new ArrayList<>();
        product.add(month);
        product.add(month2);
        product.add(month3);

        Object array[][] = new Object[3][12];
        for (int i = 0; i<array.length;i++){
            for(int j = 0; j<array[i].length;j++){
                array[i][j] = new Random().nextInt(100);
            }
        }
        for(int i = 0; i<array.length;i++){
            for (Object o : array[i]){
                System.out.print(o+" ");
            }
            System.out.println("");
        }
        System.out.println();
        for(int i = 0; i<product.size();i++){
            for(int j = 0;j<product.get(i).size();j++){
                System.out.print(product.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println(showPrice(3,12,product));
    }
    static int showPrice(int numHor, int numVer, List<List<Integer>> list){
        if(numHor>list.size()+1 || numVer>list.get(1).size()+1){
            System.out.println("not exist");
            return 0;
        }
        for(int i = 0; i<list.size();i++){
            for(int j = 0; j<list.get(i).size();j++){
                if((numHor-1) == i && (numVer-1) == j)
                    return list.get(i).get(j);
            }
        }
        return 0;
    }
}
