package PDF;

public class QuickSelect {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 4};
        int k = 3; // Find the 3rd smallest element
        System.out.println("The " + k + "-th smallest element is: " + quickSelect(nums, k));
    }

    public static int quickSelect(int[] nums, int k) {
        return quickSelectHelper(nums, 0 , nums.length - 1, k - 1);
    }
        
    private static int quickSelectHelper(int[] nums, int low, int high, int k) {
        if (low == high) {
            return nums[low];
        }
        int pivotIndex =  partition(nums, low, high);
        if (pivotIndex == k) { // Found the k-th smallest element
            return nums[pivotIndex];
        } else if (k < pivotIndex) { // Search in the left part
            return quickSelectHelper(nums, low, pivotIndex - 1, k);
        } else { // Search in the right part
            return quickSelectHelper(nums, pivotIndex + 1, high, k);
        }

    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;

        for(int j = low; j < high; j++){
            if (nums[j] < pivot) {
                swap(nums , i , j);
                i++;
            }
        }
        swap(nums, i, high); // Place the pivot in the correct position
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}


/* The **Quickselect algorithm** is a selection algorithm to find the k-th smallest (or largest) element in an unordered list. It works similarly to the **Quicksort algorithm**,
but instead of sorting the entire array, it focuses only on the part of the array that contains the desired element.

---

### **How Quickselect Works**

1. **Choose a Pivot**:
   - Pick a pivot element from the array (usually the last element or a random one).

2. **Partitioning**:
   - Rearrange the array such that elements smaller than the pivot are on the left, and elements greater than the pivot are on the right (similar to Quicksort).

3. **Check Pivot's Position**:
   - If the pivot is at the k-th position, return the pivot.
   - If the k-th position is in the left part, recurse into the left subarray.
   - If the k-th position is in the right part, recurse into the right subarray.

4. **Repeat** until the desired element is found.

---

### **Time Complexity**
- **Best/Average Case**: \( O(n) \) (similar to partitioning in Quicksort).
- **Worst Case**: \( O(n^2) \) (occurs when the pivot is consistently poorly chosen, e.g., smallest or largest element).

---

### **Quickselect Implementation in Java**

Here's how you can implement Quickselect to find the k-th smallest element:

```java
import java.util.Random;

public class QuickSelect {

    public static int quickSelect(int[] nums, int k) {
        return quickSelectHelper(nums, 0, nums.length - 1, k - 1); // k - 1 for 0-based index
    }

    private static int quickSelectHelper(int[] nums, int low, int high, int k) {
        if (low == high) { // Only one element in the range
            return nums[low];
        }

        int pivotIndex = partition(nums, low, high);

        if (pivotIndex == k) { // Found the k-th smallest element
            return nums[pivotIndex];
        } else if (k < pivotIndex) { // Search in the left part
            return quickSelectHelper(nums, low, pivotIndex - 1, k);
        } else { // Search in the right part
            return quickSelectHelper(nums, pivotIndex + 1, high, k);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high); // Place the pivot in the correct position
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 4};
        int k = 3; // Find the 3rd smallest element
        System.out.println("The " + k + "-th smallest element is: " + quickSelect(nums, k));
    }
}
```

---

 **How It Works**
1. **Input**: `{3, 2, 1, 5, 4}` with k = 3.
2. **Step 1 (First Partition)**:
   - Choose a pivot (e.g., `4`).
   - Partition the array around `4`: `{3, 2, 1, 4, 5}`.
   - Pivot index = `3`. Since \( k - 1 = 2 \), search left.
3. **Step 2 (Second Partition)**:
   - Partition the left subarray `{3, 2, 1}`.
   - Pivot = `2`: `{1, 2, 3}`.
   - Pivot index = `1`. \( k - 1 = 2 \), search right.
4. **Step 3**: Return the element at index `2`, which is `3`.

---

### **Key Points**
- Quickselect is faster than sorting when you only need the k-th element.
- It is widely used in problems involving finding medians, percentiles, or top \( k \) elements.
- Proper pivot selection (e.g., using randomization) can improve performance and avoid worst-case scenarios. */