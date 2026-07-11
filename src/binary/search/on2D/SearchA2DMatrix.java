package binary.search.on2D;

public class SearchA2DMatrix {
    //TC: log(n*m)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int low=0, high=0,mid=0,n=0,m=matrix[0].length;
        for(int[] i:matrix) n+=1;
        high=n*m-1;
        while(low<=high){
            mid=low+(high-low)/2;
            int row=mid/m, col=mid%m;
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]>target) high=mid-1;
            else low=mid+1;
        }

        return false;
    }
    
    public static void main(String[] args) {
//		int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, target = 3;
		int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, target = 13;
		System.out.println(searchMatrix(matrix, target));
	}
}
