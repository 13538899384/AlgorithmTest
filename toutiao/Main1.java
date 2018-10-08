package toutiao;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by XQM on 2018/9/9.
 */
public class Main1 {
    public static void main(String[] args){

        int result = 0;

        String str = "sdf";

        if (str.length() == 1) {
            result = 1;
        }
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            }
            if (!set.contains(c)) {
                if (c != ' ') {
                    set.add(c);
                }
            }
        }
        result = set.size();

        int[] a = {1,2,3,4,5,6};
        int[] b = new int[6];
        System.arraycopy(a,0,b,0,6);
        System.out.println(Arrays.toString(b));
        if (a == b){
            System.out.println("sd");
        }
    }
}
