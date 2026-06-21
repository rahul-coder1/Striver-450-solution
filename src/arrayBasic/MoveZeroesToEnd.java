package arrayBasic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class MoveZeroesToEnd {
	public void moveZeroes(int[] nums) {
        int len = nums.length; 
        int idxNon0=0;
        for(int i=0;i<len;i++){
            if(nums[i]==0)
                continue;
            else{
                nums[idxNon0] = nums[i];
                idxNon0++;
            }
        }

        for(int i=idxNon0;i<len;i++){
            nums[i]=0;
        }
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Iterator<Integer> it = list.iterator();
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		list.add(5);
		list.add(6);
		System.out.println("size:"+list.size());
		
	}
}
