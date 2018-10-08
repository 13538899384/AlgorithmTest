package WangyiTest;

import java.util.Scanner;

/**
 * 求完成三个任务的最小代价，默认第一次完成一个任务代价是0，比如6，3，1 最小是5
 * <p>
 * Created by XQM on 2018/9/8.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] n = new int[3];
        for (int i = 0; i < 3; i++) {
            n[i] = sc.nextInt();
        }
        System.out.println(getMinPayout(n));
    }

    private static int getMinPayout(int[] array) {
        int[] n = bubbleSort(array);

        int[] sum = new int[n.length];

        int result = 0;

        sum[0] = 0;
        for (int i = 1; i < n.length; i++) {
            sum[i] = n[i - 1] - n[i];
        }

        for (int a : sum) {
            result += a;
        }

        return result;
    }

    public static int[] bubbleSort(int[] nums) {
        int temp = 0;
        int size = nums.length;
        boolean flag = true;

        for (int i = 0; i < size - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (nums[j] < nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
        }
        return nums;
    }
}
