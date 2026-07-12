package binary.search.on2D;

public class FindAPeakElementII {
	public static int findMaxInCol(int[][]mat,int n,int m, int mid){ //mid is representing column index
        int idx=-1, maxVal=-1;
        for(int i=0;i<n;i++){
            if(mat[i][mid]>maxVal){
                idx=i;maxVal=mat[i][mid];
            }
        }
        return idx;
    }
    //TC: n*logm
    public static int[] findPeakGrid(int[][] mat) {
        int n=mat.length, m=mat[0].length;
        int low=0, high=m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=findMaxInCol(mat,n,m,mid);
            int left = mid-1>=0?mat[row][mid-1]:-1;
            int right= mid+1<m?mat[row][mid+1]:-1;
            if(mat[row][mid]>left && mat[row][mid] > right) return new int[]{row,mid};
            else if(left>mat[row][mid]) high=mid-1;
            else low=mid+1;
        }

        return new int[]{-1,-1};
    }
    
    public static void main(String[] args) {
    	int[][] mat = {{1,4},{3,2}};
    	int[] ans = findPeakGrid(mat);
    	for(int i: ans) System.out.printf("%d ",i);
	}
}


















