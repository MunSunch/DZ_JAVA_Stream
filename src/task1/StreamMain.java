package task1;

import java.util.Arrays;

public class StreamMain {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4};
        Arrays.stream(numbers)
                .filter(x -> x>0)
                .filter(x -> x%2 == 0)
                .sorted()
                .forEach(x -> System.out.print(x + " "));
    }
}
