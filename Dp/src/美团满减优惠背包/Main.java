package 美团满减优惠背包;

import java.util.Scanner;

/**
 * 最近天气炎热，小Ho天天宅在家里叫外卖。他常吃的一家餐馆一共有N道菜品，价格分别是A1, A2,
 * ... AN元。并且如果消费总计满X元，还能享受优惠。小Ho是一个不薅羊毛不舒服斯基的人，
 * 他希望选择若干道不同的菜品，使得总价在不低于X元的同时尽量低。
 * 你能算出这一餐小Ho最少消费多少元吗？
 * <p>
 * 原文：https://blog.csdn.net/luny231/article/details/52143445?utm_source=copy
 * 样例输入
 * 10 50
 * 9 9 9 9 9 9 9 9 9 8
 * 样例输出
 * 53
 * <p>
 * 5 20
 * 18 19 17 6 7
 * 23
 */

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), x = in.nextInt(), sum = 0;
        int price[] = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = in.nextInt();
            sum += price[i];
        }

        if (sum < x) {
            System.out.println("-1");

        }

        //背包情境：尽可能多放，相当于从差值中去掉没必要加入的菜品
        int m = sum - x;
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (price[i] < j) break;
                //该菜品必须添加
                dp[j] = Math.max(dp[j - price[i]] + price[i], dp[j]);
            }
        }
        System.out.println(sum - dp[m]);
    }


}

