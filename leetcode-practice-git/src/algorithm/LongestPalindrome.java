package algorithm;

public class LongestPalindrome {
	/**
 	  * 最长回文子串
 	  * 时间复杂度: O(n^2)
 	  * 空间复杂度: O(n^2)
 	  * @author haoran
 	 */
	public String longestPalindrome1(String s) {
		if (s == null || s.length() == 0) return s;
		String res = "";
		boolean[][] dp = new boolean[s.length()][s.length()];
		int max = 0;
		for (int j = 0; j < s.length(); j++) {
			for (int i = 0; i <= j; i++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i+1][j-1]);
				if (dp[i][j]) {
					if (j - i + 1 > max) {
						max = j - i + 1;
						res = s.substring(i, j + 1);
					}
				}
			}
		}
		return res; 
	}
	
	
	
	String res = "";
	/**
 	  * 最长回文子串
 	  * 时间复杂度: O(n^2)
 	  * 空间复杂度: O(1)
 	  * @author haoran
 	 */
	public String longestPalindrome2(String s) {
	    	 if (s == null || s.length() == 0) return s;
	    	 for (int i = 0; i < s.length(); i++) {
	    		 // 如果是奇数个数
	    		 helper(s, i, i);
	    		 // 如果是偶数个数
	    		 helper(s, i, i+1);
	    	 }
	    	 
	    	 return res;
	     }
	     
     public void helper(String s, int left, int right) {
	 while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
		 left--;
		 right++;
	 }
	 String cur = s.substring(left + 1, right);
	 if (cur.length() > res.length()) {
		 res = cur;
	 }
     }
}
