package classwork.task001;

import java.util.List;

public class MaxNumberModule {
    public static int findMaxNumber(List<Integer> numbers) {
        int maxNumber = Integer.MIN_VALUE;
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Список пуст");
        }
        for (int number : numbers) {
            if (number > maxNumber) {
                maxNumber = number;
            }
        }
        return maxNumber;
    }

}
