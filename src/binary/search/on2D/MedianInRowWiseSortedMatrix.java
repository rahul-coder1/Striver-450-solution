package binary.search.on2D;

public class MedianInRowWiseSortedMatrix {
	public static int upperBound(int[] arr, int target) {//pointing to index which is just greater than target
		int low=0, high=arr.length-1, mid=0;
		
		while(low<=high){
			mid=low+(high-low)/2;
			if(arr[mid]>target) {
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		
		return low;
     }
    public static int countSmallEqual(int[][]mat, int mid){
        int cnt=0;int n=mat.length;
        for(int i=0;i<n;i++){
            cnt+=upperBound(mat[i],mid);
        }
        return cnt;
    }
    //TC- log(maxElementInMatrix)*n*log(m)
    public static int median(int[][] mat) {
        int n=mat.length; int m=mat[0].length;
        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(mat[i][0]<low) low=mat[i][0];
            if(mat[i][m-1]>high) high=mat[i][m-1];
        }
        int required=(n*m)/2;
        while(low<=high){
            int mid=low+(high-low)/2;
            int smallerOrEqualTo = countSmallEqual(mat,mid);
            if(smallerOrEqualTo<=required) low=mid+1;
            else high=mid-1;
        }
        
        return low;
    }
    public static void main(String[] args) {
//		int mat[][] = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
		int mat[][] = {{2, 4, 9}, {3, 6, 7}, {4, 7, 10}};
		System.out.println(median(mat));
	}
}



























