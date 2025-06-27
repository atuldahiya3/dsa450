/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    private Stack<TreeNode> s= new Stack<>();
    public BSTIterator(TreeNode root) {
        pushToLeft(root);
    }
    
    public int next() {
        TreeNode node=s.pop();
         if (node.right != null) {
            pushToLeft(node.right);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    public void pushToLeft(TreeNode node){
        while (node != null) {
            s.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */