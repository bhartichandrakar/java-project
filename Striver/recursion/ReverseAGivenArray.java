package Striver.recursion;

import java.util.Arrays;

public class ReverseAGivenArray {
    public static void main(String[] args) {
        int n = 5;
        int arr[] = { 5, 4, 3, 2, 1 };
        reverseArray(arr, 0, n - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void reverseArray(int[] arr, int start, int end) {

        if (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverseArray(arr, start+1, end-1);
        }
    }

}
