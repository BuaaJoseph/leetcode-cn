
/*
 * @Description:
 * 
 * @Date: 2020-01-13 14:39:44
 * 
 * @Author: duchangchun@baidu.com
 */
/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = i + 1, j = nums.length - 1;
            while (k < j) {
                if (nums[i] + nums[k] + nums[j] == 0) {
                    List<Integer> tempRow = Arrays.asList(nums[i], nums[k], nums[j]);
                    if (!result.contains(tempRow)) {
                        result.add(tempRow);
                    }
                    j--;
                    k++;
                } else if (nums[i] + nums[k] + nums[j] > 0) {
                    j--;
                } else if (nums[i] + nums[k] + nums[j] < 0) {
                    k++;
                }
            }
        }

        return result;
    }
}