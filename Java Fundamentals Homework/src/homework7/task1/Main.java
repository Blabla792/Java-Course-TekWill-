package homework7.task1;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        int[] array = InputHelper.getIntArray("Please enter a list of integers," +
                " separated by commas: ", ",");

        int maxNumber = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i];
                index = i;
            }
        }

        System.out.printf("Maximum value in array is %d with index %d",maxNumber, index);
    }
}
