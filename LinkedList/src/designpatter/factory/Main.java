package designpatter.factory;

public class Main {
    public static void main(String[] args) {
Employee employee = Factory.getEmployee("web developer");
        System.out.println(employee.salary());

        Employee employee1 = Factory.getEmployee("java developer");
        System.out.println(employee1.salary());
    }
}
