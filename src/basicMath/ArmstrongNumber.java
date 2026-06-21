package basicMath;

public class ArmstrongNumber {
	
	public static boolean isArmstrong(int x) {
		int orgNum = x; 
		int sum=0;
		int digitsForPower = String.valueOf(x).length();
		while(x>0) {
			int digit = x%10;
			sum+= Math.pow(digit, digitsForPower);
			x/=10;
		}
		
		return orgNum == sum;
	}
	
	public static void main(String[] arguments) {
		System.out.println("9474:"+ArmstrongNumber.isArmstrong(9474));
		System.out.println("153:"+ArmstrongNumber.isArmstrong(153));
		System.out.println("548834:"+ArmstrongNumber.isArmstrong(548834));
	}
}
