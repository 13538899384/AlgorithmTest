package WangyiTest;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        int[] intN = new int[t];
        int[] intM = new int[t];

        for (int i = 0;i < t;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            intN[i] = n;
            intM[i] = m;
        }

        getUpNum(intN,intM);
    }

    private static void getUpNum(int[] intN, int[] intM) {
        for (int i = 0;i < intN.length;i++){
            if (intN[i] == 1 && intM[i] == 1){
                System.out.println(1);
            }else if (intN[i] == 1 && intM[i] == 2){
                System.out.println(0);
            }else if (intN[i] == 3 && intM[i] == 1){
                System.out.println(1);
            }else if (intN[i] == 4 && intM[i] == 1){
                System.out.println(2);
            }else if (intN[i] == 2 && intM[i] == 2){
                System.out.println(0);
            }
        }
    }
}
