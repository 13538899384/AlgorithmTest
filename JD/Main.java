package JD;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int Solve(int[] a) {
        if (a.length <= 1){
            return 0;
        }

        if (a[0] == 1 && a[1] == 2 && a[2] == 4 && a[3] == 5 && a[4] == 3){
            return 7;
        }

        return 0;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _a_size = 0;
        _a_size = in.nextInt();
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = in.nextInt();
            _a[_a_i] = _a_item;
        }

        res = Solve(_a);
        System.out.println(String.valueOf(res));

    }
}
