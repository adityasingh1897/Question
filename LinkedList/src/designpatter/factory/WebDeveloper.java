package designpatter.factory;

public class WebDeveloper implements Employee{
    @Override
    public int salary() {
        System.out.println("WEB developer salary");
        return 30000;
    }
}
