public class Test {
	
	
	public static void main(String[] args) {
		int[] nums = {1,2,2};
		int result = removeDuplicates(nums);
		System.out.println(result);
	}

	public static int removeDuplicates(int[] nums) {
		int n = nums.length;
        if (n == 0) {
            return 0; // Empty array
        }

        int uniqueCount = 1; // Initialize with the first element (already unique)

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueCount] = nums[i]; // Move unique element to the next position
                uniqueCount++;
            }
        }

        return uniqueCount;
	}

}