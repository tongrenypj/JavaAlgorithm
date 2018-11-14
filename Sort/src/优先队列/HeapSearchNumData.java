package 优先队列;


import java.util.Comparator;
import java.util.PriorityQueue;


public class HeapSearchNumData {

    public static void main(String[] args) {
//        topMaxKNum();
        minKNum();

    }


    public static void testPriorityQueue(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue(3);
        int[] array = {9, 1, 5, 3, 5, 2, 6, 8, 7, 6 };
        for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);
            System.out.print("\n");
            Object[] a = pq.toArray();
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j]);
            }
        }
    }
    //利用大根堆解决获取大量数据中最小的N个值
    //最小的k个数（大根堆）
    public static void minKNum(){

        int[] array = {4,5,1,6,2,7,-5,3,8,-3};
        //最小的k个数
        int k = 4;


        Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2)
                    return 1;
                if (o1 > o2)
                    return -1;
                return 0;
            }
        };

        //大根堆：创建并维护一个大小为K的大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(integerComparator);
        for (int a : array) {
            //把数丢进堆里自动调整,例如上浮操作
            queue.offer(a);
            if (queue.size() > k) {
                queue.poll();

            }
        }
        int a[] = new int[k];
        for(int i =a.length-1;i>=0;i--){
            a[i] = queue.poll();
//            System.out.print(a[i]+" ");
        }
        for (int i = 0; i <a.length ; i++) {

            System.out.print(a[i]+" ");
        }

    }


    /**
     * 利用小根堆解决获取大量数据中最大的个值
     * 找出一个整型数组中第k大的数（小根堆），并输出其下标。其中数组中的数有重复，重复的数据位置全部输出。
     */
    public static void topMaxKNum(){

        int[] array = {9, 1, 5, 3, 5, 2, 6, 8, 7, 6};
        //第k大的数
        int k = 4;



        //默认是小根堆：创建并维护一个大小为K的小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int a : array) {
            //把数丢进堆里自动调整,例如上浮操作
            queue.offer(a);
            if (queue.size() > k) {
                queue.poll();

            }
        }

        int kNum = queue.peek();//第k大的数
        System.out.println(kNum);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (kNum == array[i])
                System.out.println("位置索引在" + i + " ");
        }
    }




}
