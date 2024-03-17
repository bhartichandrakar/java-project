import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	
	
	public static void main(String[] args) {
		String[] str = {"5","9","30","3","34"};
        System.out.println(largestNumber(str));
    }
    // Handle Empty Array:

    // The code checks if the input array nums is null or empty. If so, it returns an empty string.
    // Custom Comparator for Sorting:

    // It defines a custom comparator to sort the strings in descending order based on the combination of the two strings.
    // The compare method in the comparator takes two strings (a and b).
    // It constructs two concatenated strings: order1 by joining a and b, and order2 by joining b and a.
    // It compares order2 and order1 lexicographically. This ensures that strings that would form a larger number when combined come first in the sorted order.
    // Sorting and Building String:

    // It sorts the nums array using the custom comparator, which will arrange the strings in descending order based on the largest number they can form when combined.
    // It iterates through the sorted array and appends each string to a StringBuilder object (sb).
    // Handle Leading Zeros:

    // As a corner case, it checks for leading zeros in the resulting string. If the string length is greater than 1 and the first character is '0' (multiple leading zeros), 
    //it removes leading zeros from the StringBuilder until a non-zero digit is encountered. This ensures leading zeros don't affect the largest number representation.
    // Return Largest Number:

    // Finally, it returns the string representation of the largest number formed by concatenating the sorted array elements.
    private static int largestNumber(String[] str) {
        if (str == null || str.length == 0) {
            return 0;
          }

        Arrays.sort(str, new Comparator<String>() {
           @Override
           public int compare(String a, String b){
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
           }
        });

        
    StringBuilder sb = new StringBuilder();
    for (String num : str) {
      sb.append(num);
    }

    // Handle leading zeros (corner case)
    while (sb.length() > 1 && sb.charAt(0) == '0') {
      sb.deleteCharAt(0);
    }
        
        return Integer.parseInt(sb.toString());

        // Time Complexity:

        // O(n log n): Sorting the array using the custom comparator takes O(n log n) time, which dominates the complexity.
        // Space Complexity:

        // O(n): The solution uses extra space for the custom comparator object and the StringBuilder object, which scales linearly with the number of elements (n) in the array.
    }


    //Brute Force
    // private static int largestNumber(String[] str) {
    //     for(int i = 0; i < str.length - 1 ; i++){
    //         for(int j =0; j < str.length - i - 1; j++){
    //             String left = str[j] + str[j+1];
    //             String right = str[j+1] + str[j];
    //             if (Integer.parseInt(left.toString()) < Integer.parseInt(right.toString())) {
    //                 swap(str,j,j+1);
    //             }
    //         }
    //     }
    //     StringBuilder result = new StringBuilder();
    //     for(String st : str){
    //         result.append(st);
    //     }
    //     return Integer.parseInt(result.toString());
    // }

    // private static void swap(String[] str, int left, int right) {
    //     String temp = str[left];
    //     str[left] = str[right];
    //     str[right] = temp;
    // }
}