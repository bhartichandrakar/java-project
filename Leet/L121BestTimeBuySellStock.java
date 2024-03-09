package Leet;

public class L121BestTimeBuySellStock {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        //The code first checks if the input array prices is either null or empty (length is 0). 
        //If it is, it directly returns 0. This is because there's no possibility of making a profit if there are no stock prices.
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // maxProfit: This variable will store the maximum profit achievable so far by buying and selling a single stock. It's initialized to 0.
        // minPrice: This variable will store the minimum price encountered while iterating through the prices array. 
        //It's initialized to the maximum possible integer value (Integer.MAX_VALUE) to ensure the first encountered price becomes the initial minimum buying price.
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE; // Minimum price encountered so far
        //A for-each loop iterates through each element (price) in the prices array. This is a concise way to iterate through an array in Java.
        for (int price : prices) {
            // Updating Minimum Price:

            // Inside the loop, the code checks if the current price (price) is lower than the minPrice encountered so far.
            // If the current price is lower, it means we potentially have a lower buying point. The minPrice is then updated to the current price.
            if (minPrice > price) {
                minPrice = price;
            }
            //Updating Maximum Profit:

            // The code calculates the potential profit for buying at the minimum price (minPrice) and selling at the current price (price) by subtracting minPrice from price.
            // It then compares this potential profit with the current maxProfit.
            // If the potential profit is greater than the maxProfit, it means we've found a better buying and selling opportunity so far. The maxProfit is then updated to the current potential profit.
            else if (maxProfit < (price - minPrice)) {
                maxProfit = price - minPrice;
            }

            //another way of solving
            // minPrice = Math.min(minPrice, price);
            // maxProfit = Math.max(maxProfit, price - minPrice);
        }
        //After iterating through all the prices, the maxProfit variable holds the maximum achievable profit from buying and selling a single stock. The function returns this value.
        return maxProfit;

        //It achieves this with a linear time complexity (O(n)) by iterating through the prices array only once.

        //Brute - Force
        // int maxPro = 0;
        // for(int i = 0; i < prices.length - 1; i++){
        //     for(int j = i + 1; j < prices.length;j++){
        //         if (prices[j] - prices[i] > maxPro) {
        //             maxPro = prices[j] - prices[i];
        //         }
        //     }
        // }
        // return maxPro;
        //Wrong Answer : Cann't change the position
        // Arrays.sort(prices);
        // return prices[prices.length -1] - prices[0];

        //return 0;
    }
    
}


// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
// Example 2:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.
 

// Constraints:

// 1 <= prices.length <= 105
// 0 <= prices[i] <= 104
