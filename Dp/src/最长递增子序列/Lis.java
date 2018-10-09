package 最长递增子序列;


import java.util.Scanner;


//300 207 155 300 299 170 158 65
public class Lis {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("输出数组长度: " + n);
        int a [] = new int[n];
        for(int k=0;k<n;k++){

            a[k] = scanner.nextInt();
        }

        for(int k=0;k<n;k++){

            System.out.print(a[k] + " ");
        }
        System.out.println();

        int F [] = new int[n];
        F[0] = 1;

        for(int i=1 ;i<n; i++){
            int maxNum = 1;
            for(int j=i-1;j>=0;j--){
                if(a[i] <= a[j]){
                    maxNum = max((F[j] + 1),maxNum);
                }

            }
            F[i] = maxNum;
        }
        for(int i=0;i<n;i++){
            System.out.print(F[i] + " ");
        }

        int maxLength = F[0];
        for(int i=1;i<n;i++){
            maxLength = max(F[i],maxLength);
        }
        System.out.println();
        System.out.println(maxLength);
    }
    public static int max(int a,int b){

        return a > b?a:b;
    }

}
