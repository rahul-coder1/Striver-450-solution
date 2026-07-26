package string.medium;

public class SumOfBeautyOfAllSubstrings {
	//TC - o(26*n^2)
    public static int beautySum(String s) {
        int sum=0,n=s.length();
        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']+=1;
                int min=Integer.MAX_VALUE, max=0;
                for(int fq : freq){
                    if(fq==0) continue;
                    if(fq>max) max=fq;
                    if(fq<min) min=fq;
                }
                sum+=max-min;
            }
        }

        return sum;
    }
    
    public static void main(String[] args) {
		String[] str = {"aabcb","aabcbaa"};
		for(String s:str) {
			System.out.println(beautySum(s));
		}
	}
}
