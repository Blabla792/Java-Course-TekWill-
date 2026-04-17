package tekwill.course.pack2;

import tekwill.course.pack1.FirstClass;

public class SecondClass {

    String className = this.getClass().getSimpleName();

    public void printNames2(){

        FirstClass firstClass = new FirstClass();
        firstClass.printNames1();

        System.out.printf("Class2 Name: %s\nMethode2 Name: %s",
                this.className, "printNames2");
    }
}
