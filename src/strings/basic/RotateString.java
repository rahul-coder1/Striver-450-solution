package strings.basic;

public class RotateString {
	  //TC - o(n^2) as contains function will match every character
    public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        goal=goal+goal;
        if(goal.contains(s)) return true;
        return false;
    }
    public static void main(String[] args) {
		String s = "abcde", goal = "cdeab";
		System.out.println(rotateString(s, goal));
	}
}
