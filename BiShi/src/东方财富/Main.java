package 东方财富;

public class Main {
    public static void main(String[] args){
        //假设你有一个用1001个整数组成的数组，这些整数是任意排列的，但是你知道所有的整数都在1到1000(包括1000)之间。
        //此外，除一个数字出现两次外，其他所有数字只出现一次。假设你只能对这个数组做一次处理，用一种算法找出重复的那个数字。
        //如果你在运算中使用了辅助的存储方式，那么你能找到不用这种方式的算法吗?

        //设重复数为A，其余999个数异或结果为B。
        //1001个数异或结果为A^A^B
        //1-1000异或结果为A^B
        //由于异或满足交换律和结合律，且X^X = 0  0^X = X;
        //则有
        //(A^B)^(A^A^B)=A^B^B=A

        int a = 12;
        int b = 11;
        System.out.println(a|b);
        System.out.println(a^b);

        int []arr = new int[1001];
        for(int i =0;i<arr.length;i++){
            arr[i] = i+1;


        }
        arr[1000] = 500;
        int result = 0;

        for(int i = 0;i<arr.length;i++){
            result = result^arr[i];

        }

        for(int i = 1;i<1001;i++){
            result = result^i;

        }
        System.out.println(result);




    }
}
