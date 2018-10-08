package baidu;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 计算苹果次品率
 *
 * Created by XQM on 2018/9/14.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sums = new int[n];

        for (int i = 0; i < n; i++) {
            sums[i] = sc.nextInt();
        }

        getRateOfRightApple(sums);
    }

    private static void getRateOfRightApple(int[] sums) {
        if (sums.length == 1){
            if (sums[0] < 5900){
                System.out.println("0.00%");
            }else {
                System.out.println("100.00%");
            }
        }else {
            double mFailCount = 0;
            for (int i = 0; i < sums.length; i++) {
                if (sums[i] < 5900){
                    mFailCount++;
                }
            }
            DecimalFormat mFormat = new DecimalFormat("#.00");

            float tmp = ((float) mFailCount) / ((float) sums.length) * 100;
            String result = mFormat.format((tmp)) + "%";

            System.out.println(result);
        }
    }
}