package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复的最长子串
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * @author Haoran
 *
 */
public class LengthOfLongestSubstring {
	/**
	 * 
	 * 算法一思想: 使用一个HashMap存储数据, key和value分别为字符串中对应的字符和它们的下标,
	 * j表示每次不重复字符子串的起始位置,
	 * 如果HashMap中已经包含了当前的字符, 则对其当前已经出现的字符下标再加1,
	 * 作为可能的不重复字符串的起始位置,
	 * 但考虑到可能其下标会小于当前j的值, 比如abba, 遍历到第二个a时, j = 1, 而此前j已经为2
	 * 所以应当去二者中的最大值,
	 * 再将当前遍历到的字符和它的下标放到HashMap中, 比较已有的最长子串和当前计算的子串哪个更长
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
	 * 算法二思想: 使用一个HashSet存储数据, key为遍历的每个字符,
	 * 判断集合中是否包含当前字符, 若包含,则先将集合中出现的当前字符和它之前的所有字符先删去,
	 * 这里i--, 以便与for循环中i++相抵消,从而让本次字符会再执行操作,
	 * 直到该字符不再集合中,再将它添加到集合中去
	 * j同样是记录最长子串的起始位置,供删除集合中字符时使用
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
