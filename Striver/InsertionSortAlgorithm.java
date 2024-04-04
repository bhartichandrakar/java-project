package Striver;

import java.util.Arrays;

public class InsertionSortAlgorithm {
    public static void main(String[] args) {
        int arr[] = {13,46,24,52,20,9,12};
        insertion_sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void insertion_sort(int[] arr) {
        for(int i = 0;i < arr.length; i++){
            int j = i;

            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
