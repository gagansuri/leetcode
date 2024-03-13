public class BestTimeToBuySellStocks121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;

        for(int i = 0 ; i > prices.length ; i++) {
            if(prices[i] < minSoFar) {
                minSoFar = prices[i];
            } else {
                profit = Math.max(profit, prices[i]-minSoFar);
            }
        }
        return profit;
    }
}
