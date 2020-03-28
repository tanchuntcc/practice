package string;

/**
 * @author 谭春
 * Date: 2020/3/25
 * Description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 思路1.使用中心扩展法，遍历字符串，统计每个数相邻的数是否相等，即是否构成回文串。
 * 然后向两边扩展，每次记录回文串长度，最后选出长度最大的字符串。
 *     2.使用动态规划法，要判断一个字符串是否是回文，只需要判断这个字符串的左右两边字符相等且他们中包含的字符串也是回文串即可。
 */
public class longestPalindromeTwo {
//    public String longestPalindrome(String s) {
//        int longLength = 0, index = 0;
//        for (int i = 0; i < s.length(); i++) {
//
//            int left = i - 1, right = i + 1, temp = 1;
//            //如果左边构成回文串，继续向左边拓展
//            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
//                temp++;
//                left--;
//            }
//            //如果右边构成回文串，继续向右边拓展
//            while (right < s.length() && s.charAt(i) == s.charAt(right)) {
//                temp++;
//                right++;
//            }
//            //左右两边构成回文串，同时拓展
//            while (right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
//                temp += 2;
//                left--;
//                right++;
//            }
//            //选出回文串最初的长度和开始下标
//            if (longLength < temp) {
//                longLength = temp;
//                //left最后进行了--，所以要加一
//                index = left + 1;
//            }
//        }
//        return s.substring(index, index + longLength);
//    }

    public String longestPalindrome(String s) {
        //如果是空或者一位，直接返回
        if (s == null || s.length() < 2) {
            return s;
        }

        int length = s.length(), longLength = 1, index = 0;
        //动态规划二位数组，dp[left][right]=true 表示left到right这段索引的字符串为回文串
        boolean[][] dp = new boolean[length][length];

        //依次往后面遍历，类似暴力法，只不过用动态规划作为判断条件
        for (int right = 1; right < s.length(); right++) {
            for (int left = 0; left < right; left++) {
                //如果左右字符相等且子字符串为回文串，则当前字符串也为回文串。right-left<3表示left和初始状态没有公共部分
                if (s.charAt(right) == s.charAt(left) && (right - left < 3 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    if (longLength < right - left + 1) {
                        longLength = right - left + 1;
                        index = left;
                    }
                }
            }
        }
        return s.substring(index, index + longLength);
    }
}

