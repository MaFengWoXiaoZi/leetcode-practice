package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * ʱ�临�Ӷ�O(n)
 * �ռ临�Ӷ�O(n)
 * ʹ��һ��HashMap, ��nums�������һ��, ͨ��key��value�ֱ��¼Ԫ��ֵ���±�ֵ,
 * Ȼ�������ж�target�뵱ǰ����������Ԫ�صĲ��Ƿ��Ѿ�������key����, 
 * ���Ѿ�����, �������ֵ�͵�ǰ��ֵ��Ӿ͵���target, �������ǵ��±꼴��
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
