package homework6.task6;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {
        while (true){

            // Use the DoubleInputs class to get 2 variables from user
            DoubleInputs numbers = new DoubleInputs();

            mainMenu();
            int userMenuChose = InputHelper.getInt("Choose an option: ",
                    true);

            if (userMenuChose == 5) {
                break;
            } else if (userMenuChose >= 6) {
                System.out.println("Wrong choice, please try again\n");
            } else {
                numbers.getNumbers();

                double result;
                switch (userMenuChose) {
                    case 1 -> {
                        result = numbers.firstNumber + numbers.secondNumber;
                        System.out.println(result);
                    }
                    case 2 -> {
                        result = numbers.firstNumber - numbers.secondNumber;
                        System.out.println(result);
                    }
                    case 3 -> {
                        result = numbers.firstNumber * numbers.secondNumber;
                        System.out.println(result);
                    }
                    case 4 -> {
                        result = numbers.firstNumber / numbers.secondNumber;
                        System.out.println(result);
                    }
                }
            }
        }
    }

    public static void mainMenu() {
        System.out.println("""
                1. Addition of two numbers
                2. Subtraction of two numbers
                3. Multiplication of two numbers
                4. Division of two numbers
                5. Exit
                """);
    }

    public static class DoubleInputs {
        double firstNumber;
        double secondNumber;

        public void getNumbers() {
            firstNumber = InputHelper.getDouble("Please enter the first number: ");
            secondNumber = InputHelper.getDouble("Please enter the second number: ");
        }
    }
}
