public class Main {

    public static int maxProfit(int[] prices) {

        // TODO 1: Keep track of the lowest price seen so far.
        //
        // Hint:
        // We want to buy at the lowest price before selling.
        // Example: [7, 1, 5, 3, 6, 4]
        // The lowest price becomes 1.

        // TODO 2: Keep track of the maximum profit found so far.
        //
        // Start with 0 because if no profitable transaction is possible,
        // the answer should be 0.

        // TODO 3: Traverse the prices array.
        //
        // For each day:
        // 1. Check the profit we would get by selling today.
        // 2. Update the maximum profit if this profit is better.
        // 3. Update the minimum price if today's price is lower.
        //
        // Hint:
        // profit = current price - minimum price seen so far

        // TODO 4: Return the maximum profit.

        return 0;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = maxProfit(prices);

        System.out.println("Maximum Profit: " + result);
    }
}
