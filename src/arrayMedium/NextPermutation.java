package arrayMedium;

//TC - O(3N)
public class NextPermutation {
	static void nextPermutation(int[] nums) {
		int idx=-1;
		//{2,3,5,4,1,0,0} break point 3|5 
		for(int i= nums.length-2;i>=0;i--) {
			if(nums[i]<nums[i+1]) {
				idx=i;break;
			}
		}
		
		if(idx!=-1) {
			for(int i=nums.length-1;i>idx;i--) {
				if(nums[i]>nums[idx]) {
					swap(nums, i, idx);break;
				}
			}
		}	
		reverse(nums,idx+1, nums.length-1);
	}
	
	static void swap(int arr[], int i, int j) {
		int temp=arr[i];
		arr[i] = arr[j];
		arr[j]=temp;
	}
	
	static void reverse(int arr[], int i, int j) {
		while(i<j) {
			int temp=arr[i];
			arr[i] = arr[j];
			arr[j]=temp;
			i++;j--;
		}
	}
	
	public static void main(String[] args) {
		int arr[]= {1,1,5};
		for(int i:arr) {
			System.out.print(i+" ");
		}
		nextPermutation(arr);
		System.out.println();
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
}














