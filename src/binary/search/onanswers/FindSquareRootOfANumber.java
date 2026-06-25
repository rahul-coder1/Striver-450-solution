package binary.search.onanswers;

//TC - logN
public class FindSquareRootOfANumber {
	
	public static int floorSqrt(int n) {
		int ans = n;
		int low=1,high=n; long mid=0;
		while(low<=high) {
			mid=low+(high-low)/2;
			if(mid*mid<=n) {
				ans=(int) mid; 
				low=(int)(mid+1);
			}
			else high=(int) (mid-1);
		}
		
		return high; //can return high as well
	}
	
	public static void main(String[] args) {
		
		System.out.println(floorSqrt(25));
	}
}







