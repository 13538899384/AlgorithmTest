package WangyiTest;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        int n = 0;//塔的数量
        int k = 0;//最大操作数

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] taValue = new int[n];//每个塔的初始高度
        for (int i = 0; i < n; i++) {
            taValue[i] = sc.nextInt();
        }
        sc.close();

        getResult(k,taValue);
    }

    public static void getResult(int k, int[] taValue){
        taValue = sort(taValue,0,taValue.length-1);
        int min = taValue[0];
        int max = taValue[taValue.length-1];
        if (max - min == 0){
            System.out.println(0 + " " + 0);
        }

    }

    public static int[] sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            sort(nums, low, mid);
            // 右边
            sort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
        return nums;
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }
}
