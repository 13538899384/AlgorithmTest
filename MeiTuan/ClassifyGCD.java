package MeiTuan;

import java.util.Scanner;

/**
 * 题目描述：
 * 给你A数组，询问ΣΣA[gcd(i,j)],1<=i<=n,1<=j<=m
 * 输入:
 * 每行有四个整数，N,n,m,p,其中N表示A数组长度,n,m,p为参数;对于A数组如下得出：
 * A[1]=p,A[x]=(A[x-1]+153)%p
 * 数据范围
 * 小数据 n,m<=N<=1000,p<=1000
 * 大数据 n,m<=N<=100000,p<=100000
 * 输出:
 * 输出答案
 * 样例输入:
 * 10 1 2 10
 * 样例输出:
 * 20
 * 样例输入:
 * 10 2 2 10
 * 样例输出:
 * 33
 * 样例解释:
 * 第一组样例生成的数组A为：10 3 6 9 2 5 8 1 4 7。最后输出的答案为：A[gcd(1,1)] + A[gcd(1,2)] = A[1] + A[1] = 20。
 * 第二组样例生成的数组A为：10 3 6 9 2 5 8 1 4 7。最后输出的答案为：A[gcd(1,1)] + A[gcd(1,2)] + A[gcd(2,1)] + A[gcd(2,2)] = A[1] + A[1] + A[1] + A[2] = 33。
 * <p>
 * Created by XQM on 2018/9/1.
 */
public class ClassifyGCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();

        int[] mGCDNum = getGCDNum(N, p);

        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                result += mGCDNum[getGCD(i, j)];
            }
        }

        System.out.println(result);
    }

    /**
     * 取最大公约数
     *
     * @param i
     * @param j
     * @return
     */
    private static int getGCD(int i, int j) {
        if (i == 1 || j == 1) {
            return 1;
        }
        return (i % j == 0) ? j : getGCD(j, i % j);
    }

    /**
     * 根据题目规则构建新的数组
     *
     * @param n
     * @param p
     * @return
     */
    private static int[] getGCDNum(int n, int p) {
        int[] mGCDNum = new int[n + 1];

        mGCDNum[1] = p;
        for (int i = 2; i <= n; i++) {
            mGCDNum[i] = (mGCDNum[i - 1] + 153) % p;
        }
        return mGCDNum;
    }
}
