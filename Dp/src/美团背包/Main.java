package 美团背包;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            int X = scanner.nextInt();
            int sum = 0;
            int price[] = new int[n];

            for (int i = 0; i < n; i++) {
                price[i] = scanner.nextInt();
                sum += price[i];
            }

            if (sum < X) {
                System.out.println("-1");
                continue;
            }
            int m = sum - X;
            int[] dp = new int[m + 1];

            for (int i = 0; i < n; i++) {
                for (int j = m; j >= 0; j--) {
                    if (price[i] > j) break;//该菜品必须添加
                    dp[j] = Math.max(dp[j - price[i]] + price[i], dp[j]);
                }
            }
            System.out.println(sum - dp[m]);

        }
    }
}

