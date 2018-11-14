package mokun;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        //adcdfc 2  cdfcad  两部分交换
        Scanner scanner = new Scanner(System.in);


        String a = scanner.nextLine();
        int j = scanner.nextInt();
        char[] chars = a.toCharArray();
        if(chars == null || chars.length ==0){
            return;
        }


        for(;j>0;j--) {
            char temp = chars[0];

            for (int i = 1; i < chars.length; i++) {
                chars[i-1] = chars[i];

            }
            chars[chars.length-1] = temp;

        }
        for (int i = 0; i <chars.length &&chars[i] !=0 ; i++) {
            System.out.print(chars[i]);
        }
    }
}