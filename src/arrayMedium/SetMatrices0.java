package arrayMedium;

public class SetMatrices0 {
	//TC- O(2*n*m) SC - O(n+m)
	static void setZeroes(int[][] matrix) {// [[1,1,1],[1,0,1],[1,1,1]]
		int col = matrix[0].length;
		int row=0;
		for(int[]i: matrix) row++;
		int[] rowArr = new int[row];
		int[]colArr = new int[col];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(matrix[i][j]==0) {
					rowArr[i]=1;colArr[j]=1;
				}
			}
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(rowArr[i]==1 || colArr[j]==1) {
					matrix[i][j]=0;
				}
			}
		}
		
	}
	//TC- O(2*n*m)
	static void setZeroesInplace(int[][] matrix) {
		int col0=1;
		int col = matrix[0].length; //int colArr[col] = matrix[0][..]
		int row=0;					//int rowArr[row] = matrix[..][0]
		for(int[]i: matrix) row++;
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(matrix[i][j]==0) {
					matrix[i][0]=0;
					if(j!=0) matrix[0][j]=0;
					else col0=0;
				}
			}
		}
		
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				if(matrix[i][0]==0 || matrix[0][j]==0){
					matrix[i][j]=0;
				}
			}
		}
		
		if(matrix[0][0]==0)
			for(int j=0;j<col;j++) matrix[0][j]=0;
		if(col0==0)
			for(int i=0;i<row;i++) matrix[i][0]=0;
		
	}
	
	public static void main(String[] args) {
//		int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}}; // ans [[0,0,0,0,][0,4,5,0,][0,3,1,0,]]
//		setZeroes(matrix);
		setZeroesInplace(matrix);
		System.out.print("[");
		for(int[]i:matrix) {
			System.out.print("[");
			for(int j:i) System.out.print(j+",");
			System.out.print("]");
		}
		System.out.print("]");
	}
}











