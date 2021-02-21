package 快速排序;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    //快速排序主要就是找基准
    //1.
    public static void quickSort(int[] arr) {
        quick(arr,0,arr.length-1);
    }
    //2.用来递归的
    private static void quick(int[] arr, int low, int high) {
        if (low >= high)return;
        int index = paration(arr,low,high);

        quick(arr,low,index-1);
        quick(arr,index+1,high);
    }

    //2.找基准
    public static int paration(int[] arr,int low,int high){
        int p = arr[low];//挖坑
        while (low < high){
            while (low < high && arr[high] >= p){
                high--;
            }
            if (arr[high] < p){
                arr[low] = arr[high];
            }else {
                break;
            }
            while (low < high && arr[low] <= p){
                low++;
            }
            if (arr[low] > p){
                arr[high] = arr[low];
            }else {
                break;
            }
        }
        arr[low] = p;//填坑
        return low;
    }
    public static void main(String[] args) {
        long b = System.currentTimeMillis();//单位是ms

        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0;i < arr.length;i++){
            arr[i] = random.nextInt(100);
        }
        //System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
        long e = System.currentTimeMillis();
        System.out.println("冒泡排序时间是："+(e-b));
    }

}
