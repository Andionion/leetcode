package org.brody.leetcode.base;

import lombok.Data;

/**
 * 博弈问题中先手后手类
 * <p>
 * first表示先手能获得的最高分数
 * <p>
 * second表示后手能获得的最高分数
 *
 * @author CYF
 */
@Data
public class Pair {
    /**
     * 表示先手能获得的最高分数
     */
    public int first;
    /**
     * 表示后手能获得的最高分数
     */
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
