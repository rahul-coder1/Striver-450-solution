package recursion.hard;
import java.util.*;

public class NQueens {
	//TC - o(N*N! + S*N^2), N! comes from solve() recursive search
    //SC - o(s*n^2 - res) + o(n^2 - board)+o(n) - stack + o(n^2) - op store
    public static List<List<String>> solveNQueensBetter(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        // for(int i=0;i<board.length;i++){
        //     Arrays.fill(board[i],'.');
        // }
        for(char[] row: board){
            Arrays.fill(row,'.');
        }

        solveBetter(0, board, res, n);

        return res;
    }
    // o(n), 3 scans each o(n) in worst case
    public static boolean safeToPlaceBetter(int row, int col, char[][] board){
        //left upper diagonal
        int dupRow = row, dupCol = col;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row-=1; col-=1;
        }

        //left row
        row=dupRow; col=dupCol;
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col-=1;
        }

        //left lower diagonal
        row = dupRow; col = dupCol;
        while(row<board.length && col>=0){
            if(board[row][col]=='Q') return false;
            row+=1; col-=1;
        }

        return true;
    }
    static void solveBetter(int col, char[][] board, List<List<String>> res, int n){
        if(col>=n){
            res.add(convertToStringList(board));
            return;
        }

        for(int row=0; row<n; row++){
            if(safeToPlaceBetter(row,col,board)){
                board[row][col] = 'Q';
                solveBetter(col+1,board,res,n);
                //backtrack
                board[row][col]='.';
            }
        }
    }

    public static List<String> convertToStringList(char[][] board){
        List<String> op = new ArrayList<>();
        for(char[] row: board){
            op.add(new String(row)); //String is arr of chars, so char[] row passed is joined and returned as String
        }

        return op;
    }
    
    //-------------------------------------
    
  //TC - o(N*N! + S*N^2), N! comes from solve() recursive search
    //SC - o(s*n^2 - res) + o(n^2 - board)+o(n) - stack + o(n^2) - op store + o(n - for 3 hash arrays)
    public static List<List<String>> solveNQueensOptimal(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        int[] leftRow = new int[n];
        int[] upperLDiagonal = new int[2*n-1];
        int[] lowerLDiagonal = new int[2*n-1];
        for(char[] row: board){
            Arrays.fill(row,'.');
        }

        solveOptimal(0, board, res, n,leftRow,upperLDiagonal,lowerLDiagonal);

        return res;
    }
    
    static void solveOptimal(int col, char[][] board, List<List<String>> res, int n, int[] leftRow,
            int[]upperLDiagonal, int[]lowerLDiagonal){
    	
		if(col>=n){
		    res.add(convertToStringList(board));
		    return;
		}
		
		for(int row=0; row<n; row++){
		    if(leftRow[row]==0 && upperLDiagonal[row+col]==0 && lowerLDiagonal[n-1 + col-row]==0){
		        board[row][col] = 'Q';
		        leftRow[row]=1;
		        upperLDiagonal[row+col]=1;
		        lowerLDiagonal[n-1 + col-row]=1;
		        solveOptimal(col+1,board,res,n,leftRow,upperLDiagonal,lowerLDiagonal);
		        //backtrack
		        board[row][col]='.';
		        leftRow[row]=0;
		        upperLDiagonal[row+col]=0;
		        lowerLDiagonal[n-1 + col-row]=0;
		    }
		}
	}
    
    public static void main(String[] args) {
		System.out.println(solveNQueensBetter(4));
		System.out.println(solveNQueensOptimal(4));
	}
}
