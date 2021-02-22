package 归并排序;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    //1.
    public static void mergeSort(int[] arr){
        mergeSortInternal(arr,0,arr.length-1);
    }
    //2.分开
    public static void mergeSortInternal(int[] arr,int low,int high){
        if (low >= high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSortInternal(arr,low,mid);
        mergeSortInternal(arr,mid+1,high);

        //开始合并
        merge(arr,mid,low,high);
    }
    //3.合并
    public static void merge(int[] arr,int mid,int low,int high){
        int s1 = low;
        int s2 = mid+1;
        int[] newArr = new int[high-low+1];
        int k = 0;
        while (s1 <= mid && s2 <= high){
            if (arr[s1] <= arr[s2]){
                newArr[k++] = arr[s1++];
            }else {
                newArr[k++] = arr[s2++];
            }
        }
        while (s1 <= mid){
            newArr[k++] = arr[s1++];
        }
        while (s2 <= high){
            newArr[k++] = arr[s2++];
        }
        k = 0;
        for (int i = low;i <= high;i++){
            arr[i] = newArr[k++];
        }
    }
    public static void main(String[] args) {
        long b = System.currentTimeMillis();//单位是ms

        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0;i < arr.length;i++){
            arr[i] = random.nextInt(40);
        }
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

        long e = System.currentTimeMillis();
        System.out.println("选择排序时间是："+(e-b));
    }
}
