package homework10.part1.task1;

public class Main {

    public static void main(String[] args) {

        FullTimeEmployee employee = new FullTimeEmployee("Blabla", 5000, 10);
        System.out.println(employee.getEmployeeReport());

        System.out.println();

        PartTimeEmployee employee2 = new PartTimeEmployee("Bob", 30, 56);
        System.out.println(employee2.getEmployeeReport());




    }
}
