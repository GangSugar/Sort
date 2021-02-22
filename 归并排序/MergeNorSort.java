package 归并排序;

import java.util.Arrays;
import java.util.Random;

/**
 * 非递归的归并
 */
public class MergeNorSort {
    //1.
    public static void mergeNorSort(int[] arr){
        for (int i = 1;i < arr.length;i *= 2){
            mergeNor(arr,i);
        }
    }
    //2.
    public static void mergeNor(int[] arr,int gap){
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = 0;
        if ((s2+gap-1) < arr.length){
            e2 = s2+gap-1;
        }else {
            e2 = arr.length-1;
        }

        int[] newArr = new int[arr.length];
        int k = 0;
        while (s2 < arr.length){

            while (s1 <= e1 && s2 <= e2){
                if (arr[s1] <= arr[s2]){
                    newArr[k++] = arr[s1++];
                }else {
                    newArr[k++] = arr[s2++];
                }
            }

            while (s1 <= e1){
                newArr[k++] = arr[s1++];
            }
            while (s2 <= e2){
                newArr[k++] = arr[s2++];
            }

            //代码到这里说明一组已经比较完毕
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 < arr.length ? s2+gap-1 : arr.length;

        }
        while (s1 <= arr.length-1){//最后有可能不够俩个归并段，从喜欢喝中跳出来
            newArr[k++] = arr[s1++];
        }
        for (int i = 0;i < arr.length;i++){
            arr[i] = newArr[i];
        }

    }
    public static void main(String[] args) {
        long b = System.currentTimeMillis();//单位是ms

        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0;i < arr.length;i++){
            arr[i] = random.nextInt(40);
        }
        System.out.println(Arrays.toString(arr));
        mergeNorSort(arr);
        System.out.println(Arrays.toString(arr));

        long e = System.currentTimeMillis();
        System.out.println("选择排序时间是："+(e-b));

    }
}
