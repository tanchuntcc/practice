package binarytree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 已同步至博客
 * @author 谭春
 * Date: 2020/3/28
 * Description:
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 *  
 *
 * 示例：
 *
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * 每个单词都是小写字母 。
 *
 * 思路：1.创建一个26位的字典树，遍历字符串数组。题中如果一个长字符串的后缀可以装下短字符串时，
 * 不统计短字符串长度，所以，倒序遍历字符串元素，如果其中每一位字符都存在则可以不统计它的长度，如果不存在，则存储该字符且统计该字符对应词的长度+1.
 *       2.将字符串数组放入Set集合中，然后遍历字符串数组，每次都对字符串从后面截取部分，然后去Set集合中删除元素，最终Set集合留下来的肯定是后缀不包含元素。
 */
public class PrefixTreeEncoding {
    class Trie {
        int val;
        Trie[] tries = new Trie[26];

        public Trie() {
        }
    }

    public int minimumLengthEncoding(String[] words) {
        //将字符串数组以字段长度倒序
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        Trie trie = new Trie();
        int length = 0;
        for (String word : words) {
            boolean isNew = false;
            //不能操作头节点，因为每次都要从头节点重新遍历
            Trie cur = trie;
            //从后往前遍历，方便查找单词的后缀与后面的单词是否重合
            for (int i = word.length() - 1; i >= 0; i--) {
                //该字符在26位数组中的索引
                int c = word.charAt(i) - 'a';
                //如果当前的字符是新的，那么他会重新创建一个分支节点并延续。
                if (cur.tries[c] == null) {
                    isNew = true;
                    cur.tries[c] = new Trie();
                }
                //字典树向下遍历
                cur = cur.tries[c];
            }
            //如果是新单词，必须计算整个单词长度
            if (isNew) {
                length += word.length() + 1;
            }
        }
        return length;
    }

//    public int minimumLengthEncoding(String[] words) {
//        //将数组放入set集合
//        Set<String> good = new HashSet(Arrays.asList(words));
//        //遍历删除后缀
//        for (String word: words) {
//            for (int k = 1; k < word.length(); ++k) {
//                good.remove(word.substring(k));
//            }
//        }
//
//        int ans = 0;
//        //统计剩余的字符串长度
//        for (String word: good) {
//            ans += word.length() + 1;
//        }
//        return ans;
//    }


}

