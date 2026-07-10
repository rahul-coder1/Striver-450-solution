package binary.search.minOfMaxOrMaxofMin;

public class kthElementOfTwoSortedArrays {
	//TC O(log(min(n,m))
    public static int kthElement(int a[], int b[], int k) {
        int n1=a.length,n2=b.length;
        if(n1>n2) return kthElement(b,a,k);
        int left=k; int n=n1+n2;
        int low=Math.max(k-n2,0), high=Math.min(k,n1);
        
        while(low<=high){
            int mid1=low+(high-low)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid1<n1) r1=a[mid1];
            if(mid2<n2) r2=b[mid2];
            if(mid1-1>=0) l1=a[mid1-1];
            if(mid2-1>=0) l2=b[mid2-1];
            
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2) high=mid1-1;
            else low=mid1+1;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
//    	int a[] = {2, 3, 6, 7, 9}, b[] = {1, 4, 8, 10}, k = 5;
    	int a[] = {1, 4, 8, 10, 12}, b[] = {5, 7, 11, 15, 17}, k = 6;
    	System.out.println(kthElement(a,b,k));
	}

}
