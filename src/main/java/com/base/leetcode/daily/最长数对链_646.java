//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
//
// 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
//
// 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
//
//
//
// 示例：
//
//
//输入：[[1,2], [2,3], [3,4]]
//输出：2
//解释：最长的数对链是 [1,2] -> [3,4]
//
//
//
//
// 提示：
//
//
// 给出数对的个数在 [1, 1000] 范围内。
//
// Related Topics 贪心 数组 动态规划 排序 👍 308 👎 0

package com.base.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最长数对链_646 {
    // sol1: 贪心算法，按结束时间排序，每次选择之后开始，最早结束的
    // 执行耗时:8 ms,击败了98.18% 的Java用户
    // 内存消耗:41.9 MB,击败了13.57% 的Java用户
    public int findLongestChain(int[][] pairs) {
        // (a,b)根据b排序
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int count = 1;
        int end = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > end) {
                count++;
                end = pairs[i][1];
            }
        }
        return count;
    }


    // sol2: 动态规划
    //
    public int findLongestChain2(int[][] pairs) {
        return 0;
    }
}
