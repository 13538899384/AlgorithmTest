package SanQiHuYu;

/**
 * 题目：强盗打劫房屋
 * 一名专业强盗，计划沿着一条街打劫房屋，每间房屋都有一定数量的金额
 * ，唯一能阻止你打劫的约束条件就是：由于房屋之间有安全系统相连，规定不可以打劫
 * 相邻的房屋
 * 给定一列非负整数，代表每间房屋的金钱数，计算出一个晚上最多打劫到的金钱数
 *
 * Created by XQM on 2018/9/1.
 */
public class RobberMoney {
    public static void main(String[] args) {
        System.out.println(getMaxProfit(new int[] {2,3,4,9,3,10,2}));
    }

    private static int getMaxProfit(int[] nums){
        int take = 0,noTake = 0,maxProfit = 0;
        for (int i = 0;i < nums.length;i++){
            take = noTake + nums[i];
            noTake = maxProfit;
            maxProfit = Math.max(take,noTake);
        }
        return maxProfit;
    }
}
