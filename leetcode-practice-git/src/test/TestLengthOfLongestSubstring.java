package test;

import algorithm.LengthOfLongestSubstring;

public class TestLengthOfLongestSubstring {

	public static void main(String[] args) {
		String s = "abba";
		LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
		int res = solution.lengthOfLongestSubstring2(s);
		System.out.println(res);
	}
}
