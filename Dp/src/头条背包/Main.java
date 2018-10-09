package 头条背包;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Item{
        int x;
        int y;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        String nextLine = scanner2.nextLine();

        List<Item> itemList = new ArrayList<Item>();
        while(nextLine != null && !nextLine.equals("")){
            String [] strArray = nextLine.split(" ");
            Item item = new Item();
            item.x =  Integer.parseInt(strArray[0]);
            item.y =  Integer.parseInt(strArray[1]);
            itemList.add(item);
            nextLine = scanner2.nextLine();
        }

        int sum = itemList.size();
        int dp[][] = new int[sum+1][n+1];
        for(int i=0;i<=n;i++){
            dp[0][i] =0;
        }
        for(int i=1;i<=sum;i++){
            for(int j=n;j>=itemList.get(i-1).x;j--){

                dp[i][j] = max(dp[i-1][j],dp[i-1][j-itemList.get(i-1).x]+itemList.get(i-1).y);

            }
            for(int j=itemList.get(i-1).x-1;j>=0;j--){

                dp[i][j]=dp[i-1][j];
            }


        }
        for(int i=1 ; i<=sum;i++) {
            System.out.println(dp[i][n]);
        }

    }
    public static int max(int a,int b){

        return a>b?a:b;

    }

}
