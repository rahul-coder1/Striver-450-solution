package arrayBasic;

import java.util.ArrayList;
import java.util.Scanner;

public class UnionOfArray {
	static int[] unionArray(int[] nums1, int[] nums2) {
        int i=0,j=0, len1 = nums1.length, len2 = nums2.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(i<len1 && j<len2){
            if(nums1[i]<=nums2[j]){
            	if(list.size()==0 || list.get(list.size() -1)!=nums1[i])
            		list.add(nums1[i]); i++;
            }else{
            	if(list.size()==0 || list.get(list.size()-1)!=nums2[j])
            		list.add(nums2[j]); j++;
            }
        }
        while(i<len1){
        	if(list.size()==0 || list.get(list.size() -1)!=nums1[i])
        		list.add(nums1[i]); i++;
        }
        while(j<len2){
        	if(list.size()==0 || list.get(list.size() -1)!=nums2[j])
        		list.add(nums2[j]); j++;
        }
        int nums3[] = new int[list.size()];
        int k=0;
        for(Integer l:list){
            nums3[k]=l;k++;
        }

        return nums3;
    }
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a[] = {3, 4, 6, 7, 9, 9};
		int b[] = {1, 5, 7, 8, 8};
		
		int[] res=unionArray(a,b);
		for(int i:res) {
			System.out.print(i+" ");
		}
	}
}







