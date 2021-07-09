package org.brody.leetcode;

/**
 * 38. 报数
 * <p>
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0038_CountAndSay {
    public static String countAndSay(int n) {
        //循环，举个例子，从4-5分析，4=1211，=>1=11, 2=12, 11=21

        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            //前面一个数字
            char pre = str.charAt(0);
            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (pre == c) {
                    count++;
                } else {
                    stringBuilder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            stringBuilder.append(count).append(pre);
            str = stringBuilder.toString();
        }

        return str;
    }

    public static void main(String[] args) {
        int n = 30;
        System.out.println(countAndSay(n));
    }
}































