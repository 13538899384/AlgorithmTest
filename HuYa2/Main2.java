package HuYa2;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(finddup(a, a.length));
    }

    private static int finddup(int a[], int length) {
//        if (a.length == 0) {
//            return -1;
//        }
//
//        Set<Integer> set = new HashSet<>();
//        for (int j = 0; j < a.length; j++) {
//            if (set.contains(a[j])){
//                return a[j];
//            }else {
//                set.add(a[j]);
//            }
//        }
//        List<Integer> list = new ArrayList<>();
        int[] b = new int[length];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[j]){
                b[j] = a[i];
            }
        }
        return -1;
    }
}
