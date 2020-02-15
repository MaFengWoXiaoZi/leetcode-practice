package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * 使用一个HashMap, 对nums数组遍历一遍, 通过key和value分别记录元素值和下标值,
 * 然后首先判断target与当前遍历的数组元素的差是否已经包含在key中了, 
 * 若已经包含, 则包含的值和当前的值相加就等于target, 返回它们的下标即可
 * @author Haoran
 *
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = new int[] {-1, -1};
		
		if (nums == null || nums.length == 0) {
			return res;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = map.get(target - nums[i]);
				res[1] = i;
				return res;
			}
			map.put(nums[i], i);
		}
		
		return res;
	}
}
