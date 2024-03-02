package LeetFull;

public class RemoveDuplicatesSortedList {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = deleteDuplicates(node1);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        //Handle edge cases: If the list is empty (head == null) or has only one element (head.next == null), 
        //there are no duplicates, so simply return the original list.
        if (head == null || head.next == null) {
            return head;
        }
        //Iterate with 'current' pointer: Initialize a pointer current to the head of the linked list.
        ListNode current = head;
        //Iterative comparison:
        //Use a while loop to iterate as long as the current.next is not null (so you don't compare the last node's next, which would be null).
        while(current.next != null){
            //Duplicate found: If current.val == current.next.val, a duplicate is found. 
            //Remove the duplicate by setting current.next = current.next.next (skipping over the duplicate node).
            if (current.val == current.next.val) {
                current.next = current.next.next;
            }
            //Unique element: If no duplicate is found, move the current pointer to the next node (current = current.next).
            else{
                current = current.next;
            }
        }
        //Return modified list: After the loop completes, the modified linked list without duplicates is returned.
        return head;

        // Time Complexity:

        // O(n): The code iterates through the linked list once, visiting each node at most once.
        // Space Complexity:

        // O(1): The solution modifies the linked list in-place, using only a constant amount of extra space for the current pointer and loop-related variables.
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode (int x)
        {
            val = x;
        }
    }
    
}


// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

// Example 1:


// Input: head = [1,1,2]
// Output: [1,2]
// Example 2:


// Input: head = [1,1,2,3,3]
// Output: [1,2,3]
