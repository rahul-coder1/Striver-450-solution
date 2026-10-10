package recursion.hard;

import java.util.*;

public class MColoring {
	//TC - o(V.M^v + V+E - for adj list), SC - o(V-aux + V -[]colors + V+E -adj list)
    public static boolean graphColoring(int v, int[][] edges, int m) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e:edges){
            int t = e[0];
            int u = e[1];
            adj.get(u).add(t);
            adj.get(t).add(u);
        }
        
        int[] colors = new int[v];
        
        return solve(0,adj,colors,m,v);
    }
    
    public static  boolean solve(int vertex, List<List<Integer>> adj, int[] colors, int m, int v){
        if(vertex==v) return true;
        
        //for each color we check all vertex in sequential ascending wise
        for(int color=1;color<=m;color++){
            if(canColor(vertex, adj,color,colors)){
                //choose color
                colors[vertex] = color;
                //explore further with chosen color
                if(solve(vertex+1,adj,colors,m,v)){
                    return true;
                }
                //backtrack
                colors[vertex]=0;
            }
        }
        
        return false;
    }
    
    public static  boolean canColor(int vertex, List<List<Integer>> adj, int color,int[]colors){
        for(int neighbour:adj.get(vertex)){
            if(colors[neighbour]==color) return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
//    	 int v = 3;
//         int[][] edges = {
//             {0, 1},
//             {1, 2},
//             {0, 2}
//         };
//         int m = 3;
    	
    	int v = 4;

    	int[][] edges = {
    	    {0, 1},
    	    {1, 2},
    	    {2, 3},
    	    {3, 0}
    	};

    	int m = 2;

         boolean result = graphColoring(v, edges, m);

         System.out.println("Can the graph be colored? " + result);
	}
}
