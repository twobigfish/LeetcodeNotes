package GreedyAlgorithm;

/**
 * @author: Dayuu
 * @description: 买卖股票的最佳时机 II
 */
public class leetcode122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmppro = prices[i] - prices[i - 1];
            if (tmppro > 0) {
                profit += tmppro;
            }
        }
        return profit;
    }
}
