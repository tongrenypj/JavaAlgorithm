package 统计;


//题目：如何找出数组中重复次数最多的数。
//        方法一：以空间换时间，即hash法。可以定义一个数组 int count[MAX + 1]，
//        并将其数组元素都初始化为0；然后对原数组array[ ]进行遍历，并执行 count[ array[ i ] ]++ 操作；
//        最后在count数组中找到最大的数，该数在count数组中对应的下标，即为array数组中重复次数最多的数。
//        ---------------------
//        作者：小僧_
//        来源：CSDN
//        原文：https://blog.csdn.net/cyuyanenen/article/details/51746288?utm_source=copy

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){

        fun1();

        fun2();



    }
    public static void fun1(){

        int a[] = {2,2,3,4,5,3,4,5,3,3,6,6,7,7,7,7,7};
        int M = a[0];
        //需要都是正数
        for (int i = 0; i < a.length; i++) // 找出原数组中的最大值
        {
            if(M <= a[i])
                M = a[i];
        }
        M = M +1;
        int count[] = new int[M];

        for (int i = 0; i < a.length ; i++) {
            count[a[i]]++;

        }
        int max = 0;
        int num = 0;
        for (int i = 0; i < M; i++) {
            if(max<count[i]){
                max = count[i];
                num = i;
            }

        }
        System.out.println(max);
        System.out.println(num);

    }
    public static void fun2(){
        int a[] = {2,2,3,4,5,3,4,5,3,3,6,6,7,7,7,7,7};
        Map<Integer,Integer> map = new HashMap();
        int val = a[0];
        for (int i = 0; i < a.length; i++) {

            Integer num = map.get(a[i]);
            if(num == null){
                num =1;
                map.put(a[i],num);
            }else {
                map.put(a[i],++num);
            }
            if(map.get(a[i]) > map.get(val)){

                val = a[i];
            }
        }
        System.out.println(map.get(val));
        System.out.println(val);

    }
}
