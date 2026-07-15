package strings.basic;

public class LargestOddNumberInString {
	 //TC- O(N)
    public static String largestOddNumber(String num) {
    	int endIdx=num.length()-1;
    	while(endIdx>=0 && num.charAt(endIdx)%2==0) endIdx-=1;
    	return endIdx==-1?"":num.substring(0,endIdx+1);
    }
	public static void main(String[] args) {
		String[] testCases = {"52","4206","35427"};
		for (String num : testCases) {
			System.out.println("Input : " + num);
            System.out.println("Output: " + largestOddNumber(num));
            System.out.println();
		}
	}
}
