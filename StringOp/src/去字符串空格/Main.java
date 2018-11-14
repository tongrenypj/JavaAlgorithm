package 去字符串空格;

public class Main {

    public static void main(String[] args){
        fun1();

        System.out.println();
        fun2();
    }
    //去除空格，用_代表空格
    public static void fun1(){
        String a = "__2aa_dg_gfhda_da!dg3___";

        //Stri a = "2aadggfhdada!dg3a!dg3___";
        char[] chars = a.toCharArray();
        int N = 0;
        int j = 0;
        int i = 0;

        //处理头部字符串
        while (chars[j]=='_'){
            j++;
        }
        while (j<chars.length){
            if(chars[j] == '_'){
                //中间或者结尾的空格
                j++;
                continue;
            }
            chars[i++] = chars[j++];
            N++;

        }

        for (int k = 0; k < chars.length ; k++) {
            System.out.print(chars[k]);
        }
        System.out.println();
        for (int k = 0; k < N ; k++) {
            System.out.print(chars[k]);
        }

    }


    public static void fun2(){
        String a = "__i__am_____a____little_boy___";
        //Stri a = "i_am_a_little_boy";
        char[] chars = a.toCharArray();
        int N = 0;
        int j =0;
        int i =0;


        while (chars[j]=='_'){
            j++;
        }
        while (j<chars.length){
            if(chars[j] == '_'&&(j+1 == chars.length || chars[j+1] == '_')){
                j++;
                continue;
            }
            chars[i++] = chars[j++];
            N++;

        }

        for (int k = 0; k <chars.length ; k++) {
            System.out.print(chars[k]);
        }
        System.out.println();
        for (int k = 0; k <N ; k++) {
            System.out.print(chars[k]);
        }

    }
}
//https://blog.csdn.net/ysbj123/article/details/51899756
//void FormatString(char str[], int len)
//{
//  if(str == NULL || len <= 0)
//  return;
// 
//  int i = 0, j = 0;
//  while(str[i] == ' ')//开头的空格
//    i++;
//  while(str[i] != '\0')
//  {
//    if(str[i] == ' ' && (str[i+1] == ' ' || str[i+1] == '\0'))
//    {
////中间或者结尾的空格
//        i++;
//        continue;
//    }
//    str[j++] = str[i++];
//  }
//  str[j] = '\0';
//}
