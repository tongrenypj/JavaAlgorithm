package 拼多多.第二题;

import java.util.Scanner;

public class Main {
    public static int fun() {
        Scanner scanner = new Scanner(System.in);
        String version1= scanner.nextLine();
        String version2= scanner.nextLine();


        int index1 = 0,index2 = 0,count1 = 0,count2 = 0,max = 0,a,b;



        while (index1 < version1.length() || index1 < version2.length()) {
            while (index1 < version1.length() && version1.charAt(index1) != '.') {
                count1++;
                index1++;
            }
            while (index2 < version2.length() && version2.charAt(index2) != '.') {
                count2++;
                index2++;
            }
            max = count1 > count2 ? count1 : count2;
            for (int i = max; i >= 1; i--) {
                a = count1 - i >= 0 ? version1.charAt(index1 - i) - '0' : 0;
                b = count2 - i >= 0 ? version2.charAt(index2 - i) - '0' : 0;
                if (a > b) {

                    return 1;

                } else if (a < b) {
                    return -1;
                }
            }

            count1 = 0;
            count2 = 0;
            index1++;
            index2++;
        }
        return 0;


    }

    public static void main(String[] args){
        int a = fun();
        System.out.println(a);

    }

}
