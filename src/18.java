/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * 注意：
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 示例：
 * 
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 
 * 满足要求的四元组集合为： [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

java.util.List;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // 参数校验
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int m = j + 1, k = nums.length - 1;
                while (m < k) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[k];
                    if (sum == target) {
                        List<Integer> tempList = Arrays.asList(nums[i], nums[j], nums[m], nums[k]);
                        if (!result.contains(tempList)) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[k]));
                        }
                        m++;
                        k--;
                    } else if (sum < target) {
                        m++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}