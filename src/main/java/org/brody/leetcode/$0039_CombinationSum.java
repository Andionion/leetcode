package org.brody.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0039_CombinationSum {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    public static void main(String[] args) {
        $0039_CombinationSum solution = new $0039_CombinationSum();
        int[] candidates = {2, 3, 5};
        int target = 10;
        List<List<Integer>> lists = solution.combinationSum(candidates, target);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //思路：以target为根节点，每一个分支做减法，减到0或者负数的时候，剪枝。其中，减到0时，添加到结果集
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // 优化添加的代码1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new ArrayDeque<>());
        return res;
    }

    private void findCombinationSum(int residue, int start, ArrayDeque<Integer> pre) {
        //如果得到0，则将结果加入到结果集中
        if (residue == 0) {
            res.add(new ArrayList<>(pre));
            return;
        }

        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            //当前数字入栈
            pre.push(candidates[i]);
            //递归调用
            findCombinationSum(residue - candidates[i], i, pre);
            //如果当前不符合，为负数，则弹出第一个元素
            pre.pop();
        }

    }
}








































