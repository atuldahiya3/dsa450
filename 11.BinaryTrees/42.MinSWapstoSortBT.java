
import java.util.Queue;

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
class Solution {
    public int minimumOperations(TreeNode root) {
        int res=0;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> currLevel= new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null){
                    q.offer(curr.left);
                    currLevel.add(curr.left.val);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                    currLevel.add(curr.right.val);
                }
            }
            res+=countOperations(currLevel);
        }
        return res;
    }
    public int countOperations(List<Integer> list){
        int n=list.size();
        int[][] arr= new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=list.get(i);
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][1] == i)
                continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][1];
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }
}