package task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4};

        List<Integer> list = new ArrayList<>(numbers.length);
        for (int number: numbers) {
            if(number>0 && number%2 == 0) {
                list.add(number);
            }
        }
        list.sort(Integer::compare);
        System.out.println(list);
    }
}
