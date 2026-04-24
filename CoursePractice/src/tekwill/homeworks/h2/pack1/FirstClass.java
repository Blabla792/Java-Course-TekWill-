package tekwill.homeworks.h2.pack1;

public class FirstClass {

    String className = this.getClass().getSimpleName();

    public void printNames1() {
        System.out.printf("Class1 Name: %s%nMethode1 Name: %s%n",
                this.className, "printNames1");
    }
}
