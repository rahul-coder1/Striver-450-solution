package arrayMedium;

public class StocksBuyandsell {
	//TC- O(N)
	static int maxProfit(int[] prices) {
		int maxProfit=0, minBuy=prices[0], profit=0;
		for(int i=1;i<prices.length; i++) {
			profit = prices[i]-minBuy;
			maxProfit=maxProfit>profit?maxProfit:profit; // 0 4 4 5 3
			minBuy=Math.min(prices[i], minBuy);
		}
		
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int arr[] = {7,1,5,3,6,4};
//		int arr[] = {7,6,4,3,1};
		System.out.println(maxProfit(arr));
	}
}
