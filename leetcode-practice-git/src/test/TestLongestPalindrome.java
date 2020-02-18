package test;

import algorithm.LongestPalindrome;

public class TestLongestPalindrome {

	public static void main(String[] args) {
		LongestPalindrome solution = new LongestPalindrome();
		String s = "babad";
		
		System.out.println(solution.longestPalindrome(s));
	}

}
