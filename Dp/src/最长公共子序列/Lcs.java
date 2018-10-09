package 最长公共子序列;

import java.util.Scanner;

public class Lcs {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String S1 = scanner.nextLine();
        String S2 = scanner.nextLine();

        int n = S1.length();
        int m = S2.length();

        int dp[][] = new int [n+1][m+1];
        for (int i = 0; i <=n ; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <=m ; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1 ;

                }
                else {
                    if(dp[i-1][j] > dp[i][j-1]){
                        dp[i][j] = dp[i-1][j];
                    }
                    else {
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }
        System.out.println(dp[n][m]);

    }

}
