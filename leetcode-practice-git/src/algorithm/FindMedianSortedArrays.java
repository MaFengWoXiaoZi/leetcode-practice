package algorithm;

/**
 * 寻找两个有序数组的中位数
 * @author Haoran
 *
 */
public class FindMedianSortedArrays {
	/**
	 * 时间复杂度O(log(min(m, n)))
	 * 空间复杂度O(n)
	 * @param nums1
	 * @param nums2
	 * @return
	 * 1 2|
	 * 3|4 5 6 7 
	 * 
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		if (nums1.length > nums2.length) {
        	return findMedianSortedArrays(nums2, nums1);
        }
		
        int len = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;
        double res = 0.0;
        
        while (cut1 <= nums1.length) {
        	cut1 = (cutR - cutL) / 2 + cutL;
        	cut2 = len / 2 - cut1;
        	double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
        	double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
        	double R1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];
        	double R2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];
        	
        	if (L1 > R2) {
        		cutR = cut1 - 1;
        	} else if (L2 > R1) {
        		cutL = cut1 + 1;
        	} else {
        		if (len % 2 == 0) {
        			L1 = L1 >= L2 ? L1 : L2;
        			R1 = R1 <= R2 ? R1 : R2;
        			res = (L1 + R1) / 2;
        			
        			return res;
        			
        		} else {
        			R1 = R1 <= R2 ? R1 : R2;
        			res = R1;
        			
        			return res;
        		}
        	}
        }
        
        return res;
        
    }
	
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
	       int m = nums1.length;
	       int n = nums2.length;
	       
	       int left = (m + n + 1) / 2;
	       int right = (m + n + 2) / 2;
	       return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
	    }
	    //i: nums1的起始位置 j: nums2的起始位置
	    public int findKth(int[] nums1, int i, int[] nums2, int j, int k){
	        if (i >= nums1.length) return nums2[j + k - 1]; // nums1为空数组时
	        if (j >= nums2.length) return nums1[i + k - 1]; // nums2为空数组时
	        
	        if (k == 1) {
	        	return Math.min(nums1[i], nums2[j]);
	        }
	        
	        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
	        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
	        if (midVal1 < midVal2) {
	        	return findKth(nums1, i + k / 2, nums2, j, k - k/2);
	        } else {
	        	return findKth(nums1, i, nums2, j + k / 2, k - k/2);
	        }
	        
	    }
}
