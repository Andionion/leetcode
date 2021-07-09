package org.brody.leetcode;

/**
 * @author CYF
 */
public class $0045_JumpGameII {
    public static void main(String[] args) {
        $0045_JumpGameII solution = new $0045_JumpGameII();
        int[] nums = {2, 2, 3, 0, 4};
        System.out.println(solution.jump(nums));
    }

    public int jump(int[] nums) {
        //顺藤摸瓜，贪婪算法，每次在可跳范围内选择可以调的最远的位置
        //使用end表示当前能跳的边界。如果到了边界，更新更远的边界

        //判断是否能调到尾部
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        //如果不能跳到尾部，则 return -1
        if (lastPos != 0) {
            return -1;
        }
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            //i + nums[i] 等于在当前位置上能跳到最远的位置索引
            maxPosition = Math.max(maxPosition, i + nums[i]);
            //遇到边界，就更新边界，并且步数加一
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
