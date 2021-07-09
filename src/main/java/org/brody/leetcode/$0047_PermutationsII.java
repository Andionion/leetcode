package org.brody.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 47. 全排列II
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0047_PermutationsII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2};
        $0047_PermutationsII solution = new $0047_PermutationsII();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<>(), visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> temp, int[] visited) {
        if (temp.size() == nums.length) {
            if (!res.contains(temp)) {
                res.add(new ArrayList<>(temp));
                return;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            temp.add(nums[i]);
            backtrack(res, nums, temp, visited);
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }
}
