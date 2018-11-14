package 字符串替换;

public class Main {
    public static void main(String[] args){

        String str = "a b  c";
        char[] chars = new char[200];
        for (int i = 0; i <str.length() ; i++) {
            chars[i] = str.charAt(i);
        }

        for (int i = 0; i <chars.length &&chars[i] !=0 ; i++) {
            System.out.print(chars[i]);
        }
        replace(chars);

        System.out.println();

        for (int i = 0; i <chars.length &&chars[i] !=0 ; i++) {
            System.out.print(chars[i]);
        }

        System.out.println();

        char[] chars2 = "12**345".toCharArray();
        revert(chars2);

        for (int i = 0; i <chars2.length &&chars[i] !=0 ; i++) {
            System.out.print(chars2[i]);
        }
        System.out.println();

        char[] chars3 = "12df345".toCharArray();
        fuZhi(chars3);

        for (int i = 0; i <chars3.length &&chars[i] !=0 ; i++) {
            System.out.print(chars3[i]);
        }

    }
    public static void replace(char[] chars){
        if(chars == null || chars.length ==0){
            return;
        }
        int num = 0;
        int len = 0;
        for(len = 0;len<chars.length && chars[len] !=0;len++){
            if(chars[len] == ' '){

                num++;
            }

        }
        int j = len + num*2 - 1;
        //for(int i = len -1;i < j;i--){
        for(int i = len -1;i > -1;i--){
            if(chars[i] != ' '){
                chars[j--] = chars[i];
            }
            else {
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';

            }

        }

    }

    //倒着复制，12**345 ，**12345
    public static void revert(char[] chars){
        if(chars == null || chars.length ==0){
            return;
        }

        int j = chars.length -1;

        for (int i = chars.length-1; i > -1  ; i--) {
            if(chars[i]!='*'){
                chars[j] = chars[i];
                j--;
            }
        }
        for (;j> -1 ;j--){
            chars[j] = '*';

        }
    }

    //倒着复制，12df345 ，4512df3
    public static void fuZhi(char[] chars){
        if(chars == null || chars.length ==0){
            return;
        }

        int j = 5;
        for(;j>0;j--) {
            char temp = chars[0];

            for (int i = 1; i < chars.length; i++) {
                chars[i-1] = chars[i];

            }
            chars[chars.length-1] = temp;

        }
    }








}
