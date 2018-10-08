package MeiTu;

import java.util.Scanner;

/**
 * * 题目描述：
 * 下雨了，下雨了，蚂蚁搬家了。
 * 已知有n种食材需要搬走，这些食材从1到n依次排成了一个圈。
 * 小蚂蚁对每种食材都有一个喜爱程度值Vi，当然，如果Vi小于0的时候，表示蚂蚁讨厌这种食材。
 * 因为马上就要下雨了，所以蚂蚁只能搬一次，但是能够搬走连续一段的食材。时间紧急，你快帮帮小蚂蚁吧，
 * 让它搬走的食材喜爱值和最大。
 * 输入:
 * 输入数据有两行，第一行有一个n，表示有n种食材排成了一个圈。（1 <= n<= 50000)
 * 第二行分别有n个数，代表蚂蚁对第n种食材的喜爱值Vi。(-10^9 <= Vi <= 10^9)
 * 输出:
 * 输出小蚂蚁能够搬走的食材的喜爱值总和的最大。
 * 样例输入:
 * 3
 * 3,-1,2
 * 样例输出:
 * 5
 * 样例输入:
 * 5
 * -8,5,-1,3,-9
 * 样例输出:
 * 7
 * <p>
 * Created by XQM on 2018/9/1.
 */
public class MinPathSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 食物总数
        int count = scanner.nextInt();
        scanner.nextLine();
        // 所有的食物喜爱值
        String favValueStr = scanner.nextLine();
        //将喜爱值Str转化为数组
        String[] favValues = favValueStr.split(",");

        int[] element = new int[count];
        for (int i = 0; i < count; i++) {
            element[i] = Integer.parseInt(favValues[i]);
        }

        int position = getFirstPosition(element,count);

        //最终需要转成求数组连续最大值，所以先取得这个数组
        int[] maxSum = getMaxSum(position,element,count);

        int maxFoodNum = getMaxFoodNum(maxSum);

        System.out.println(maxFoodNum);
    }

    /**
     * 取得连续最大食物总数
     *
     * @param maxSum
     * @return
     */
    private static int getMaxFoodNum(int[] maxSum) {
        if (maxSum == null){
            return 0;
        }
        int sum = 0;
        int maxFoodNum = maxSum[0];

        for (int i = 0;i < maxSum.length;i++){
            if (sum > 0){
                sum += maxSum[i];
            }else {
                sum = maxSum[i];
            }

            if (maxFoodNum < sum){
                maxFoodNum = sum;
            }
        }

        return maxFoodNum;
    }

    /**
     * 构建求数组连续最大值的数组
     *
     * @param position
     * @param element
     * @param count
     * @return
     */
    private static int[] getMaxSum(int position, int[] element, int count) {
        int[] maxSum = new int[count];
        int j = 0;

        for (int i = position;i < count;i++){
            maxSum[j++] = element[i];
        }

        for (int i = 0;i < position;i++){
            maxSum[j++] = element[i];
        }

        return maxSum;
    }

    /**
     * 取得食物偏爱数组最后一个负数，即蚂蚁讨厌的食材
     *
     * @param element
     * @param count
     * @return
     */
    private static int getFirstPosition(int[] element, int count) {
        int position = 0;
        for (int i = 0;i < count;i++){
            if (element[i] < 0){
                position = i;
            }
        }
        return position;
    }
}
