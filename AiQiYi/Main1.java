package AiQiYi;

import java.util.*;

/**
 * 清雨又在吃自助餐了。
 * <p>
 * 排在清雨面前的有N种食物，排成一排，清雨可以选择其中的若干种食物，
 * 但是不能连续选择相邻的食物。因为清雨很挑食，当所有食物都不合口味时，
 * 他可以一种都不选，即一个都不选也算为一种方法。
 * <p>
 * 请问他有多少种选择食物的方法呢？
 * 样例解释：有3种食物，方案为1、2、3、13、不选，共5种
 * Created by XQM on 2018/9/28.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(getMaxWay(n));
    }

    private static int getMaxWay(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        //输出n所有的子集
        List<List<Integer>> mList = new ArrayList<>();
        int size = n == 0 ? 0 : 1 << n;//2的n次方，如果数组为0，则为0
        for (int i = 0; i < size; i++) {
            List<Integer> tmpList = new ArrayList<>();
            int index = i;
            for (int j = 0; j < n; j++) {
                if ((index & 1) == 1) {//判断最低为是否为1
                    tmpList.add(array[j]);
                }
                index >>= 1;//右移一位
            }
            mList.add(tmpList);
        }

        int count = 0;
        for (List<Integer> list : mList) {
            boolean b = true;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i+1) - list.get(i) == 1){
                    b = false;
                    break;
                }
            }
            if (b){
                count++;
            }
        }
        return count;
    }
}
