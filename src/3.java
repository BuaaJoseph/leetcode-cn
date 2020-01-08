/*
 * @Description:
 * 
 * @Date: 2020-01-08 21:23:21
 * 
 * @Author: duchangchun
 */
/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2:
 * 
 * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。 示例 3:
 * 
 * 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。   请注意，你的答案必须是 子串
 * 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastPos = new HashMap<>();
        Integer[] posLength = new Integer[s.length()];
        for (int i = 0; i <s.length(); i++) {
            Character c = s.charAt(i);
            Integer lastPosition = lastPos.get(c);
            // 之前未出现过
            if (lastPosition == null) {
                posLength[i] = i == 0 ? 1 : posLength[i - 1] + 1;
            } else {
                int length1 = i - lastPosition;
                int length2 = posLength[i - 1] + 1;
                posLength[i] = length1 <= length2 ? length1 : length2;
            }
            lastPos.put(c, i);
        }

        int res = 0;
        for (int j = 0; j <posLength.length; j++) {
            res = posLength[j] > res ? posLength[j] : res;
        }
        return res;
    }
}