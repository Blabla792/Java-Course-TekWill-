package homework7.task5;

import utils.InputHelper;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        int[] array = InputHelper.getIntArray("Enter a list of integers," +
                "separated by commas: ", ",");

        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = true;
                }
            }
        }

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
