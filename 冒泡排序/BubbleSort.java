package 冒泡排序;

public class BubbleSort {
    //从小到大排序
    public static void bubbleSort(int[] arr){
        for (int i = 0;i < arr.length-1;i++){
            for (int j = 0;j < arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    //优化版(增加性能)
    public static void bubbleSort2(int[] arr){
        for (int i = 0;i < arr.length-1;i++){
            boolean b = true;
            for (int j = 0;j < arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    b = false;
                }
            }
            if (b){//如果这里b是true。，说明上面没有发生交换，那么说明已经有序了，就不需要继续遍历了
                break;
            }
        }
    }
}
