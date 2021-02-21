package 堆排序;

import java.util.Arrays;

public class HeapSort {
    //排序用向下调整（大根堆）
    public static void adjustDowdHeap(int[] arr,int parent,int len){
        int child = parent*2+1;
        while (child < len){
            if (child+1 < len && arr[child] < arr[child+1]){
                child++;
            }
            if (arr[parent] < arr[child]){
                int tmp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tmp;
                parent = child;
                child = parent*2+1;
            }else {
                break;
            }
        }
    }

    public static void heapSort(int[] arr){
        int end = arr.length-1;
        while (end > 0){
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            adjustDowdHeap(arr,0,end);
            end--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        for (int i = (arr.length-1-1)/2;i >= 0;i--){
            adjustDowdHeap(arr,i,arr.length);
        }
        //System.out.println("建立堆之后的数组是："+ Arrays.toString(arr));
        //接下来进行排序
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
