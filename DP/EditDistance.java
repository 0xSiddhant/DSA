/*
 * 	convert one string into another string in minimum no. of steps..
 * Only == Addition Deletion and Removal operation are available
 * 
 */
public class EditDistance {

	public static void main(String[] args) {
		System.out.println(editDistance("agbg", "acgb"));
	}
	
	public static int editDistance(String s1, String s2) {
		
		if(s1.length() == 0)
			return s2.length();
		if(s2.length() == 0)
			return s1.length();
		
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int ans = 0;
		if(s1.charAt(0) == s2.charAt(0))
			ans = editDistance(ros1, ros2);
		else{
			int f1 = 1 + editDistance(ros1, ros2);
			int f2 = 1 + editDistance(ros1, s2);
			int f3 = 1 + editDistance(s1, ros2);
			ans = Math.min(f1, Math.min(f2, f3));
		}
		return ans;
	}

}
