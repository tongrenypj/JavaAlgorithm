package 买入卖出;

public class Main {


//    这道题非常直观也非常简单。想要通过一次买卖得到的利润，就是要找到一组 i 和 j ，
//    使得 prices[j] - prices[i] 最大，并且满足 i < j 。因为第二个约束条件，我们不会傻到找一个最大值和最小值并且返回它们的差。
//
//    假设 f[i] 为到第 i 天为止可以拿到的最大利润。对于第 i 天，有两种选择，即在当天卖掉股票，或者在第 i 天之前已经卖掉了。
//    那么 f[i] 就是这两种选择中的最大值。如果在第 i 天卖掉股票，那么问题就是在哪天买股票，
//    只要维护一个到第 i 天为止股价的最小值 minPrice 就可以了，此时 f[i] = prices[i] - minPrice ；
//    如果在第 i 天股票已经卖出，则 f[i] = f[i-1] 。
//
//    综上所述，令 f[i] 表示到第 i 天为止可以拿到的最大利润。状态转移方程为 f[i] = max(f[i-1], prices[i] - minPrice) ，
//    其中 minPrice 表示到第 i 天为止的最低股价，并且有 minPrice = min(minPrice, prices[i]) 。
//    边界条件为 f[0] = 0, minPrice = prices[0] 。最终结果为 f[n-1] 。时间复杂度与空间复杂度均为 O(n) 。
//
//    观察状态方程可以发现， f[i] 的值只与 f 数组中的 f[i-1] 有关。也就是说，在计算 f[i] 时，只要保留 f[i-1] 的值就好了，
//    其他的值都可以不保存。据此可以优化空间复杂度。
//
//    令 profit 表示到第 i 天为止可以拿到的最大利润。
//    状态转移方程为 profit = max(profit, prices[i] - minPrice) 。
//    profit 初始化为 0 。最终结果即保存在 profit 中。时间复杂度为 O(n) ，空间复杂度为 O(1) 。

    public static void main(String[] args){
        int a[] = {31,41,59,26,53,58,97,93,23,84};
        //97-26 = 71
        fun1(a);
        fun2(a);
        maxProfit(a);




    }

    public static int fun1(int[] a){
        int maxPro = 0;
        int minPrice = a[0];


        for (int i = 1; i < a.length ; i++) {
            if(a[i] < minPrice){
                minPrice = a[i];
            }
            maxPro = Math.max(maxPro,a[i]- minPrice);

        }
        System.out.println(maxPro);
        return maxPro;
    }
    public static int fun2(int[] prices) {
        int maxProfit=0;//最大利润
        if(prices.length==0)
            return maxProfit;
        int min=prices[0];//当前最小买入价
        for(int i=1;i<prices.length;i++){
            if(prices[i]>min){
                if((prices[i]-min)>maxProfit){
                    maxProfit=prices[i]-min;
                }
            }else {
                min=prices[i];
            }
        }
        System.out.println(maxProfit);

        return maxProfit;
    }
    public static int maxProfit(int[] prices) {
        if(prices.length <=1) return 0;
        int low = prices[0], maxProfit =0;
        for(int i=1; i<prices.length; i++){
            int profit = prices[i] - low;
            if(maxProfit < profit) maxProfit = profit;
            if(prices[i] < low) low = prices[i];
        }
        System.out.println(maxProfit);
        return maxProfit;
    }
}
