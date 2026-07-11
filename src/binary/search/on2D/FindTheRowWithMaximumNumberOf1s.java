package binary.search.on2D;


//TC - O(n*log2m)
public class FindTheRowWithMaximumNumberOf1s {
	public static int lowerBound(int[]arr,int val) {
		int low=0, high=arr.length-1, mid=0;
		
		while(low<=high) {
			mid=low+(high-low)/2;
			if(arr[mid]>=val) high=mid-1;
			else low=mid+1;
					
		}
		
		return low;
	}
	
	public static int rowWithMax1s(int[][] arr) {
		int n=0,m=arr[0].length, cnt_max=0, idx=-1;
		for(int[] i:arr) {
			n+=1;
		}
		
		for(int i=0;i<n;i++) {
			int cnt_ones= m-lowerBound(arr[i],1);
			if(cnt_ones>cnt_max) {
				idx=i; cnt_max=cnt_ones;
			}
		}
		
		return idx;
	}
	
	public static void main(String[] args) {
		int[][] arr =   {{0,1,1,1},
						{0,0,1,1},
						{1,1,1,1},
						{0,0,0,0}};
		
		System.out.println(rowWithMax1s(arr));
		
	}
}










