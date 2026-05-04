package homework6.task3;

public class Main {

    public static void main(String[] args) {

        int number = 100;
        while (true)  {

            number++;
            if (number % 7 == 0) {
                if (number % 9 == 0) {
                    System.out.println("Result: " + number);
                    break;
                }
            }
        }
    }
}
