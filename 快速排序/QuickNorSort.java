package 快速排序;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * 非递归实现快排
 */
public class QuickNorSort {
    public static void quickNorSort(int[] arr,int low,int high) {
        //用栈进行辅助
        Stack<Integer> stack =new Stack<>();
        /*int start = 0;
        int end = arr.length-1;*/
        int index = paration(arr,low,high);//找基准的位置

        if (low +1 < index){
            stack.push(low);
            stack.push(index-1);
        }

        if (index < high-1){
            stack.push(index+1);
            stack.push(high);
        }
        while (!stack.isEmpty()){
            int end = stack.pop();
            int start = stack.pop();
            index = paration(arr,start,end);
            if (start +1 < index){
                stack.push(start);
                stack.push(index-1);
            }

            if (index < end-1){
                stack.push(index+1);
                stack.push(end);
            }
        }
    }

    public static int paration(int[] arr,int low,int high){
        int p = arr[low];//挖坑（找基准是可以改进的）
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
            arr[i] = random.nextInt(20);
        }
        quickNorSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        long e = System.currentTimeMillis();
        System.out.println("选择排序时间是："+(e-b));
    }


}
