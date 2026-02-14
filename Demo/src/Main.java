import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
////            System.out.println("i = " + i);
////            System.out.println(maxKDistinct(new int[]{84,93,100,77,93}, 3));
//            System.out.println(reverseOnlyLetters("ab-cd"));
//        }
List<Integer> list = new ArrayList<>();
list.add(3);
list.add(4);
list.add(5);
        for(int j = 0;j<=list.size()/2;j++){
            int temp = list.get(j);
            int temp1 = list.get(list.size()-1-j);
            list.add(j, temp1);
            list.add(list.size()-1-j, temp);
        }
        System.out.println(list);
    }

    public static String reverseOnlyLetters(String s) {
        int i =0;

        char[] arr = s.toCharArray();
        int j= arr.length-1;
        while(i<j){
            char ch = arr[i];
            char ch1 = arr[j];
            if(Character.isLetter(ch) && Character.isLetter(ch1)){
                arr[i++] = ch1;
                arr[j--] = ch;
            }
            if(!Character.isLetter(ch)){
                i++;
            }
            if(!Character.isLetter(ch1)){
                j--;
            }
        }
        return new String(arr);
    }
    public static int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> ans = new LinkedHashSet<>();
        for(int i = nums.length-1;i>=0;i--){
            if(ans.size() < k){
                // if(i > 0 && ans.size() < k && nums[i] != nums[i-1]){
                ans.add(nums[i]);
            }
        }
        int[] ans1 = new int[ans.size()];
        int i = 0;
        for(int a: ans){
            ans1[i++] = a;
        }
        return ans1;
    }
}