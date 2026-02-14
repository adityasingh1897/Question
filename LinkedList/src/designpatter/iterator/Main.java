package designpatter.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> s=new ArrayList<>();
        s.add(5);
        s.add(6);
        s.add(7);

        Iterator i = s.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }
}
