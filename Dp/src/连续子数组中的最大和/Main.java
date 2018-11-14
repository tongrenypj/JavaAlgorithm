package 连续子数组中的最大和;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        int a[] = {-31,31,-59,-26,-53,-58,-97,-93,-23,-84};
        int b[] = new int[3];
        for (int i = 0; i < b.length ; i++) {
            System.out.print(b[i]+" ");
        }
        System.out.println();
        for (int k:b) {
            System.out.print(k+" ");
        }

        System.out.println();

//        my();

        calMaxSumOfArray(a);
        calMaxSumOfArray2(a);
        calMaxSumOfArrayDp(a);
        calMaxSumOfArrayDp1(a);



    }
    public static void my(){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int S[] = new int[n];

//        int a[] = {-31,31,-59,-26,-53,-58,-97,-93,-23,-84};

        int a[] = {31,-41,59,26,-53,58,97,-93,-23,84};
        S[0] = a[0];

        for(int i=1;i<a.length;i++){
            S[i] = a[i] + S[i-1];

        }

        for(int i=0;i<S.length;i++){
            System.out.print(S[i]+" ");

        }
        int begin = 0;
        int end = 0;
        int maxNum = S[0];
        int minNum = S[0];
        for(int i = 0; i<S.length;i++){
            if(S[i] > maxNum){
                end = i;
                maxNum = S[i];
            }
        }
        for(int i=0;i<end;i++){
            if(S[i] < minNum){
                begin = i;
                minNum = S[i];

            }
        }
        int result = 0;
        if(minNum < 0){
            result = S[end] - S[begin];
        }
        else {
            result = S[end];
        }
        System.out.println();

        System.out.println(result);
    }
    //暴力 o(n^2)
    public static int calMaxSumOfArray(int[] a) {
        if (null == a) {
            return 0;
        }
        if (a.length == 1) {
            return a[0];
        }
        int sum = a[0];
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            temp = a[i];
            if(sum < temp) {
                sum = temp;
            }

            //开始从a[i]往它之后遍历，相加，再跟sum对比
            for (int j = i + 1; j < a.length; j++) {
                temp = temp + a[j];
                if(sum < temp) {
                    sum = temp;
                }
            }
        }
        System.out.println(sum);

        return sum;
    }
    //非动态规划的方法
    public static int calMaxSumOfArray2(int[] a) {
        if (null == a) {
            return 0;
        }
        if (a.length == 1) {
            return a[0];
        }
        int sum = a[0];
        int ThisSum = a[0];
        for (int i = 1; i < a.length; i++) {
            if (ThisSum < 0) {
                ThisSum = 0;
            }
            ThisSum = ThisSum + a[i];
            if (sum < ThisSum) {
                sum = ThisSum;
            }
        }
        System.out.println(sum);
        return sum;

    }
    //https://blog.csdn.net/u014259820/article/details/79628758?utm_source=copy
    //动态规划。状态方程：max(dp[i]) = getMax(max(dp[i-1]) + a[i], a[i])。我们从头开始遍历数组，
    //遍历到a[i]时，最大和可能是max(dp[i-1])+a[i]，也可能是a[i]。时间复杂度O(n)，空间复杂度O(n)。代码如下：

    public static int calMaxSumOfArrayDp1(int[] a) {
        if (null == a) {
            return 0;
        }
        if (a.length == 1) {
            return a[0];
        }
        int sum = a[0];
        int temp = a[0];
        for (int i = 1; i < a.length; i++) {
            temp = Math.max(temp + a[i], a[i]);
            if (sum < temp) {
                sum = temp;
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static int calMaxSumOfArrayDp(int[] a) {
        if (null == a) {
            return 0;
        }
        if (a.length == 1) {
            return a[0];
        }
        int dp[] = new int[10];
        int sum = a[0];
        dp[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            dp[i] = Math.max(dp[i-1] + a[i], a[i]);
            if (sum < dp[i]) {
                sum = dp[i];
            }
        }
        System.out.println(sum);
        return sum;
    }
}
