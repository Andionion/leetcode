package org.brody.leetcode;

import java.util.*;

/**
 * @author CYF
 */
public class $0040_CombinationSumII {


    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    public static void main(String[] args) {
        $0040_CombinationSumII solution = new $0040_CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> lists = solution.combinationSum2(candidates, target);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //思路：以target为根节点，每一个分支做减法，减到0或者负数的时候，剪枝。其中，减到0时，添加到结果集
        int length = candidates.length;

        if (length == 0) {
            return res;
        }
        // 优化添加的代码1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        len = length;
        this.candidates = candidates;
        findCombinationSum(target, 0, new ArrayDeque<>());

        return res;
    }

    private void findCombinationSum(int residue, int start, ArrayDeque<Integer> pre) {
        //如果得到0，则将结果加入到结果集中
        if (residue == 0) {
            List<Integer> list = new ArrayList<>(pre);
            Collections.sort(list);
            if (!res.contains(list)) {
                res.add(list);
            }
            return;
        }

        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            //当前数字入栈
            pre.push(candidates[i]);
            //递归调用, 因为是不重复取，所以是i+1;
            findCombinationSum(residue - candidates[i], i + 1, pre);
            //如果当前不符合，为负数，则弹出第一个元素
            pre.pop();
        }

    }
}
