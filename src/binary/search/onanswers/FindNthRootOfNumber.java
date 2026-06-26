package binary.search.onanswers;

//TC = logM*logN
public class FindNthRootOfNumber {
	//return 1 for mid==target, 0 for mid<target, 2 for mid>target
    public static int power(int mid, int pw, int target){
        long ans=1;
        for(int i=1; i<=pw;i++){
            ans=ans*mid;
            if(ans>target) return 2;
        }
        if(ans==target) return 1;
        return 0;
    }
    public static int NthRoot(int N, int M) {
        int low=1,high=M,mid=0;
        while(low<=high){
            mid=low+(high-low)/2;
            int midN=power(mid,N,M);
            if(midN==1) return mid;
            else if(midN==0) low=mid+1;
            else high=mid-1;
        }

        return  -1;
    }
    
    public static void main(String[] args) {
		int  N = 3, M = 27;
		System.out.println(NthRoot(N,M));
	}
}







