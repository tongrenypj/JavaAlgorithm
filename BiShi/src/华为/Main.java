package 华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {



        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        while (n/10 !=0){
            int a = n%10;
            list.add(a);
            n = n/10;

        }
        int b = n%10;
        list.add(b);
        for(Integer a:list){

            System.out.print(a);
        }
    }


}
