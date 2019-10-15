package www.epochong.sort;

import java.util.Arrays;


/**
 * 优化：设置一个标志，若一次循环没有交换，则已经有序
 */
public class BubbleSort {
     public static void bubbleSort(int[] arr) {
         if (arr == null || arr.length < 2) {
             return;
         }
         for (int e = arr.length - 1; e > 0; e--) {
             for (int i = 0; i < e; i++) {
                 if (arr[i] > arr[i + 1]) {
                     swap(arr,i,i+1);
                 }
             }
         }
     }
     static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }
    public static void printArray(int[] arr) {
        if(arr == null) {
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if(arr1 == null && arr2 == null) {
            return true;
        }
        if(arr1.length != arr2.length) {
            return false;
        }
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copyArray(int[] arr) {
        if(arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 1000;
        int maxSize = 50;
        int maxValue = 50;
        boolean succeed = true;
        for(int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if(!(isEqual(arr1,arr2))) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Your sort code is right!" : "Your sort code is wrong!");
        int[] arr = generateRandomArray(maxSize,maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

}