package Leet;

public class L104MaximumDepthBinaryTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int maxDepth = maxDepth(root);
        System.out.println(maxDepth);
        
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int result = Math.max(left, right) + 1;
        return result;
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val =val;}
        TreeNode(int val, TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

/* Base Case: If the root node is null (empty tree), the depth is 0 and the function returns 0.
Recursive Calls: The function recursively calls itself (maxDepth) on the left and right subtrees of the current node.
Maximum Depth Calculation: After getting the depths of the left (leftDepth) and right (rightDepth) subtrees, the function returns the maximum depth among them (Math.max(leftDepth, rightDepth)) plus 1 (accounting for the current node's depth).
Time Complexity:

Each node is visited exactly once.
In the worst case (balanced tree), each visit involves two recursive calls.
Time complexity: O(n), where n is the number of nodes in the tree.
Space Complexity:

Due to recursion, the function calls create a call stack. In the worst case (balanced tree), the depth of the call stack is equal to the tree's height.
Space complexity: O(h), where h is the height of the tree (in the worst case, equal to n for a balanced tree).
Alternative Iterative Approach:

This problem can also be solved using an iterative approach with a stack (depth-first search). However, the time complexity remains O(n) and the space complexity might be slightly higher due to the stack usage.

Key Points:

The recursive approach is straightforward and easy to understand.
The time complexity is linear in the number of nodes.
The space complexity depends on the tree's height (worst case: O(n) for a balanced tree). */



/* Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100 */
