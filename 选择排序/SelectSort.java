package 选择排序;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {
    public static void selectSort(int[] arr){
        for (int i = 0;i < arr.length-1;i++){
            for (int j = i+1;j < arr.length;j++){
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();//单位是ms

        Random random = new Random();
        int[] arr = new int[10000];
        for (int i = 0;i < 10000;i++){
            arr[i] = random.nextInt(1000000);
        }
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
        long e = System.currentTimeMillis();
        System.out.println("冒泡排序时间是："+(e-b));
    }
}
