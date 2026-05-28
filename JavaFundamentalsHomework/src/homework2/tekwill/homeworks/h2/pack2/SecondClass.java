package tekwill.homeworks.h2.pack2;

import tekwill.homeworks.h2.pack1.FirstClass;

public class SecondClass {

    String className = this.getClass().getSimpleName();

    public void printNames2(){

        FirstClass firstClass = new FirstClass();
        firstClass.printNames1();

        System.out.printf("%nClass2 Name: %s%nMethode2 Name: %s%n",
                this.className, "printNames2");
    }
}
