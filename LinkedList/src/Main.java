import java.util.LinkedList;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        ll.push(new ListNode(new ListNode(), 5));
//        while(!ll.isEmpty()) {
//            System.out.println(ll.pop().value);
//        }

//        System.out.println(maxProduct(new int[]{3,4,5,1,2}));
//        System.out.println(compareVersion("1.2","1.10"));
//        System.out.println(majorityElement(new int[]{3,2,3}));
//        System.out.println(nthUglyNumber(10));
//        sum(5,3,5);
//        System.out.println(threeSum(new int[]{-100,-70,-60,110,120,130,160}));

    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            // if(nums[i]<0 && nums[i+1]<0 && nums[i+2]<0) continue;
            //   for(int j = i+1;j<nums.length -1;j++){

            // for(int k = j+1;k<nums.length;k++){

            while (j < k ) {
                int sum = nums[i] + nums[j];
                if (Math.abs(sum) < nums[k]) {
                    k--;
                } else if (Math.abs(sum) > nums[k]) {
                    j++;
                } else {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ll.add(nums[i]);
                        ll.add(nums[j]);
                        ll.add(nums[k]);
                    }
//                    if (!ll.isEmpty()) {
//                        if (check(result, ll))
                            result.add(ll);
                        ll = new ArrayList<>();
//                    }
                    j++;
                    k--;
                }
            }

        }
        return result;
    }

    private static boolean check(List<List<Integer>> list, List<Integer> ll) {
        for (List<Integer> l : list) {
            List<Integer> copy = new ArrayList<>(ll);
            for (Integer i : l) {
                copy.remove(i);
            }
            if (copy.isEmpty())
                return false;
        }

        return true;
    }

    public static void sum(int a, int b, int n){
        int sum = 0;
        for(int i =0;i<n;i++){
            sum += a + b *(int) Math.pow(2, i);
            System.out.print(sum + " ");
        }
    }

    public static int nthUglyNumber(int n) {
        List<Integer> factor = Arrays.asList(2,3,5);
        int num = 1;
        int val = 1;
        while(n > 0){
            val = num;
            for(Integer fac : factor){
                while(num%fac == 0){
                    num /= fac;
                }
            }
            if(num == 1){

                n--;
            }
            num = val +1;


        }
        return val;
    }

    public int[] productExceptSelf(int[] nums) {
        // boolean isZero = false;
        int k = 0;
        int[] arr = new int[nums.length];
        for(int i : nums){
            int product = 1;
            for(int j : nums){
                if(i != j){
                    product *=j;
                }
            }
            arr[k++] = product;
            // if(i != 0){
            //     product *= i;
            // } else{
            //     isZero = true;
            // }
        }
        //    for(int i = 0 ; i< nums.length;i++){
        //     if(isZero && nums[i] != 0){
        //         nums[i] = 0;
        //     }else if(nums[i] == 0){
        //             nums[i] = product;
        //     }else{
        //         nums[i] = product/nums[i];
        //     }

        //    }
        return nums;
    }

    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : nums) {
            if (map.containsKey(j)) {
                map.put(j, map.getOrDefault(j, 1) + 1);
            } else {
                map.put(j, 1);
            }
        }
        int num = nums.length/3;
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> temp : map.entrySet()){
            if(num < temp.getValue())  list.add(temp.getKey());
        }
        return list;
    }
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for( int i =0;i<v1.length;i++){
            int a = Integer.parseInt(v1[i]);
            int b = Integer.parseInt(v2[i]);
            if(a<b){
                return -1;
            }else if(a>b){
                return 1;
            }
        }
        return 0;
    }

    public static int maxProduct(int[] nums) {
//        int sum =0;
//        for(int i = 0; i<nums.length-1;i++){
//            for(int j =i+1;j<nums.length;j++){
//                int temp = getSum(i, j, nums);
//                if(temp > sum){
//                    sum = temp;
//                }
//            }
//        }
//        return sum;
        int i =0,j=nums.length-1;
        while(i>j){
            if(nums[i] > nums[j]){
                i++;
            }else{
                j--;
            }
        }
        return nums[j];
    }
    private static int getSum(int i, int j,int[] nums){
        int sum =1;
        for(int k =i;k<=j;k++){
            sum *= nums[k];
        }
        return sum;
    }
}

