package binary.search.oned;

public class FloorCeil {
	public static int ceil(int[] arr, int target) {
		int res = -1;
		int low=0, high=arr.length-1, mid=0;
		
		while(low<=high){
			mid=low+(high-low)/2;
			if(arr[mid]>=target) {
				res=arr[mid]; high=mid-1;
			}else {
				low=mid+1;
			}
		}
		
		return res;
	}

    public static int floor(int[] arr, int target) {
		int res = -1;
		int low=0, high=arr.length-1, mid=0;
		
		while(low<=high){
			mid=low+(high-low)/2;
			if(arr[mid]<=target) {
				res=arr[mid]; low=mid+1;
			}else {
				high=mid-1;
			}
		}
		
		return res;
	}

    public static void main(String[] args) {
		//int[] nums= {3, 4, 4, 7, 8, 10}; int x=5;
		int[] nums= {3, 4, 4, 7, 8, 10}; int x=8;
		int[] ans = new int[2];
		ans[0]=floor(nums, x);
		ans[1]=ceil(nums, x);
		for(int i: ans) {System.out.printf("%d ",i);};
	} 
      
}
