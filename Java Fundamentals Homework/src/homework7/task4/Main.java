package homework7.task4;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        int numbersOfRows = InputHelper.getInt("Enter the number of rows of the array: ");

        int[][] array = InputHelper.getIntArrayArray(numbersOfRows,
                ",", false);

        int sum = 0;
        int limit = Math.min(array.length, array[0].length);

        for (int i = 0; i < limit; i++) {
            sum += array[i][i];
        }

        System.out.println("Sum = " + sum);
    }
}
