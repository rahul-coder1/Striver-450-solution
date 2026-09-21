package recursion.hard;

public class WordSearch {
	//record Pair(int row, int col){}
    //TC - o(row.col.4.3^n-1, n is word length), SC - o(n - set) + o(n - depth)
    public static boolean exist(char[][] board, String word) {
    	int rows = board.length;
    	int cols = board[0].length;
    	
    	for(int r = 0; r<rows;r++) {
    		for(int c=0;c<cols;c++) {
    			if(dfs(r,c,0,board,word)) return true;
    		}
    	}
    	
    	return false;
    }
    
    public static boolean dfs(int r, int c , int idx, char[][] board, String word) {
    	if(idx>=word.length()) return true;
    	if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!=word.charAt(idx)
    			|| board[r][c]=='#') {
    		return false;
    	}
    	
    	char temp = board[r][c];
    	board[r][c] = '#';
    	
    	boolean res = dfs(r+1,c,idx+1,board,word) || dfs(r-1,c,idx+1,board,word)
    				|| dfs(r,c+1,idx+1,board,word) || dfs(r,c-1,idx+1,board,word);
    	
    	//backtrack
    	board[r][c] = temp;
    	
    	return res;
    }
    
    
    public static void main(String[] args) {
    	char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//		String word = "ABCCED";
		String word = "ABCCEF";
		
		System.out.println(exist(board,word));
	}
}

















