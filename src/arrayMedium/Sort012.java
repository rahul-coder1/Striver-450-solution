package arrayMedium;

public class Sort012 {
	//TC O(2N) - better Solution
    // public void sortColors(int[] nums) {
    //     int s0=0,s1=0,s2=0;
    //     for(int i:nums){
    //         if(i==0) s0++;
    //         else if(i==1) s1++;
    //         else s2++;
    //     }
    //     for(int i=0;i<nums.length;i++){
    //         if(s0>0){
    //             nums[i]=0;s0--;
    //         }else if(s1>0){
    //             nums[i]=1;s1--;
    //         }else if(s2>0){
    //             nums[i]=2;s2--;
    //         }
    //     }
    // }

    static void swap(int[] nums, int i,int j){
        int temp=nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //TC - O(N) - Optimal Solution 
    public void sortColors(int[] nums) {
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==1){
               mid++;
            }
            else if(nums[mid]==0){
                swap(nums, low, mid);
                mid++;low++;
            }
            else if(nums[mid]==2){
                swap(nums, mid, high);
                high--;
            }
        }
    }
}















