package 头条;

import java.util.Scanner;

public class Main {

    //zijietiaodong    eng
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        char[] chars = a.toCharArray();
        char[] charsNew = new char[chars.length];
        char cur = 0;

        int j = 0;


        for (int i = 0; i < chars.length ; i++) {
            if(chars[i]!='i'&& chars[i]!='o') {
                charsNew[j] = chars[i];
                j++;
            }
            else {
                if(chars[i]=='i'&&charsNew[0]!=0) {
                    cur = charsNew[j-1];
                    charsNew[j-1] = 0;
                    j--;
                }
                if(chars[i]=='o'&&charsNew[0]!= 0){
                    if(chars[i-1] == 'i'){

                        charsNew[j] = cur;
                        j++;
                    }
                    else {

                        charsNew[j-1] = 0;
                        j--;

                    }
                }
            }
        }


        int i = 0;
        while (charsNew[i]!=0){


            System.out.print(charsNew[i]);
            i++;
        }


    }

}
