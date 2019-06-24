/**

Key points:

    1. Greedy. But could also be implemented with DP.

    2. Reverse order loop.

    3. If current entry > max, set max min to current entry.

    4. If current entry < min, check maxProfit.

Difficulty: Easy

*/
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length < 2) {
            return maxProfit;
        }
        int high = prices.length - 1;
        int low = prices.length - 1;
        for (int i = high-1; i >= 0; i --) {
            if (prices[i] > prices[high]) {
                high = i;
                low = i;
            }
            if (prices[i] < prices[low]) {
                low = i;
                maxProfit = Math.max(maxProfit, prices[high] - prices[low]);
            }
        }
        return maxProfit;
    }
}