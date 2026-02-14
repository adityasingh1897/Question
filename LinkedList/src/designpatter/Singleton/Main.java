package designpatter.Singleton;

public class Main {
    public static void main(String[] args){
        SingletonClass s1 = SingletonClass.getObject();

        System.out.println(s1.hashCode());


        SingletonClass s2 = SingletonClass.getObject();

        System.out.println(s2.hashCode());
    }
}
