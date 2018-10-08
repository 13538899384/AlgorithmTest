package HuYa;

import java.util.*;

/**
 * 中文分词
 * 题目描述：
 * 分词正向最大匹配算法（MM）是基于字典的最长词优先匹配，原理如下：
 * 1）从左向右取待切分汉语句的m个字符作为匹配字段，m为大机器词典中最长词条个数；
 * 2）查找词典并进行匹配。若匹配成功，则将这个匹配字段作为一个词切分出来；
 * 现有如下词典：
 * “中国”、“直播”、“游戏”、“游戏直播”、“综艺娱乐”、“互动直播平台”
 * 通过编程实现对如下句子进行正向最大匹配算法分词并找出和词典相匹配的结果，写出结果。
 * 输入描述:
 * 分词句子：“虎牙直播中国最大最好的互动直播平台。众多热门高清的游戏直播；上千款游戏，
 * 游戏大神齐聚虎牙。星光闪耀，顶尖赛事，综艺娱乐，美女秀场……不一样的精彩直播”
 * 输出描述:
 * 多个词用半角逗号分开,如:直播,游戏,虎牙
 * 示例1：
 * 输入：
 * 3 5
 * 0 3
 * 0 3
 * 0 3
 * 输出：
 * 12
 * <p>
 * Created by XQM on 2018/9/1.
 */
public class ChineseDiver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Set<String> directory = new LinkedHashSet<>();
        directory.add("中国");
        directory.add("直播");
        directory.add("游戏");
        directory.add("游戏直播");
        directory.add("综艺娱乐");
        directory.add("互动直播平台");

        //词典中最长词长度
        int maxLength = 6;
        Set<String> result = matchChinese(str, directory, maxLength);
        if (result.isEmpty()) {
            return;
        }
        for (String s : result) {
            System.out.println(s);
        }

    }

    /**
     * 返回查询的结果
     *
     * @param text       待匹配文本
     * @param dictionary 词典
     * @param maxLength  词典中最长词长度
     * @return
     */
    public static Set<String> matchChinese(String text, Set<String> dictionary, int maxLength) {
        //LinkedHashSet可以保持顺序输入，但是效率低，可以使用HashSet，然后再做排序处理
        Set<String> result = new LinkedHashSet<>();

        while (text.length() > 0) {
            int length = maxLength;//匹配文本长度不能超过词典中最长词长度
            if (text.length() < maxLength) {
                length = text.length();
            }
            //取指定的最大长度的文本去词典里面匹配
            String s = text.substring(0, length);
            while (!dictionary.contains(s)) {
                //如果长度为一且在词典中未找到匹配
                if (s.length() == 1) {
                    break;
                }
                //如果匹配不到，则长度减一继续匹配
                s = s.substring(0, s.length() - 1);
            }
            if (s.length() == 1) {
                if (dictionary.contains(s)) {//匹配则添加
                    result.add(s);
                }
            } else {
                result.add(s);
            }
            //从待查找文本中去除已经匹配的文本
            text = text.substring(s.length());
        }
        return result;
    }

}
