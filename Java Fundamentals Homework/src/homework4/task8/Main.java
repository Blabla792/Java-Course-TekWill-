package homework4.task8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Exam score: ");
        Scanner input = new Scanner(System.in);
        int score = input.nextInt();

        if (score < 60) {
            System.out.println("F");
        }  else if (score <= 69) {
            System.out.println("D");
        }  else if (score <= 79) {
            System.out.println("C");
        }  else if (score <= 89) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }
    }
}
