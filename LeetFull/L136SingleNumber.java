package LeetFull;

public class L136SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        int result = singleNumber(nums);
        System.out.println(result);
        
    }
    public static int singleNumber(int[] nums) {

        int result =0;
        for(int num : nums){
            result ^= num;
            
        }
        return result;
        //brute-force
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
