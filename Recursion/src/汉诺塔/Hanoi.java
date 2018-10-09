package 汉诺塔;

public class Hanoi {

    //A B C 三个柱子, A为源柱子，B为辅助柱子，C为目标柱子，f(n)=2*f(n-1)+1,f(n)=2^n-1

    private static int number = 0;

    public static void main(String[] args){

        hanoi(5,'A','B','C');
    }

    /**
     *
     * @param n 盘子的数目
     * @param origin 源柱子
     * @param assist 辅助柱子
     * @param destination 目的柱子
     */

    //把n个盘子借由辅助柱子从源柱子移到目标柱子
    public static void hanoi(int n, char origin, char assist, char destination){
        if(n == 1){
            move(origin,destination);
        }
        else {
            hanoi(n-1, origin, destination, assist);
            //最底下移动一次
            move(origin,destination);
            hanoi(n-1, assist, origin, destination);

        }
    }

    /**
     *
     * @param origin
     * @param destination
     */
    public static void move(char origin,char destination){
        number++;
        System.out.println("第"+ number + "次从柱子:" + origin + "--->搬运圆盘到柱子" + destination);
    }

}
