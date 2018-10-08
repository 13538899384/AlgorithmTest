package HuYa2;

import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sumScore = sc.nextInt();

        System.out.println(getSortNum(sumScore));
    }

    private static int getSortNum(int sumScore) {
        if (sumScore % 2 != 0 && sumScore % 3 != 0) {
            return 0;
        }

//        if (sumScore <= 3 || (sumScore % 2 == 0 && sumScore % 3 != 0) || sumScore % 3 == 0 && sumScore % 2 != 0) {
//            return 1;
//        }


        if (sumScore % 2 == 0) {
            return sumScore / 8;
        } else {
            return sumScore / 2 + 1;
        }
    }
}
