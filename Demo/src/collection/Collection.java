package collection;

import java.util.*;

public class Collection {
    public static void main(String[] args) {
//       list();
//        set();
        map();
    }

    private static void map(){
        Map<String, Integer > map = new HashMap<>();
        map.put("virat", 18);
        map.put("msd", 7);
        System.out.println("put : " + map);

        Map<String , Integer> map1 = new HashMap<>();
        map1.put("virat", 100);
        map1.put("aditya", 101);

        map.putAll(map1);
        System.out.println("put all : " + map);

        System.out.println("get :" + map.get("virat"));

        map.remove("msd");
        System.out.println("renove : " + map);

        map.replace("virat", 30);
        System.out.println("replace : " + map);

        System.out.println("contains key : " + map.containsKey("aas") + "  conatains value : " + map.containsValue(101));

        System.out.println("key set : " + map.keySet());

        System.out.println("values : " + map.values());


        for (Map.Entry<String , Integer> entry  : map.entrySet()){
            String  key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key value  : "  + entry);
            System.out.println("key : " + key);
            System.out.println( "value  : " + value);

        }
    }

    private static void set(){
        Set<String> st = new HashSet<>();
        st.add("virat");
        st.add("dhoni");
        st.add("gautam");
        st.add("bhavesh");
        st.add("virat");
        st.add("dhoni");
        st.add("raja");
        st.add("baja");
        System.out.println(st);

        st.remove("virat");
        System.out.println(st);
        Set<String > st2 = new HashSet<>();
        st2.add("tata");
        st2.add("bata");
        st.addAll(st2);
        System.out.println(st);

//        System.out.println(st.);
    }

    private static void list(){
        List<String> list = new ArrayList<>();
        list.add("Ram");
        list.add("shyam");
        System.out.println("notmal add : "  + list);

        List<String> list2 = Arrays.asList("data", "bata");
        list.addAll(list2);
        System.out.println("add all : " + list);

//        list.add(list2.toString());
//        System.out.println("list of list : " + list);

        list.remove("Ram");
        System.out.println("remove of object : "  + list);

//        list.remove(1);
        System.out.println("remove at index : " + list);

//        list.removeAll(list2);
        System.out.println("remove collection : " + list);

//        System.out.println("contains check : " + list.contains("shfyam"));

        System.out.println("contains all : " + list.containsAll(list2));

        System.out.println("check empty : "+ list.isEmpty());

//        list.clear();
        System.out.println("clear data : " + list.isEmpty());

        System.out.println("get data at index : " + list.get(0));

        list.set(0, "srishty");

        System.out.println(Arrays.toString(list.toArray()));

        ArrayList<String> arr = new ArrayList<>(list);
        System.out.println(arr);
    }

}
