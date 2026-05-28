package homework5.task1;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        int age = InputHelper.getInt("Enter your age: ", true);

        String result = age < 18 ? "Minor" : age <= 29 ? "Young" :
                                             age <= 64 ? "Adult" :
                                             "Old";

        System.out.println(result);
    }
}
