package org.brody.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0046_Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        $0046_Permutations solution = new $0046_Permutations();
        List<List<Integer>> permute = solution.permute(nums);
        for (List<Integer> integerList : permute) {
            System.out.println(integerList);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //已访问的数字记为1
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<>(), visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> temp, int[] visited) {
        //回溯跳出条件，当遍历完所有数字，返回
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //若当前数字已经被使用，continue
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            temp.add(nums[i]);
            backtrack(res, nums, temp, visited);
            //则回溯
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }


}
