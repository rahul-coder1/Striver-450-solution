package basicMath;

import java.util.ArrayList;
import java.util.List;

public class printAllDivisors {
	
	public static void divisors(int n) {
		List<Integer> ls = new ArrayList<>();
		for(int i=1; i*i<=n; i++) {
			if(n%i==0) {
				ls.add(i);
				if(i != n/i) {
					 ls.add(n/i);
				}
			}
		}
		ls.sort(null);
		
		System.out.println("Divisors:"+ls);
	}
	
	public static void main(String[] args) {
		printAllDivisors.divisors(36);
	}
}
