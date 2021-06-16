package org.brody.leetcode;

/**
 * 6. Z字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        //设置两个指针，一个down，一个loc，down表示是否向下，loc表示向右
        if (numRows == 1) {
            return s;
        }

        //防止空指针异常
        int len = Math.min(s.length(), numRows);

        String[] rows = new String[len];
        for (int i = 0; i < len; i++) {
            rows[i] = "";
        }

        int loc = 0;
        boolean down = false;

        for (int i = 0; i < s.length(); i++) {
            rows[loc] += s.substring(i, i + 1);
            //loc为0表示向下走，loc为numRows-1表示向右走
            if (loc == 0 || loc == numRows - 1) {
                down = !down;
            }
            //down为true，表示正在往下走，为false，表示正在向右走
            loc += down ? 1 : -1;
        }

        StringBuilder ans = new StringBuilder();
        for (String row : rows) {
            ans.append(row);
        }

        return ans.toString();

    }

}
