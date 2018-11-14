package 乘积最大连续子数组;

import java.util.Scanner;

public class Main {


    public static int maxProduct(int[] nums) {
        int last_max = nums[0];
        int last_min = nums[0];
        int result = nums[0];
        int cur_max = nums[0];
        int cur_min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cur_max = Math.max(nums[i], Math.max(last_max * nums[i], last_min * nums[i]));
            cur_min = Math.min(nums[i], Math.min(last_max * nums[i], last_min * nums[i]));
            result = Math.max(result, cur_max);
            last_max = cur_max;
            last_min = cur_min;
        }

        return result;
    }
    public static void main(String[] args){

//        int[] nums = {-2,3,-2,4};


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n];
        for(int i =0;i<n;i++){
            nums[i] = scanner.nextInt();
        }


        int a = maxProduct(nums);
        System.out.println(a);


    }


}
