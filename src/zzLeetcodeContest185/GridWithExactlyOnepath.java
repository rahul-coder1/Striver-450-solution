package zzLeetcodeContest185;

import java.util.Arrays;

public class GridWithExactlyOnepath {
	public static String[] createGrid(int m, int n) {
        char[][] mat = new char[m][n];
        String[] res= new String[m];
        for(int i=0;i<m;i++){
            Arrays.fill(mat[i],'#');
        }
        for(int i=0;i<m;i++){
            mat[i][0]='.';
        }
        for(int i=1;i<n;i++){
            mat[m-1][i]='.';
        }

        for(int i=0;i<m;i++){
           res[i] = new String(mat[i]);
        }

        return res;
    }
	
	public static void main(String[] args) {
		int m=2, n=3;
		String[] res = createGrid(m,n);
		for(String i: res) {
			System.out.printf("%s",i);
		}
	}
}
