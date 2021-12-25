package org.brody.leetcode.base;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author brody
 * @date 2021/12/25
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;


    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
