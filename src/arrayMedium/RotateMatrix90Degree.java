package arrayMedium;

public class RotateMatrix90Degree {
	
	//TC - O(n/2*n/2) + O(n*n/2)
	static void rotate(int[][] matrix) {
		int n = matrix[0].length;
		
		//transpose
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				swap(matrix,i,j);
			}
		}
		
		//reverse
		for(int[] i:matrix)
			reverse(i,n);
	}
	
	static void swap(int[][] matrix, int i, int j) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = temp;
	}
	
	static void reverse(int[]arr, int n) {
		int i=0,j=n-1;
		while(i<j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;j--;
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}}; // ans [[7,4,1],[8,5,2],[9,6,3]]
		rotate(matrix);
		System.out.print("[");
		for(int[]i:matrix) {
			System.out.print("[");
			for(int j:i) System.out.print(j+",");
			System.out.print("]");
		}
		System.out.print("]");
	}
}




















