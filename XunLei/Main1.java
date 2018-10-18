package XunLei;

import java.util.*;

/**
 * 题目描述：
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是斐波那契式的：
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列，找到 A中最长的斐波那契式的子序列的长度。如果一个不存在，返回 0 。
 * （回想一下，子序列是从原序列A中派生出来的，它从A中删掉任意数量的元素（也可以不删），
 * 而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 * <p>
 * 示例：
 * <p>
 * 输入: [1,2,3,4,5,6,7,8]
 * <p>
 * 输出: 5
 * <p>
 * 解释:
 * <p>
 * 最长的斐波那契式子序列为：[1,2,3,5,8], 长度为5
 * Created by XQM on 2018/10/18.
 */
public class Main1 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    public static int lenLongestFibSubseq(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int item : A) {
            set.add(item);
        }

        int maxLength = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int firstA = A[j];
                int secondA = A[i] + A[j];
                int length = 2;

                while (set.contains(secondA)) {
                    int tmp = secondA;
                    secondA += firstA;
                    firstA = tmp;
                    maxLength = Math.max(maxLength, ++length);
                }
            }
        }

        return maxLength >= 3 ? maxLength : 0;
    }

    /******************************
     * 结束写代码
     ******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _A_size = 0;
        _A_size = Integer.parseInt(in.nextLine().trim());
        int[] _A = new int[_A_size];
        int _A_item;
        for (int _A_i = 0; _A_i < _A_size; _A_i++) {
            _A_item = Integer.parseInt(in.nextLine().trim());
            _A[_A_i] = _A_item;
        }

        res = lenLongestFibSubseq(_A);
        System.out.println(String.valueOf(res));

    }
}
