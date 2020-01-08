/*
 * @Description:
 * 
 * @Date: 2020-01-08 21:27:07
 * 
 * @Author: duchangchun
 */
/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
 * 
 * 输入: "cbbd" 输出: "bb"
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String res = s.substring(0, 1);

        int maxLen = 1;
        for (int i = 1; i < s.length(); i++) {
            int low = i - 1;
            int high = i + 1;

            while (low > 0 && s.charAt(low) == s.charAt(i)) {
                low--;
            }

            if (low < 0 || s.charAt(low) != s.charAt(i)) {
                low++;
            }

            while (high < s.length() && s.charAt(high) == s.charAt(i)) {
                high++;
            }

            if (high >= s.length() || s.charAt(high) != s.charAt(i)) {
                high--;
            }

            while (low > 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }

            if (low < 0 || high >= s.length() || s.charAt(low) != s.charAt(high)) {
                low++;
                high--;
            }

            if (high - low + 1 > maxLen) {
                maxLen = high - low + 1;
                res = s.substring(low, high + 1);
            }
        }
        return res;
    }
}
