package test;

import java.util.Arrays;

import algorithm.TwoSum;

public class testTwoSum {

	public static void main(String[] args) {
		TwoSum solution = new TwoSum();
		int[] nums = {2, 7, 11, 5, 3, 101};
		int target = 104;
		int[] res = solution.twoSum(nums, target);
		System.out.println(Arrays.toString(res));
	}

}
