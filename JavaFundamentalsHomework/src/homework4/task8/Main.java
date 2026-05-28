package homework4.task8;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        int score = InputHelper.getInt("Exam score: ", true);

        if (score < 60) {
            System.out.println("F");
        } else if (score <= 69) {
            System.out.println("D");
        } else if (score <= 79) {
            System.out.println("C");
        } else if (score <= 89) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }
    }
}
