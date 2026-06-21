package arrayMedium;

public class RearrangeElementBySign {
	//TC- O(N) SC-O(N)
	static int[] rearrangeArray(int[] nums) { //[3,1,-2,-5,2,-4]
		int ans[] = new int[nums.length];
		int pos=0,neg=1;
		for(int i:nums) {
			if(i>0) {
				ans[pos]=i;pos+=2;
			}else {
				ans[neg]=i;neg+=2;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int [] arr = {3,1,-2,-5,2,-4};
		int [] res = rearrangeArray(arr);
		for(int i:res) {
			System.out.print(i+" ");
		}
	}
}
