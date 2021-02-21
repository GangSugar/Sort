package 希尔排序;

import java.util.Arrays;
import java.util.Random;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1){
            insertSort(arr,gap);
            gap = (gap /3)+1;
        }
        insertSort(arr,1);
    }

    public static void insertSort(int[] arr,int gap){
        for (int i = gap;i < arr.length;i++){
            int tmp = arr[i];//挖坑
            int j = i-gap;
            for (;j >= 0;j -= gap){
                if (arr[j] > tmp){
                    arr[j+gap] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+gap] = tmp;
        }
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();//单位是ms

        Random random = new Random();
        int[] arr = new int[10_0000];
        for (int i = 0;i < 10_0000;i++){
            arr[i] = random.nextInt(1000000);
        }
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

        long e = System.currentTimeMillis();
        System.out.println("选择排序时间是："+(e-b));
    }
}
