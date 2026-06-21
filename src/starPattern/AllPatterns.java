package starPattern;

import java.util.Arrays;

import starPattern.Pattern2.Pattern;

public class AllPatterns {
	static class Pattern{
		/* 3
		 *      1
		 *      12
		 *      123
		 *      1234
		 *      12345
		 * 
		 * */
		
		public void shape1(int n) {
			StringBuilder line= new StringBuilder();
			for(int i=1;i<=n;i++) {
				line.append(i);
				System.out.println(line);
			}
			
		}
		/*
		 *  1
		 *  22
		 *  333
		 *  4444
		 *  55555
		 *
		 */
		 
		public void shape2(int n) {
	
			for(int i=1;i<=n;i++) {
				for(int j=1; j<=i;j++) {
					System.out.print(i);		
				}
				System.out.println();
			}	
		}
		
		public void shape2_2(int n) {
			
			for(int i=1;i<=n;i++) {
				char[] line = new char[i];
				Arrays.fill(line, (char)('0'+i));
				System.out.println(line);
			}	
		}
		/*
		 *  12345
		 *  1234
		 *  123
		 *  12
		 *  1
		 *
		 */
		public void shape3(int n) {
			StringBuilder line = new StringBuilder();
			for(int i=1;i<=n;i++) {
				line.append(i); //12345
			}	
			for(int i=0;i<n;i++) {
				System.out.println(line.substring(0,n-i));
//				System.out.println(line.charAt(i));
			}	
		}
		/*
		 * 			*
		 * 		   ***
		 * 		  *****
		 * 		 *******
		 * 		*********
		 * 
		 * */
		public void shape4(int n) {
			for(int i=1;i<=n;i++) {
				for(int j=0; j<n-i;j++) {
					System.out.print(" ");
				}
				for(int k=0; k<(2*i-1);k++) {
					System.out.print("*");
				}
				System.out.println();
			}	
			
		}
		/*
		 * 			*********
					 *******
					  *****
					   ***
					    *
		 * 
		 * */
		public void shape5(int n) {
			StringBuilder line = new StringBuilder();
			for(int i=n;i>0;i--) {
				for(int j=0; j<n-i;j++) {
					System.out.print(" ");
				}
				for(int k=0; k<(2*i-1);k++) {
					System.out.print("*");
				}
				System.out.println();
			}	
			
		}
		/*		*
		 * 		**
		 * 		***
		 * 		****
		 * 		*****
		 *		****
		 *		***
		 *		**
		 *		*
		 *
		 * (2*n-1) */
		public void shape6(int n) {
			for(int i=1;i<=2*n-1;i++) {
				int stars =i;
				if(i>n) stars=2*n-i;
				for(int j=1; j<=stars;j++) {
					System.out.print("*");
				}
				System.out.println();
			}	
			
		}
		/*	1
		 * 	0 1
		 *  1 0 1
		 *  0 1 0 1
		 *  1 0 1 0 1	
		 *
		 *  */
		public void shape7(int n) {
			int start=1;
			for(int i=1;i<=n;i++) {
				if(i%2==1) start=1;
				else start=0;
				
				for(int j=1;j<=i;j++) {
					System.out.print(start);
					start=1-start;
				}
				System.out.println();
			}
		}
		/*	1	   1
		 * 	12	  21
		 * 	123	 321
		 * 	12344321
		 *
		 *  */
		public void shape8(int n) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=i;j++) {
					System.out.print(j);
				}
				for(int j=0;j<2*n-2*i;j++) {
					System.out.print(" ");
				}
				for(int j=i;j>=1;j--) {
					System.out.print(j);
				}
				System.out.println();
			}
		}
		/*	1
		 * 	2 3
		 *  4 5 6
		 *  7 8 9 10
		 *  11 12 13 14 15
		 *  
		 *
		 *  */
		public void shape9(int n) {
			int count=1;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=i;j++) {
					System.out.print(count);
					System.out.print(" ");
					count+=1;
				}
				System.out.println();
			}
		}
		/*	A
		 *  A B
		 *  A B C
		 *  A B C D
		 *  A B C D E
		 *
		 *  */
		public void shape10(int n) {
			for(int i=0;i<n;i++) {
				for(char ch='A'; ch<=('A'+i);ch++) {
					System.out.print(ch);
				}
				System.out.println();
			}
		}
		/*
		 *  A B C D E
		 *  A B C D 
		 *  A B C 
		 *  A B 
		 *  A 
		 *
		 *  */
		public void shape11(int n) {
			for(int i=n-1;i>=0;i--) {
				for(char ch='A'; ch<=('A'+i);ch++) {
					System.out.print(ch);
				}
				System.out.println();
			}
		}
		/*
		 *  A
		 *  BB
		 *  CCC
		 *  DDDD
		 *  EEEEE
		 *
		 *  */
		public void shape12(int n) {
			char ch='A';
			for(int i=0;i<n;i++) {
				for(int j=0;j<=i;j++) {
					System.out.print(ch);
				}
				ch+=1;
				System.out.println();
			}
		}
		/*
		 *  	A
		 *     ABA
		 *    ABCBA
		 *   ABCDCBA
		 *
		 *  ((2*n+1)/2+)1*/
		public void shape13(int n) {
			
			for(int i=0;i<n;i++) {
				char ch='A';
				int breakPoint=(2*i+1)/2;
				for(int sp=0;sp<n-i-1;sp++)
					System.out.print(" ");
				for(int j=1;j<=2*i+1;j++) {
					System.out.print(ch);
					if(j<breakPoint+1) ch++;
					else ch--;
				}
				System.out.println();
			}
		}
		/*
		 *  	E
		 *  	DE
		 *  	CDE
		 *  	BCDE
		 *  	ABCDE
		 *
		 *  */
		public void shape14(int n) {
			
			for(int i=1;i<=n;i++) {
				char ch='A';
				for(int j=n-i;j<n;j++) {
					System.out.print((char)(ch+j));
				}
				System.out.println();
			}
		}
		
		/*
		 *  	**********
		 *  	****  ****
		 *  	***    ***
		 *  	**      **
		 *  	*        *
		 *  	*        *
		 *  	**      **
		 *  	***    ***
		 *  	****  ****
		 *  	**********
		 *
		 *  */
		public void shape15(int n) {
			int sp=0;
			for(int i=0;i<n;i++) {
				//stars
				for(int j=1;j<=n-i;j++) {
					System.out.print("*");
				}
				//spaces
				for(int j=0;j<sp;j++) {
					System.out.print(" ");
				}
				//stars
				for(int j=1;j<=n-i;j++) {
					System.out.print("*");
				}
				sp+=2;
				System.out.println();
			}
			for(int i=0;i<n;i++) {
				sp-=2;
				//stars
				for(int j=1;j<=i+1;j++) {
					System.out.print("*");
				}
				//spaces
				for(int j=0;j<sp;j++) {
					System.out.print(" ");
				}
				//stars
				for(int j=1;j<=i+1;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
			
		}
		
		/*
		 *  	*		 *
		 *  	**		**
		 *  	***    ***
		 *  	****  ****
		 *  	**********
		 *  	****  ****
		 *  	***    ***
		 *  	**      **
		 *  	*		 *
		 *
		 *  */
		public void shape16(int n) {
			
			for(int i=1;i<=n/2;i++) {
				//stars
				for(int j=1;j<=i;j++) {
					System.out.print("*");
				}
				//space
				for(int j=1;j<=n-2*i;j++) {
					System.out.print(" ");
				}
				//stars
				for(int j=1;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for(int i=1;i<=n/2-1;i++) {
				//stars
				for(int j=1;j<=n/2-i;j++) {
					System.out.print("*");
				}
				//space
				for(int j=1;j<=2*i;j++) {
					System.out.print(" ");
				}
				//stars
				for(int j=1;j<=n/2-i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		
		/*
		 *   * * * *
		 *   *     *
		 *   *     *
		 *   * * * *
		 * 
		 * */
		public void shape17(int n) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i==0 || j==0||i==n-1 || j==n-1) {
						System.out.print("*");
					}else
						System.out.print(" ");
					
				}
				System.out.println();
			}
		}
		
		/*
		 *   4444444
		 *   4333334
		 *   4322234
		 *   4321234
		 *   4322234
		 *   4333334
		 *   4444444
		 * 
		 * */
		public void shape18(int n) {
			int sqrMatrixSideLen = 2*n-1;
			for(int i=0;i<sqrMatrixSideLen;i++) {
				for(int j=0;j<sqrMatrixSideLen;j++) {
					int top=i;
					int bottom=((2*n-1)-1)-i;
					int left=j;
					int right=((2*n-1)-1)-j;
					int min=(n-Math.min(Math.min(top,bottom),Math.min(left, right)));
					System.out.print(min);
				}
				System.out.println();
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Pattern p1 = new Pattern();
		p1.shape18(4);
		
		
	}
}
