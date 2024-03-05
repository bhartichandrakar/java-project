package Leet;

public class L2AddTwoNumbers {
    public static void main(String[] args) {
        ListNode list1node1 = new ListNode(2);
        ListNode list1node2 = new ListNode(4);
        ListNode list1node3 = new ListNode(3);

        list1node1.next = list1node2;
        list1node2.next = list1node3;

        ListNode list2node1 = new ListNode(5);
        ListNode list2node2 = new ListNode(6);
        ListNode list2node3 = new ListNode(4);

        list2node1.next = list2node2;
        list2node2.next = list2node3;

        ListNode result = addTwoNumbers(list1node1, list2node1);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
        
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Initialize a dummy node (dummyHead) with a value of 0. 
        //This simplifies handling the head of the resulting linked list.
        ListNode dummyHead = new ListNode(0);
        ListNode currNode = dummyHead;
        int remainder = 0;
        //Use a while loop to iterate as long as either l1, l2, or carry is not zero.
        while(l1 != null || l2 != null || remainder != 0){
            //Calculate the sum by adding the values of the corresponding nodes from l1 and l2 (handling cases where one list might be shorter).
            //Add the previous remainder to the sum.
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + remainder;
            //Update the carry for the next digit by performing integer division (sum / 10).
            remainder = sum / 10;
            //Create a new ListNode with the current digit (sum % 10) and set it as the next pointer of the current node.
            currNode.next = new ListNode(sum%10);
            //Move the current pointer to the newly created node.
            currNode = currNode.next;
            //Advance the pointers l1 and l2 to the next nodes in their respective lists (if they exist).
            if(l1 != null)l1 = l1.next;
            if(l2 != null)l2 = l2.next;
        }
        //After the loop completes, the linked list representing the sum is constructed.
        //Return the dummyHead.next to skip the dummy node and return the actual result.
        return dummyHead.next;
        // Time Complexity:

        // O(max(m, n)): This represents the linear time complexity of iterating through both linked lists l1 and l2 at most once. The max(m, n) term accounts for the length of the longer list, as the loop might iterate until one list becomes empty.
        // Space Complexity:

        // O(max(m, n)): The solution creates new nodes for the resulting linked list. In the worst case, the length of the resulting list can be one more than the longer of the two input lists. However, the space used for constant variables like dummyHead and carry remains constant.
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }
}


// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

// Example 1:


// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.
// Example 2:

// Input: l1 = [0], l2 = [0]
// Output: [0]
// Example 3:

// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]
 

// Constraints:

// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading zeros.