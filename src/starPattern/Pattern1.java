package starPattern;


public class Pattern1 {
	static class Pattern{
		/*
		 *      *****
		 *      *****
		 *      *****
		 *      *****
		 * 
		 * */
		static int val=5;
		
		public void shape1(int n) {
			StringBuilder a= new StringBuilder();
			for(int i=0;i<n;i++) {
				a.append("*");
			}
			for(int i=0;i<n;i++) {
				System.out.println(a);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Pattern p1 = new Pattern();
		p1.shape1(5);
		
	}
	
}
