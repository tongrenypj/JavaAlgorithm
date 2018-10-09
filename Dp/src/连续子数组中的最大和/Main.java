package 连续子数组中的最大和;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int S[] = new int[n];
        int a[] = {31,-41,59,26,-53,58,97,-93,-23,84};
        S[0] = a[0];

        for(int i=1;i<a.length;i++){
            S[i] = a[i] + S[i-1];

        }


        for(int i=0;i<S.length;i++){
            System.out.println(S[i]);

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

        System.out.println(result);
    }

}
