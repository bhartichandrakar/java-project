package LeetFull;

public class L21MergeSortedList {
    public static void main(String[] args) {

        ListNode list1node1 = new ListNode(1);
        ListNode list1node2 = new ListNode(2);
        ListNode list1node3 = new ListNode(4);

        list1node1.next = list1node2;
        list1node2.next = list1node3;

        ListNode list2node1 = new ListNode(1);
        ListNode list2node2 = new ListNode(3);
        ListNode list2node3 = new ListNode(4);

        list2node1.next = list2node2;
        list2node2.next = list2node3;
        
        ListNode result = mergeTwoLists(list1node1, list2node1);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Handle edge cases
        //Handle edge cases:

        // If list1 is null, return list2 as it's already sorted.
        // If list2 is null, return list1 as it's already sorted.
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        //Create dummy node:

        // Create a dummy node (with a value you can choose, like 0 here) to simplify handling the head of the merged list.
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        // Iterative comparison and merging:

        // Use a while loop to iterate as long as both list1 and list2 are not null.
        // In each iteration:
        while(list1 != null && list2 != null){
            // Compare the values of list1 and list2:
            // If list1.val < list2.val, append the smaller node (list1) to the current node (current.next) of the merged list and move list1 forward.
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            }
            // If list1.val >= list2.val, append the smaller node (list2) to the current node (current.next) and move list2 forward.
            else{
                current.next = list2;
                list2 = list2.next;
            }
            // Update the current pointer to point to the newly appended node.
            current = current.next;
        }

        // Append the remaining elements (if any)
        //Append remaining elements:

        //After the loop completes, if either list1 or list2 still has remaining elements, 
        //append them to the end of the merged list using the current.next pointer.
        current.next = (list1 != null) ? list1 : list2;
        //Return merged list:

        //Return the dummy.next as the actual head of the merged list, skipping the dummy node itself.
        return dummy.next; // Return the actual merged list (skip dummy node)

        // Time Complexity:

        // O(m + n): This represents the linear time complexity of iterating through both linked lists (list1 and list2) at most once and performing constant-time comparisons and assignments in each iteration. 
        //The total time complexity is proportional to the combined size (m + n) of the two input lists.
        // Space Complexity:

        // O(1): The solution creates a constant amount of extra space for the dummy node and loop counters, regardless of the linked list sizes. 
        //It modifies the existing linked list nodes by creating new pointers, but the overall space used remains constant.
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }  
}


// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

 

// Example 1:


// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]

// Example 2:
// Input: list1 = [], list2 = []
// Output: []

// Example 3:
// Input: list1 = [], list2 = [0]
// Output: [0]
 

// Constraints:

// The number of nodes in both lists is in the range [0, 50].
// -100 <= Node.val <= 100
// Both list1 and list2 are sorted in non-decreasing order.
