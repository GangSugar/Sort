package 直接插入排序;

import java.util.Random;

/**
 * 直接插入排序：是稳定的排序
 */
public class InsertSort {
    public static void insertSort(int[] arr){
        for (int i = 1;i < arr.length;i++){
            int tmp = arr[i];//挖坑
            int j = i-1;
            for (;j >= 0;j--){
                if (arr[j] > tmp){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }
    }


    public static void main(String[] args) {
        long b = System.currentTimeMillis();//单位是ms

        Random random = new Random();
        int[] arr = new int[10_0000];
        for (int i = 0;i < 10_0000;i++){
            arr[i] = random.nextInt(1000000);
        }
        insertSort(arr);
        //System.out.println(Arrays.toString(arr));

        long e = System.currentTimeMillis();
        System.out.println("选择排序时间是："+(e-b));
    }
}
