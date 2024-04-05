package Striver;

import java.util.Arrays;

public class QuickSortAlgorithm {
    public static void main(String[] args) {
        int arr[] = {4,1,7,9,3,0};
        sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            
           // pi is partitioning index, arr[p] is placed at the right position
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }

    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[low];  // pivot chosen as the first element

         // i tracks elements less than pivot
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
              swap(arr, i, j);
              i++;
            }
          }
        swap(arr, low, i - 1); // Swap pivot with the last element smaller than it
        return (i - 1);
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
