package designpatter.factory;

public class JavaDeveloper implements Employee{
    @Override
    public int salary() {
        System.out.println("java developer salary");
        return 40000;
    }
}
