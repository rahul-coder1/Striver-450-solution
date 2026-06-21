package arrayBasic;

public class MissingNumber {
	//TC - O(nlogn) - brute force
    // public int missingNumber(int[] nums) {
    //     Arrays.sort(nums);
    //     int idx=-1;
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]!=i){
    //             idx=i;
    //             break; 
    //             //1st found index will be wrong
    //         }
    //     }
    //     if(idx==-1)
    //         idx = nums.length; 
    //         //or last index   
    //     return idx; 
    //              //since array is sorted
    // }

	//TC - O(N)
     public int missingNumber1(int[] nums) {
        int len = nums.length;
        int sumOfAllRange = len*(len+1)/2;
        int sumOfEle=0;
        for(int i:nums){
            sumOfEle+=i;
        }

        return sumOfAllRange-sumOfEle;
    }
     
   //TC - O(N), in case of above approach int overflow might happen
     public int missingNumber(int[] nums) {
         int xor1=0,xor2=0;
         for(int i=0;i<nums.length;i++){
             xor2=xor2^nums[i];
             xor1=xor1^(i+1);
         }

         return xor1^xor2;
     }
     
     public static void main(String[] args) {
		
	}
}














