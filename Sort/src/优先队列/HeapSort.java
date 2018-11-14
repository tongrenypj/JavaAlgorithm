package 优先队列;

public class HeapSort {

    public static int[] array = {0,9, 1, 5, 3, 5, 2, 6, 8, 7, 6};


    //大根队，堆排序
    public static void main(String[] args) {


        //array[0]不算元素
        int N = array.length-1;
        //插入，上浮操作
        for (int k = 1; k <= N ; k++) {

            while (k>1&&less(k/2,k)){
                exch(k/2,k);
                k =k/2;
            }
        }
        for (int i = 1; i <=N; i++) {
            System.out.print(array[i]+" ");
        }

        System.out.println();

        for(int i = N; i >=2 ;){
            exch(1,i);
            //交换后堆范围减小
            i--;
            int k = 1;
            //交换后，下沉操作
            while (2*k<=i){
                int j = 2*k;
                if(j<i&&less(j,j+1))j++;
                if(!less(k,j))break;
                exch(k,j);
                k=j;
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(array[i]+" ");
        }

    }

    public static boolean less(int i,int j){
        return array[i] < array[j];
    }
    public static void exch(int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] =temp;
    }
}
