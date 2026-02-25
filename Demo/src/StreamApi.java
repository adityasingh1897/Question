import javax.swing.plaf.OptionPaneUI;
import java.util.*;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        //even number
        List<Integer> list = Arrays.asList(5, 2, 2, 4, 4, 6);
        List<Integer> ans = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
//        System.out.println(ans);
//        list.stream().filter(n->n%2==0).forEach(System.out::println);

        //toUpperCase
        List<String> names = Arrays.asList("jAva", "spRiNg", "bOot");
//        List<String> name = names.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
        List<String> name = names.stream().map(String::toUpperCase).collect(Collectors.toList());
//        System.out.println(name);

        //sum of number
        int sum = list.stream().mapToInt(Integer::intValue).sum();
//        System.out.println(sum);

        //max, min
        Optional<Integer> max = list.stream().max(Integer::compare);
        Optional<Integer> min = list.stream().min(Integer::compare);
//        System.out.println(max + "  - " + min);

        //char frequency
        String s = "java";
        Map<Character, Long> count = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        //remove duplicates

        List<Integer> distinct = list.stream().distinct().collect(Collectors.toList());
//        System.out.println(distinct);

        //sort
        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
//        System.out.println(sorted);

        //first non repeating character
        Optional<Character> nonRepeat = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c , Collectors.counting())).entrySet()
                .stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst();
//        System.out.println(nonRepeat);
        //all non repeat
        //first non repeating character
        List<Character> nonRepeat1 = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c , Collectors.counting())).entrySet()
                .stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
//        System.out.println(nonRepeat1);

        //second highest number

        Optional<Integer> num = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
//        System.out.println(num);

        //group string by length
        List<String> words = Arrays.asList("hi","hello","hey","bye");
        Map<Integer, List<String>> group = words.stream().collect(Collectors.groupingBy(String::length));
//        System.out.println(group);

        //word frequency

        String sentence = "java is good java is powerful";
        Map<String, Long> sen = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(v->v , Collectors.counting()));
//        System.out.println(sen);

        Map<Boolean, List<Integer>> result = list.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
//        System.out.println(result);

        //longest stream
        Optional<String> longest = words.stream().max(Comparator.comparing(String::length));
//        System.out.println(longest);

        //common element between two list

        List<Integer> list1 = Arrays.asList(1,2,3,4);
        List<Integer> list2 = Arrays.asList(3,4,5,6);

        List<Integer> common = list1.stream().filter(list2::contains).collect(Collectors.toList());
//        System.out.println(common);
    }
}

