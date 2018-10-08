package Tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 能源石
 * 一座矿山抽象地看成一个字符串S，其中每个矿石看成一个字符，其中当一些矿石遵循一种特殊的元素排列时（字符串P）
 * ，它就能够构成一块能源石。同时相邻的两块能源石能够融合成一块更大的能源石，融合时他们前缀和后缀相同部分可能
 * 会重叠在一起（个人觉得是干扰信息，不重叠就是最大的了）
 * 例如P="aba"，融合组合为{abaaba,ababa,aba}，一块能源石的能量等于它长度的平方，求最多可以获得多少能量？
 * 输入：
 * xyabababcba
 * ab
 * 输出：36
 * <p>
 * 输入：
 * aaa
 * aa
 * 输出：9
 * <p>
 * <p>
 * Created by XQM on 2018/9/16.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String P = sc.nextLine();
        String str = S;
        ArrayList<Integer> start_list = new ArrayList<Integer>();
        int k = 0;
        while (str.indexOf(P) >= 0) {
            System.out.println(str);
            //start_list.add(str.indexOf(P)+k);
            k = str.indexOf(P) + k + 1;    //下次查找要跳过的长度
            //System.out.println(k);
            str = S.substring(k);

        }
        //合并操作
        long energySum = 0;
        int combine_start = 0;    //进行组合的起始索引
        for (int i = 0; i < start_list.size(); i++) {
            if (i > 0 && start_list.get(i) - start_list.get(i - 1) > P.length()) {
                //不发生合并，则重新开始组合操作
                energySum += (start_list.get(i - 1) - combine_start + P.length())
                        * (start_list.get(i - 1) - combine_start + P.length());
                //上一个字符串的起始位置-combine_start+P.length()
                //System.out.println(energySum);
                combine_start = start_list.get(i);
            } else if (i > 0) {
                //发生合并，什么也不做
            } else {    //第一个匹配字符串
                //不进行操作
                combine_start = start_list.get(i);
            }
        }
        //特殊处理最后一个匹配字符串
        energySum += (start_list.get(start_list.size() - 1) - combine_start + P.length())
                * (start_list.get(start_list.size() - 1) - combine_start + P.length());
        System.out.println(energySum);
    }

}
