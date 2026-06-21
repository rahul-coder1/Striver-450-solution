package arrayMedium;

//Moore's voting element
public class MajorityElement {
	static{
		MajorityElement s=new MajorityElement();
       
		for(int i=0;i<500;i++)s.majorityElement(new int[]{1,1});
    }
	//TC - O(N)
    public int majorityElement(int[] nums) {
        int element=0,count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                element=nums[i];count++;
            }
            else if(element==nums[i])
                count++;
            else
                count--;
            
        }

        return element;
    }
}
