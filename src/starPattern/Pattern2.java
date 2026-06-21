package starPattern;


public class Pattern2 {
	static class Pattern{
		/*
		 *      *
		 *      **
		 *      ***
		 *      ****
		 *      *****
		 * 
		 * */
		
		public void shape1(int n) {
			StringBuilder line= new StringBuilder();
			for(int i=0;i<n;i++) {
				line.append("*");
				System.out.println(line);
			}
			
		}
		public void shape1_1(int n) {
			char[] line = new char[5];
			for(int i=0;i<n;i++) {
				line[i]='*';
				System.out.println(new String(line,0,i+1));
			}
			
		}
	
		
	}

	
	public static void main(String[] args) {
		Pattern p1 = new Pattern();
		p1.shape1_1(5);
	}
	
}
