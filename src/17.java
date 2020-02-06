
/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, List<String>> numberToCharacter = new HashMap<>();
        numberToCharacter.put('2', Arrays.asList("a", "b", "c"));
        numberToCharacter.put('3', Arrays.asList("d", "e", "f"));
        numberToCharacter.put('4', Arrays.asList("g", "h", "i"));
        numberToCharacter.put('5', Arrays.asList("j", "k", "l"));
        numberToCharacter.put('6', Arrays.asList("m", "n", "o"));
        numberToCharacter.put('7', Arrays.asList("p", "q", "r", "s"));
        numberToCharacter.put('8', Arrays.asList("t", "u", "v"));
        numberToCharacter.put('9', Arrays.asList("w", "x", "y", "z"));

        for (int i = 0; i < digits.length(); i++) {
            List<String> numCharacter = numberToCharacter.get(digits.charAt(i));
            List<String> tempRes = new ArrayList<>();
            if (result == null || result.size() == 0) {
                result = numCharacter;
                continue;
            }

            for (int j = 0; j < result.size(); j++) {
                for (int k = 0; k < numCharacter.size(); k++) {
                    tempRes.add(result.get(j) + numCharacter.get(k));
                }
            }
            result = tempRes;
        }
        return result;
    }
}