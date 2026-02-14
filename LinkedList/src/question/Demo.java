package question;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
//        System.out.println(checkInclusion("abcdxabcde", "abcdeabcdx"));
//        System.out.println(checkValidString("()"));
//        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
//        System.out.println(decodeString("3[a]2[c]"));
//        System.out.println(oddString(new String[]{"adc", "wzy", "abc"}));
//        wiggleSort(new int[]{1,5,1,1,6,4});
//        System.out.println(countBits(2));
//        System.out.println(findTheDifference("a", "aa"));
//        System.out.println(maxRotateFunction(new int[]{4,3,2,6}));
//        System.out.println(integerReplacement(8));
        System.out.println(addStrings("9","99"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length()-1, index2=num2.length()-1;
        int carry =0;
        while(index1>=0 && index2>=0){
            int temp1 = (num1.charAt(index1--)-48) + (num2.charAt(index2--)-48)+ carry;
            if(temp1 > 9){
                sb.append(temp1%10 );

            }else{
                sb.append(temp1%10);
            }
            carry = temp1/10;
        }
        while(index1>=0){
            int temp = (num1.charAt(index1--)-48) + carry;
            sb.append(temp%10);
            carry = temp/10;
        }
        while(index2>=0){
            int temp = (num2.charAt(index2--)-48) + carry;
            sb.append(temp%10);
            carry = temp/10;
        }
        if(carry != 0 ) sb.append(carry);
        return sb.toString();
    }

    public static int integerReplacement(int n) {
        return replace(n);
    }
    private static int replace(int n){
        if(n==1)
            return 1;
        if(n%2==0){
            return 1+ replace(n/2);
        }else{
           return 1+ Math.min(replace(n+1), replace(n-1));
        }
    }

    public static int maxRotateFunction(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        while(n > 0){
            max = Math.max(getSum(nums,(nums.length - n)), max);
            n--;
        }
        return max;
    }
    private static int getSum(int[] nums, int start){
        int product = 0;
        for(int i =0;i<nums.length;i++){
            if(i+start< nums.length){
                product += (i*nums[i+start]);
            }else{
                product += (i*nums[Math.abs(nums.length -i-start)]);
            }
        }
        return product;
    }

    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(Character ch : t.toCharArray()){
            if(map.get(ch) == null) {
                return ch;
            }else{
                map.put(ch, map.get(ch)-1);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == -1) return entry.getKey();
        }
        return 'a';
    }

    public static int[] countBits(int n) {
        int index = 0;
        List<Integer> list = new ArrayList<>();
//        if(n == 0){
//            list.add(0);
//        }else if(n==1){
//            list.add(1);
//        }
        while(index <= n){
            list.add(countBid(index));
        }
        int[] ans = new int[list.size()];
        for(int i= 0 ; i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    private static int countBid(int n){
        int count = 0;
        while(n > 1){
            if(n % 2 != 0) {
                count++;
            }
            n = n/2;
        }
        if(n==1) count++;
        return count;
    }

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0 ; i<nums.length/2;i++){
            list1.add(nums[i]);
            list2.add(nums[nums.length-1-i]);
        }
int index = 0;
        int id = 0;
        for(int i = 0 ; i<nums.length;i++){
            if(i%2 == 0){
                nums[i] = list1.get(index++);
            }else{
                nums[i] = list2.get(id++);
            }
        }
    }

    public static String oddString(String[] words) {
        List<Integer> set = new ArrayList<>();
        int first = 0;
        for(String s : words){
            int count = 0;
            for(int i = 0 ; i<s.length()-1;i++){
                count += s.charAt(i+1) - s.charAt(i);
            }
            if(!set.contains(count) && first != 0){
                return words[first];
            }else{
                set.add(count);
                first++;
            }
        }
        return words[0];
    }

    public static String decodeString(String s) {
        String ans = "";
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == ']') {
                ans = getData(stack, ans);

            }else {
                stack.add(ch);
            }
        }
        return ans;
    }

    private static String getData(Stack<Character> stack, String ans) {
        String as = "";
        while(stack.peek() != '[') {
            as += stack.pop();
        }
        stack.pop();
        if(!stack.isEmpty())
            ans += getCount(stack.pop()-48, as);
        return ans;
    }


    private static String getCount(int count, String s) {
        String sb = s;
        StringBuilder sBuilder = new StringBuilder(s);
        for(int i = 1; i< count; i++) {
            sBuilder.append(sb);
        }
        s = sBuilder.reverse().toString();
        return s;
    }

    public static int compress(char[] chars) {
    HashMap<Character,Integer> map = new HashMap<>();
for(char ch : chars){
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    StringBuilder sb = new StringBuilder();
for(Map.Entry<Character, Integer> entry : map.entrySet()){
        sb.append(entry.getKey());
        Integer val = entry.getValue();
        if(val > 1){
            sb.append(val);
        }
    }
    chars = new char[sb.length()];
    int index = 0;
for(char ch : sb.toString().toCharArray()){
        chars[index++] = ch;
    }
return chars.length;
}

    public static boolean checkValidString(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(String.valueOf(ch), map.getOrDefault(String.valueOf(ch),0)+1);
        }
        int left = map.get("(") != null ? map.get("(") : 0;
        int right = map.get(")") != null ? map.get(")") : 0;
        int astricks = map.get("*") != null ? map.get("*") : 0;
        int data = Math.abs(left-right);
        return data <= astricks;

    }



    public static boolean checkInclusion(String s1, String s2) {
        int length = s2.length();
        int subLen = s1.length();
        if(length != subLen){
            for (int i = 0; i <= length-subLen; i++) {
                String sub = s2.substring(i, i+subLen);
                if(checkEquality(s1, sub)) {
                    return true;
                }
            }
        }else{
            if(checkEquality(s1, s2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkEquality(String s1, String sub) {
        for (char ch : s1.toCharArray()) {
            if (!sub.contains(String.valueOf(ch))) {
                return false;
            }else {
                sub = sub.replaceFirst(String.valueOf(ch),"");
                // s1 = s1.replace(String.valueOf(ch),"");
            }
        }
        return true;
    }
}
