package WangyiTest;

import java.util.Scanner;

/**
 * 又到了丰收的季节，恰好小易去牛牛的果园里游玩。 牛牛常说他多整个果园的每个地方都了如指掌，小易不太相信，
 * 所以他想考考牛牛。 在果园里有N堆苹果，每堆苹果的数量为ai,小易希望知道从左往右数第x个苹果是属于哪一堆的。
 * 牛牛觉得问题太简单了，所以希望你来替他回答。
 * <p>
 * 输入描述:
 * <p>
 * 第一行一个数n(1<=n<=10^5) 第二行n个数ai(1<=ai<=1000),表示从左往右数第i堆有多少苹果
 * 第三行一个数m(1<=m<=10^5),表示有m次询问 第四行m个数qi,表示小易希望知道第qi个苹果属于哪一堆。
 * <p>
 * 输出描述:
 * <p>
 * m行，第i行输出第qi个苹果属于哪一堆。
 * <p>
 * 输入例子1:
 * <p>
 * 5
 * 2 7 3 4 9
 * 3
 * 1 25 11
 * <p>
 * 输出例子1:
 * <p>
 * 1
 * 5
 * 3
 * Created by XQM on 2018/9/1.
 */
public class Main0 {
    public static void main(String[] args) {
        int duiKey = 0;//堆数
        int askNum = 0;//询问次数

        Scanner sc = new Scanner(System.in);
        duiKey = sc.nextInt();
        int[] duiValue = new int[duiKey];//苹果数组
        int[] sum = new int[duiKey];//苹果和的数组

        for (int i = 0; i < duiKey; i++) {
            duiValue[i] = sc.nextInt();
        }

        askNum = sc.nextInt();

        int[] keyNum = new int[askNum];
        for (int j = 0; j < askNum; j++) {
            keyNum[j] = sc.nextInt();
        }
        sc.close();

        //构建和的数组 比如sum[0] = 第一堆苹果，sum[1] = 第一堆 + 第二堆,...
        sum[0] = duiValue[0];
        for (int i = 1; i < duiKey; i++) {
            sum[i] = sum[i - 1] + duiValue[i];
        }

        for (int k : keyNum) {
            System.out.println(getMaxAppleNum(k, sum) + 1);
        }
    }

    /**
     * 二分查找
     *
     * @param target
     * @param sum
     * @return
     */

    public static int getMaxAppleNum(int target, int[] sum) {
        int low = 0;
        int high = sum.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (high + low) / 2;
            if (sum[mid] == target)
                return mid;
            else if (sum[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    /**
     * 使用求数组连续最大和的做法超时
     *
     * @param target   目标
     * @param duiValue 数组
     * @return
     */
    public static int getAppleNum(int target, int[] duiValue) {
        long sum = 0;
        int temp = -1;
        long max = 0;

        for (int j : duiValue) {
            max += j;
        }
        if (target < 0 || target > max)
            return -1;

        for (int i = 0; i < duiValue.length; i++) {
            sum += duiValue[i];
            if (sum >= target) {
                temp = i + 1;
                break;
            }
        }
        return temp;
    }
}
