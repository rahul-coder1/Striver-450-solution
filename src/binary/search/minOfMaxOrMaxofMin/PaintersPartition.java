package binary.search.minOfMaxOrMaxofMin;

public class PaintersPartition {
	 //TC - N*log(sum-max+1)
    public static int checkNoOfBoards(int arr[], long minTime){
      long currentTimeSum=0; int noOfBoards=1;
      for(int i=0;i<arr.length;i++){
          if(currentTimeSum+arr[i]<=minTime)currentTimeSum+=arr[i];
          else{
              currentTimeSum=arr[i];
              noOfBoards+=1;
          }
      }
      
      return noOfBoards;
    }
    public static int minTime(int[] arr, int k) {
        long low=arr[0], high=0, mid=0;
        
        if(k>arr.length) return -1;
        
        for(int i:arr){
            if(i>low) low=i;
            high+=i;
        }
        
        while(low<=high){
            mid=low+(high-low)/2;
            int noOfBoards=checkNoOfBoards(arr,mid);
            if(noOfBoards>k) low=mid+1;
            else high=mid-1;
        }
        
        return (int) low;
    }
    public static void main(String[] args) {
		int[] nums = {10, 20, 30, 40}; int k = 2;
//		int[] nums = {5, 10, 30, 20, 15}; int k = 3;
		System.out.println(minTime(nums,k));
	}
}
