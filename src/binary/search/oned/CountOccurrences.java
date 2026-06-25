package binary.search.oned;

public class CountOccurrences {
	 public static int firstOcc(int[] arr, int target) {
			int res = -1;
			int low=0, high=arr.length-1, mid=0;
			
			while(low<=high){
				mid=low+(high-low)/2;
				if(arr[mid]==target) {
					res=mid; high=mid-1;
				}else if(arr[mid]<target) {
					low=mid+1;
				} else { high = mid-1;}
			}
			
			return res;
		}
	    public static int lastOcc(int[] arr, int target) {
			int res = -1;
			int low=0;
			int high=arr.length-1;
			int mid=0;
			
			while(low<=high){
				mid=low+(high-low)/2;
				if(arr[mid]==target) {
					res=mid; low=mid+1;
				}else if(arr[mid]<target) {
					low=mid+1;
				} else { high = mid-1;}
			}
			
			return res;
		}
	    
	    public static void main(String[] args) {
	    	
//	    	int[]nums = {0, 0, 1, 1, 1, 2, 3}; int target = 1;
	    	int[]nums = {5, 5, 5, 5, 5, 5}; int target = 5;
	    	int lb = firstOcc(nums,target);
	        if(lb==-1) System.out.printf("%d",-1);
	        System.out.printf("%d",lastOcc(nums,target)-lb+1);
		}
}




