package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ���ظ�����Ӵ�
 * ʱ�临�Ӷ�: O(n)
 * �ռ临�Ӷ�: O(n)
 * @author Haoran
 *
 */
public class LengthOfLongestSubstring {
	/**
	 * 
	 * �㷨һ˼��: ʹ��һ��HashMap�洢����, key��value�ֱ�Ϊ�ַ����ж�Ӧ���ַ������ǵ��±�,
	 * j��ʾÿ�β��ظ��ַ��Ӵ�����ʼλ��,
	 * ���HashMap���Ѿ������˵�ǰ���ַ�, ����䵱ǰ�Ѿ����ֵ��ַ��±��ټ�1,
	 * ��Ϊ���ܵĲ��ظ��ַ�������ʼλ��,
	 * �����ǵ��������±��С�ڵ�ǰj��ֵ, ����abba, �������ڶ���aʱ, j = 1, ����ǰj�Ѿ�Ϊ2
	 * ����Ӧ��ȥ�����е����ֵ,
	 * �ٽ���ǰ���������ַ��������±�ŵ�HashMap��, �Ƚ����е���Ӵ��͵�ǰ������Ӵ��ĸ�����
	 * @param s
	 * @return 
	 */
	public int lengthOfLongestSubstring(String s) {
	
		int res = 0;
		
		if (s == null || s.length() == 0) return res;
		
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i))+1);
			}
			map.put(s.charAt(i), i);
			res = Math.max(res, i - j + 1);
		}
		
		return res;
	}
	
	/**
	 * �㷨��˼��: ʹ��һ��HashSet�洢����, keyΪ������ÿ���ַ�,
	 * �жϼ������Ƿ������ǰ�ַ�, ������,���Ƚ������г��ֵĵ�ǰ�ַ�����֮ǰ�������ַ���ɾȥ,
	 * ����i--, �Ա���forѭ����i++�����,�Ӷ��ñ����ַ�����ִ�в���,
	 * ֱ�����ַ����ټ�����,�ٽ�����ӵ�������ȥ
	 * jͬ���Ǽ�¼��Ӵ�����ʼλ��,��ɾ���������ַ�ʱʹ��
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring2(String s) {
		//abba
		int res = 0;
		
		if (s == null || s.length() == 0) return res;
		
		Set<Character> set = new HashSet<>();
		
		for (int i = 0, j = 0; i < s.length();i++) {
			if (set.contains(s.charAt(i))) {
				set.remove(s.charAt(j++));
				i--;
			} else {
				set.add(s.charAt(i));
				res = Math.max(res, set.size());
			}
		}
		
		return res;
	}
}
