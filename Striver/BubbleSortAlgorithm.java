package Striver;

import java.util.Arrays;

public class BubbleSortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        bubble_sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void bubble_sort(int[] arr) {
        for(int i=0; i < arr.length - 1; i++){
            for(int j =0; j < arr.length - i - 1; j++){
                if (arr[j] > arr[j+1]) {
                    swap(arr, j , j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
