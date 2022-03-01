package org.brody.leetcode;

/**
 * 27. 移除元素
 * 给定一个数组 nums 和一个值 val ，你需要原地移除所有数值等于  val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O (1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        // 遍历数组，将所有不等于 val 的数值设置为当前值
        // 返回的长度实际上是一个新数组的最长下标，这个新数组中不包含给定的 val
        int ans = 0;
        for (int num : nums) {
            if (num != val) {
                nums[ans++] = num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(nums, val));
    }
}
