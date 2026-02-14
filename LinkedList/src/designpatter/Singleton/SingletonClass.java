package designpatter.Singleton;

public class SingletonClass {
    private static SingletonClass instance;
    private SingletonClass(){
    }
    public static SingletonClass getObject(){

        synchronized (SingletonClass.class) {
            if (instance == null) {

                instance = new SingletonClass();
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
