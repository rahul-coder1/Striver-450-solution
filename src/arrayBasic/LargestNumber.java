package arrayBasic;

public class LargestNumber {
	 public static int largestElement(int[] nums) {
	        if(nums==null || nums.length==0){
	            throw new IllegalArgumentException("Array is empty");
	        }
	        int largest = nums[0];
	        for(int i : nums){
	            if(i>largest) largest=i;
	        }

	        return largest;
	    }
	 public static void main(String[] arguments) {
		 try {
			 System.out.println(LargestNumber.largestElement(new int[]{3, 3, 0, 99, -40}));
			 System.out.println(LargestNumber.largestElement(new int[]{}));
			 System.out.println(LargestNumber.largestElement(new int[]{3, 3, 0, 99, -40}));
		 } 
		 catch (Exception e) {
			 System.out.println(e);
		 }
	 }
}
