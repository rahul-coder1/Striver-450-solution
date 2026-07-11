package binary.search.on2D;

public class SearchA2DMatrixII {
	//TC: o(n+m)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length, m=matrix[0].length;
        int row=0,col=m-1;
        while(row<n && col>=0){
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]>target) col-=1;
            else row+=1;
        }

        return false;
    }
    
    public static void main(String[] args) {
//		int matrix[][] = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, target = 5;
		int matrix[][] = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, target = 20;
		System.out.println(searchMatrix(matrix, target));
	}
}
