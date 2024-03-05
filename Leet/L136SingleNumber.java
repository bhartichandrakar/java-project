package Leet;


public class L136SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2,4,2,4,1,5};
        int result = singleNumber(nums);
        System.out.println(result);
        
    }
    public static int singleNumber(int[] nums) {
        //XOR property: The solution utilizes the XOR (^) operator's properties:

        // a ^ a = 0 (XORing a number with itself results in 0).
        // a ^ 0 = a (XORing a number with 0 leaves the number unchanged).
        // Iterate and XOR:

        // Initialize a variable result to 0.
        // Use a for loop to iterate through each element (num) in the nums array.
        // In each iteration, perform an XOR operation (^) between the current result and the current element num.

        //How it works:

        // For elements that appear twice, XORing them together results in 0 (a ^ a = 0).
        // The single element that doesn't have a pair remains after all paired elements are XORed to 0.
        // Since XORing with 0 leaves a number unchanged (a ^ 0 = a), the final result will hold the single number after XORing all elements in the array.
        int result =0;
        for(int num : nums){
            result ^= num;
            
        }
        return result;

        // Time Complexity:

        // O(n): The code iterates through the array once using a for loop, leading to linear time complexity.
        // Space Complexity:

        // O(1): The solution uses a constant amount of extra space for the result variable, making the space complexity constant.
        // Advantages:

        // This solution is efficient for both space and time complexity.
        // It avoids the need for additional data structures and uses a single pass through the array.

        //Using Set
        //Code Explanation:
        // A HashSet<Integer> named set is created to store unique elements.
        // The code iterates through the nums array.
        // For each element in nums:
        // If the element is not already in the set, it is added.
        // Otherwise, it is removed from the set.
        // Finally, the code returns the first (and only) element in the set using an iterator.
        // Time Complexity Analysis:
        // Let’s denote the length of the nums array as n.
        // The key operations in the code are:
        // Adding an element to the set: This operation has an average time complexity of O(1) (constant time) for a HashSet.
        // Removing an element from the set: Again, this operation has an average time complexity of O(1).
        // Iterating through the array: The loop runs n times, so its time complexity is O(n).
        // Returning the first element from the set: This operation also has an average time complexity of O(1).
        // Combining these operations, the overall time complexity of the code is O(n).
        // Summary:
        // The given code snippet has a linear time complexity of O(n), where n represents the size of the input array nums.
        // Remember that time complexity measures the growth rate of an algorithm as the input size increases. It does not directly represent the actual execution time on a specific machine, which can vary due to hardware, compiler optimizations, and other factors.
        // Set<Integer> set = new HashSet<Integer>();

        // for(int i = 0; i < nums.length; i++){
        //     if(!set.contains(nums[i])){
        //         set.add(nums[i]);
        //     }else{
        //         set.remove(nums[i]);
        //     }
        // }
        // return set.iterator().next();

        //brute-force

        //Outer loop:

        // Use a for loop (i) to iterate through each element (nums[i]) in the nums array.
        // Inner loop (brute force):

        // Inside the outer loop, use another for loop (j) to iterate through the entire array again.
        // Check if the current element nums[i] (from the outer loop) is equal to any other element (nums[j]) in the array (excluding itself using i != j).
        // If a match is found (nums[i] == nums[j]), it means the current element has a pair. Set a flag found to true and use break to exit the inner loop. 
        //This optimization avoids unnecessary comparisons within the inner loop.
        // Single number check:

        // If the inner loop completes without finding a match (!found), it means the current element nums[i] is the single number that doesn't have a pair.
        // Return nums[i] in this case.
        //This approach is less efficient than the solution using bitwise XOR (O(n)) in terms of time complexity.
        // int unique = -1;
        // for(int i = 0; i < nums.length; i++){
        //     boolean duplicate = false;
        //     for(int j = 0; j < nums.length; j++){
        //         if (i != j && nums[i] == nums[j]) {
        //             duplicate = true;
        //             break;
        //         }
        //     }
        //     if(!duplicate){
        //         return nums[i];
        //     }
        // }
        // return unique;
            
        //Using HashMap
        // int unique = -1;
        // //create a map which will hold key as array index value and value will the count
        // Map<Integer,Integer> mapCount = new HashMap<>();
        // for(int i = 0; i < nums.length;i++){
        //     int count = 0;
        //     if(mapCount.get(nums[i]) != null){
        //         count = mapCount.get(nums[i]);
        //     }
        //     mapCount.put(nums[i], ++count);
        // }
        // for(Map.Entry<Integer,Integer> entry : mapCount.entrySet()){
        //     if (entry.getValue() == 1) {
        //         unique= entry.getKey();
        //         return unique;
        //     }
        // }
        // return unique;
    }
}


// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

 

// Example 1:

// Input: nums = [2,2,1]
// Output: 1
// Example 2:

// Input: nums = [4,1,2,1,2]
// Output: 4
// Example 3:

// Input: nums = [1]
// Output: 1
 

// Constraints:

// 1 <= nums.length <= 3 * 104
// -3 * 104 <= nums[i] <= 3 * 104
// Each element in the array appears twice except for one element which appears only once.