package org.brody.leetcode;

/**
 * 41. 缺失的第一个正数
 * <p>
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为 O (n)，并且只能使用常数级别的空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0041_FirstMissingPositive {
    public static void main(String[] args) {
        $0041_FirstMissingPositive solution = new $0041_FirstMissingPositive();
        int[] nums = {7, 8, 9, 5, 3};
        System.out.println(solution.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        //简单来讲就是：原数组：{3,4,-1,1} → {1,-1,3,4}, 即要把每个数字放到对应下标的位置减 1 处 (数字 1 放到 1-1=0 下标位置), 最终放置的效果为：{1,2,3,4}, 第一个位置从 1 开始；
        //从数组第一个数字开始遍历，首先这个数字要在 1-nums.length 长度范围内，否则越界无法交换；
        //例如：交换 {3,4,-1,1}。(1): 进入循环交换 3、-1, 得到 {-1,4,3,1},i 无自增；(2): 再进入循环 i 还是 0 , 但 if 不符合条件，i++;(3): 再次进入循环 i = 1, 交换 4、1, 得到 {-1,1,3,4},i 无自增；(4): 再进入循环，交换 - 1,1, 得到 {1,-1,3,4},i 无自增，(5): 再进入循环，i++;(6):i++;(7): 再进入循环，i++;(8): 退出。
        //最后通过 while 循环从数组左至右找第一个不符合条件的值即可，如果没有的话，那么数组就是排序好的 1-nums.length 的数值，返回 i + 1 即可；
        //if + else {i++;}, 也可替换为 while 但别忘记再加 for 循环中的 i++;
        int len = nums.length;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] < len && nums[i] >= 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        int ans = 0;
        while (ans < len && ans + 1 == nums[ans]) {
            ans++;
        }
        return ans + 1;
    }
}
































