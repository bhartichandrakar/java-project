package LeetFull;

import java.util.HashSet;
import java.util.Set;

public class L141LinkedListCycle {
    public static void main(String[] args) {

        
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
        boolean result = hasCycle(node1);
        System.out.println(result);
    }
    //(Floyd's Cycle-Finding Algorithm - "Tortoise and Hare" Approach):
    //How it works:

    //This leverages Floyd's Cycle-Finding Algorithm, where the "slow" pointer acts like a tortoise, moving slowly, and the "fast" pointer acts like a hare, 
    //moving twice as fast. If there's a cycle, the "hare" will eventually loop around and meet the "tortoise" at some point within the cycle.
    public static boolean hasCycle(ListNode head) {
        //Handle Edge Cases:

        //If the head is null or has only one node (head.next == null), there's no cycle, so return false.
        if (head == null || head.next == null) {
            return false; // Empty list or single node has no cycle
        }

        //Initialize Pointers:

        // Create two pointers, slow and fast.
        // Set both slow and fast to point to the head of the linked list initially.
        ListNode slow = head;
        ListNode fast = head.next;
        //"Tortoise and Hare" Loop:
        //Use a while loop to iterate as long as slow and fast are not equal.
        while (slow != fast) {
            // Handle cases where 'fast' or 'fast.next' becomes null before meeting 'slow'
            //If the loop completes without slow and fast meeting, it means there's no cycle in the linked list, so return false.
            if (fast == null || fast.next == null) {
                return false; // No cycle found, 'fast' reached the end
            }
            //Inner Loop Condition: The loop terminates when either:
            // fast or fast.next becomes null (meaning fast has reached the end of the list without encountering a cycle).
            //Slow Pointer Movement: In each iteration, move slow by one node (slow = slow.next).
            //Fast Pointer Movement: Move fast by two nodes (fast = fast.next.next). This allows fast to "catch up" to slow if there's a cycle.
            // slow and fast meet at the same node within the cycle.
            slow = slow.next;
            fast = fast.next.next;
        }
        //If slow and fast ever point to the same node, it indicates a cycle exists, so return true.
        return true; // Cycle found, 'slow' and 'fast' meet

        //Time Complexity:

        // O(n): In the worst case, the loop might iterate through the entire linked list once (n times) if there's a long cycle at the end. However, 
        //for most cases with or without a cycle, the loop terminates much faster. The time complexity is considered linear in the length of the linked list.
        // Space Complexity:

        // O(1): The solution only uses constant extra space for the two pointers (slow and fast), regardless of the linked list size.
    }

    //brute force
    // public static boolean hasCycle(ListNode head) {
    //     if(head == null && head.next == null){
    //         return false;
    //     }
    //     Set<ListNode> visited = new HashSet<ListNode>();
    //     ListNode current = head;
    //     while (current != null) {
    //         if (visited.contains(current)) {
    //             return true;
    //         }
    //         visited.add(current);
    //         current = current.next;
    //     }
    //     return false;
    // }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }
}


// Given head, the head of a linked list, determine if the linked list has a cycle in it.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. Otherwise, return false.

 

// Example 1:


// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
// Example 2:


// Input: head = [1,2], pos = 0
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
// Example 3:


// Input: head = [1], pos = -1
// Output: false
// Explanation: There is no cycle in the linked list.
 

// Constraints:

// The number of the nodes in the list is in the range [0, 104].
// -105 <= Node.val <= 105
// pos is -1 or a valid index in the linked-list.
 

// Follow up: Can you solve it using O(1) (i.e. constant) memory?