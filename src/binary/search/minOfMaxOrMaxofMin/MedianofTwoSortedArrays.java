package binary.search.minOfMaxOrMaxofMin;

import java.util.ArrayList;
import java.util.List;

public class MedianofTwoSortedArrays {
	//Brute force
	//TC - O(n1+n2), SC - O(n1+n2)
	public static double bruteFindMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1=nums1.length, n2=nums2.length;
		List<Integer> arr = new ArrayList<>();
		int i=0,j=0;
		while(i<n1 && j<n2) {
			if(nums1[i]<nums2[j]) arr.add(nums1[i++]);
			else arr.add(nums2[j++]);
		}
		
		while(i<n1) arr.add(nums1[i++]);
		while(j<n2) arr.add(nums2[j++]);
		
		int N = arr.size();
		if(N%2==1) return (double) arr.get(N/2);
		
		return (double)(arr.get(N/2)+arr.get(N/2-1))/2.0;
	}
	
	//TC - O(n1+n2)
	public static double betterFindMedianSortedArrays(int[] a, int[] b) {
		int n1=a.length, n2=b.length;
		int i=0,j=0,cnt=0;
		int idx1e=-1,idx2e=-1;
		int n = n1+n2;
		int idx2=n/2, idx1=n/2-1; 
		while(i<n1 && j<n2) {
			if(a[i]<b[j]) {
				if(cnt==idx1) idx1e=a[i];
				if(cnt==idx2) idx2e=a[i];
				cnt+=1;i+=1;
			}else {
				if(cnt==idx1) idx1e=b[j];
				if(cnt==idx2) idx2e=b[j];
				cnt+=1;j+=1;
			}
		}
		
		while(i<n1) {
			if(cnt==idx1) idx1e=a[i];
			if(cnt==idx2) idx2e=a[i];
			cnt+=1;i+=1;
		}
		while(j<n2) {
			if(cnt==idx1) idx1e=b[j];
			if(cnt==idx2) idx2e=b[j];
			cnt+=1;j+=1;
		}
		
		if(n%2==1) return (double)idx2e;
		
		return (double)(idx2e+idx1e)/2.0;
	}
	
	//TC - O(min(logn1,logn2))
	public static double optimalFindMedianSortedArrays(int[] a, int[] b) {
		int n1=a.length, n2=b.length;
		if(n1>n2) return optimalFindMedianSortedArrays(b,a);
		int low=0, high=n1;
		int left=(n1+n2+1)/2;
		int n=n1+n2;
		while(low<=high) {
			int mid1=low+(high-low)/2;
			int mid2=left-mid1;
			int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
			int r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;
			if(mid1<n1) r1=a[mid1];
			if(mid2<n2) r2=b[mid2];
			if(mid1-1>=0) l1=a[mid1-1];
			if(mid2-1>=0) l2=b[mid2-1];
			
			if(l1<=r2 && l2<=r1) {
				if(n%2==1) return Math.max(l1, l2);
				else return (double)(Math.max(l1, l2)+Math.min(r1, r2))/2.0;
			}
			else if(l1>r2) high=mid1-1;
			else low=mid1+1;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[]nums1 = {1,3}, nums2 = {2};
//		int[]nums1 = {1,2}, nums2 = {3,4};
		System.out.println(optimalFindMedianSortedArrays(nums1,nums2));
	}
}
