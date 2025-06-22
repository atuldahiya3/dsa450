// User function Template for Java//User function Template for Java
class Solution {
    static ArrayList<Integer> res;
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        res=new ArrayList<>();
        findSum(arr,0,0);
        return res;
    }
    public static void findSum(int[] arr, int sum, int index){
        if(index==arr.length){
            res.add(sum);
            return;
        }
        findSum(arr,sum+arr[index],index+1);
        findSum(arr,sum,index+1);
        
    }
}