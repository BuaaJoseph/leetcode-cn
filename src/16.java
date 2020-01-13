/**
 * 给定一个包括 n 个整数的数组 nums 和
 * 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int distance = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 1, j = nums.length - 1;
            while (k < j) {
                int sum = nums[i] + nums[k] + nums[j];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    if (sum - target < distance) {
                        distance = sum - target;
                        res = sum;
                    }
                    j--;
                } else if (sum < target) {
                    if (target - sum < distance) {
                        distance = target - sum;
                        res = sum;
                    }
                    k++;
                }
            }
        }
        return res;
    }
}