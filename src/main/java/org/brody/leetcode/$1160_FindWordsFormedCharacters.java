package org.brody.leetcode;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 * <p>
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Chen
 */
public class $1160_FindWordsFormedCharacters {

    public int countCharacters(String[] words, String chars) {
        // 统计字母表中的字母出现次数
        int[] charsCount = count(chars);
        // 结果
        int res = 0;
        // 对词汇表中的每一个单词进行判断
        for (String word : words) {
            // 统计当前单词中的字母出现次数
            int[] wordCount = count(word);
            // 如果chars包含当前单词，则更新res
            if (contains(charsCount, wordCount)) {
                res += word.length();
            }
        }

        return res;
    }

    /**
     * 比较字母表中字母出现次数和单词中字母出现次数
     * 如果单词中字母出现次数大于字母表中字母出现次数，则立刻返回false
     *
     * @param charsCount 字母表中字母出现次数
     * @param wordCount  单词中字母出现次数
     * @return 返回是否包括
     */
    private boolean contains(int[] charsCount, int[] wordCount) {
        for (int i = 0; i < 26; i++) {
            if (charsCount[i] < wordCount[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 统计单词中26个字母出现的次数
     *
     * @param word 单词
     * @return 出现的次数
     */
    private int[] count(String word) {
        int[] counter = new int[26];
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            counter[c - 'a']++;
        }
        return counter;
    }
}
