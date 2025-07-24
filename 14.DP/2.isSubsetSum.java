class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum + 1];
        return helper(n - 1, sum, arr, dp);
    }

    static Boolean helper(int idx, int target, int[] arr, Boolean[][] dp) {
        if (target == 0) return true;
        if (idx == 0) return arr[0] == target;

        if (dp[idx][target] != null) return dp[idx][target];

        boolean notTake = helper(idx - 1, target, arr, dp);
        boolean take = false;
        if (arr[idx] <= target) {
            take = helper(idx - 1, target - arr[idx], arr, dp);
        }

        return dp[idx][target] = (take || notTake);
    }
}
