package Striver;

import java.util.Arrays;

public class SelectionSortAlgorithm {
    public static void main(String[] args) {
        int arr[] = {13,46,24,52,20,9};
        selection_sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void selection_sort(int[] arr) {
        for(int i=0; i < arr.length -1; i++){
            int smallest_index = i;
            for(int j = i+1; j< arr.length;j++){
                if (arr[smallest_index] > arr[j]) {
                    smallest_index = j;
                }
            }
            //System.out.println(smallest_index);
            swap(arr, i, smallest_index);
        }

    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
