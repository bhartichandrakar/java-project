package LeetFull;

import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L160IntersectionTwoLinkedLists {
    public static void main(String[] args) {
        ListNode list1node1 = new ListNode(1);
        ListNode list1node2 = new ListNode(1);
        ListNode list1node3 = new ListNode(2);

        list1node1.next = list1node2;
        list1node2.next = list1node3;

        ListNode list2node1 = new ListNode(5);
        ListNode list2node2 = new ListNode(1);
        ListNode list2node3 = new ListNode(2);

        list2node1.next = list2node2;
        list2node2.next = list2node3;
        list2node1.next = list1node2;

        ListNode result = getIntersectionNode(list1node1, list2node1);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //If either headA or headB is null, there's no intersection, so return null.
        if ((headA == null) || (headB == null)) {
            return null;
        }
        //It calls a helper function getLLLength to calculate the lengths of both headA and headB. 
        //These lengths are stored in lengthA and lengthB.
        int lengthA = getLLLength(headA);
        int lengthB = getLLLength(headB);
        //The code iterates through the longer list (headA initially) using a while loop until its length (lengthA) becomes equal to the shorter list's length (lengthB). 
        //This ensures both pointers start at nodes with the same distance from the end of their respective lists.
        //In each iteration, lengthA is decremented, and headA is advanced to the next node.
        while (lengthA > lengthB) {
            lengthA--;
            headA = headA.next;
        }

        while (lengthB > lengthA) {
            lengthB--;
            headB = headB.next;
        }
        //Once both pointers (headA and headB) are at nodes with the same distance from the end (due to the previous adjustment), a new while loop iterates through both lists simultaneously.
        while (headA != headB) {
            //If headA and headB become the same node, it means an intersection is found, and the function returns that node (headA).
            //Both headA and headB are advanced to their next nodes for the next comparison.
            headA = headA.next;
            headB = headB.next;
        }
        //ime Complexity:

        // O(m + n): This represents the linear time complexity of the solution.
        // Calculating list lengths takes O(m) and O(n) for headA and headB, respectively.
        // The main loop iterates at most m + n times (considering both adjustment and comparison loops) in the worst case.
        // Space Complexity:

        // O(1): The solution uses constant extra space for variables like lengthA, lengthB, and temporary pointers (headA, headB) regardless of the list sizes.





        //Brute Force O(nm)
        // ListNode currentA = headA;
        // //Use a while loop to iterate through the nodes of headA as long as the current node (currentA) is not null.
        // //For each node (currentA) in headA, create an inner while loop to iterate through the nodes of headB using currentB.
        // while (currentA != null) {
        //     ListNode currnetB = headB;
        //     while (currnetB != null) {
        //         //Inside the inner loop, compare the current nodes (currentA and currentB) using a reference equality check (==). If they are the same, it means an intersection is found, and the function returns currentA.
        //         if (currentA == currnetB) {
        //             return currentA;
        //         }
        //         currnetB = currnetB.next;
        //     }
        //     currentA = currentA.next;
        // }

        //Time Complexity:

        // O(mn): In the worst case, the outer loop iterates through all nodes in headA (m nodes), and for each node, the inner loop iterates through all nodes in headB (n nodes). This results in a potential m * n comparisons, leading to a quadratic time complexity.
        // Space Complexity:

        // O(1): The solution uses constant extra space for variables like currentA and currentB regardless of the list sizes.

        //Solution using hashset
        // Set<ListNode> visited = new HashSet<ListNode>();
        // while (headA != null) {
        //     visited.add(headA);
        //     headA = headA.next;
        // }

        // while(headB != null){
        //     if (visited.contains(headB)) {
        //         return headB;
        //     }
        //     headB = headB.next;
        // }
           //If the outer loop completes without finding any intersection, it means there's no common node between headA and headB, so the function returns null. 
        return headA;
    }

    private static int getLLLength(ListNode head) {
        int length = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        return length;
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



// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

// For example, the following two linked lists begin to intersect at node c1:


// The test cases are generated such that there are no cycles anywhere in the entire linked structure.

// Note that the linked lists must retain their original structure after the function returns.

// Custom Judge:

// The inputs to the judge are given as follows (your program is not given these inputs):

// intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
// listA - The first linked list.
// listB - The second linked list.
// skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
// skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
// The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.

 

// Example 1:


// Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
// Output: Intersected at '8'
// Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
// From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
// - Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
// Example 2:


// Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
// Output: Intersected at '2'
// Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
// From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
// Example 3:


// Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
// Output: No intersection
// Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
// Explanation: The two lists do not intersect, so return null.
 

// Constraints:

// The number of nodes of listA is in the m.
// The number of nodes of listB is in the n.
// 1 <= m, n <= 3 * 104
// 1 <= Node.val <= 105
// 0 <= skipA < m
// 0 <= skipB < n
// intersectVal is 0 if listA and listB do not intersect.
// intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 

// Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?