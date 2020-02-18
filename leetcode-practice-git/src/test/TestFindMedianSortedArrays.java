package test;

import algorithm.FindMedianSortedArrays;

public class TestFindMedianSortedArrays {

	public static void main(String[] args) {
		FindMedianSortedArrays solution = new FindMedianSortedArrays();
		int[] nums1 = {5};
		int[] nums2 = {1, 2};
		
		double res = solution.findMedianSortedArrays(nums1, nums2);
		
		System.out.println(res);
		
	}

}
