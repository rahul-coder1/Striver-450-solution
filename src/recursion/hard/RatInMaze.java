package recursion.hard;
import java.util.*;

public class RatInMaze {
	//TC - o(4*3^(n.m-1)) ~ o(3^(n.m))+o(k.n.m where k total valid paths) = o(3^(n.m))
    //SC - res- o(k.n.m) + visited O(n.m) + stack depth-O(n.m) + op -O(NM) = O(k.n.m)
    public static ArrayList < String > ratInMaze(int[][] arr, int n) {
        int[][] visited = new int[n][n];
        ArrayList<String> res = new ArrayList<>();
        StringBuilder op = new StringBuilder();
        
        visited[0][0]=1;
        if(arr[0][0]==1) generate(0,0,n,arr,visited,op,res);
        
        //lexicographical order is D->L->R->U
        
        return res;
    }
    static void generate(int row, int col,int n,int[][] maze,int[][] visited,StringBuilder op, ArrayList<String> res){
        if(row==n-1 && col==n-1){
            res.add(new String(op));
            return;
        }
        
        //DOWN
        if(row+1<n && visited[row+1][col]!=1 && maze[row+1][col]==1){
            visited[row+1][col]=1;
            op.append("D");
            generate(row+1,col,n,maze,visited,op,res);
            
            //backtrack
            op.deleteCharAt(op.length()-1);
            visited[row+1][col]=0;
        }
        //LEFT
        if(col-1>=0 && visited[row][col-1]!=1 && maze[row][col-1]==1){
            visited[row][col-1]=1;
            op.append("L");
            generate(row,col-1,n,maze,visited,op,res);
            
            //backtrack
            op.deleteCharAt(op.length()-1);
            visited[row][col-1]=0;
        }
        //RIGHT
        if(col+1<n && visited[row][col+1]!=1 && maze[row][col+1]==1){
            visited[row][col+1]=1;
            op.append("R");
            generate(row,col+1,n,maze,visited,op,res);
            
            //backtrack
            op.deleteCharAt(op.length()-1);
            visited[row][col+1]=0;
        }
        //UP
        if(row-1>=0 && visited[row-1][col]!=1 && maze[row-1][col]==1){
            visited[row-1][col]=1;
            op.append("U");
            generate(row-1,col,n,maze,visited,op,res);
            
            //backtrack
            op.deleteCharAt(op.length()-1);
            visited[row-1][col]=0;
        }
    }
    
    public static void main(String[] args) {
    	int[][] maze = {
    		    {1, 0, 0, 0},
    		    {1, 1, 0, 1},
    		    {1, 1, 0, 0},
    		    {0, 1, 1, 1}
    		};
    	System.out.println(ratInMaze(maze,maze.length));
	}
}
















