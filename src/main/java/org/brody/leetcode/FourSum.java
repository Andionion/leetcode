package org.brody.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 18. 四数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        System.out.println(JSONObject.toJSONString(lists));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // 使用双循环固定两个数，用双指针找另外两个数，通过比较与target的大小，移动指针
        List<List<Integer>> res = new LinkedList<>();
        // 先排序，排序之后，使用双指针固定两个数，移动两个数字
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            //  如果当前数字和上一个数字相同，跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 如果四个连续数字已经大于target，说明不会再有下一个了，跳出循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 如果当前数字加上最后三个数字小于target，说明当前数字太小，跳出循环
            if (nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }
            // 固定第二个数字
            for (int j = i + 1; j < length - 2; j++) {
                // 同样的，当前数字如果等于前一个数字，就跳过
                if (j - i > 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 如果当前数字加上第二个数字和它之后的两个数字之和大于target，就跳出循环
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // 如果当前数字加上第二个数字和最后两个个数字小于target，说明当前数字太小，跳出循环
                if (nums[i] + nums[j] + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }
                // 设左指针和右指针，左指针指向j+1，右指针指向n-1
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    // 如果当前四个数字之和等于target，说明找到四个
                    if (temp == target) {
                        List<Integer> integerList = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        res.add(integerList);
                        // 更新重复的left和right
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (temp > target) {
                        //如果当前数字之和大于target，右指针减小
                        right--;
                    } else {
                        //当前数字小于target，左指针增大
                        left++;
                    }
                }

            }
        }
        return res;
    }
}
