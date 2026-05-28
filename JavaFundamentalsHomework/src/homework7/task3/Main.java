package homework7.task3;

import utils.InputHelper;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int numbersOfRows = InputHelper.getInt("Please enter the number of rows of the array: ");

        int [][] array = InputHelper.getIntArrayArray(numbersOfRows,
                ",", false);

        int[][] transposedArray = new int[array[0].length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                transposedArray[j][i] = array[i][j];
            }
        }

        for (int[] n : transposedArray) {
            System.out.println(Arrays.toString(n));
        }
    }
}
