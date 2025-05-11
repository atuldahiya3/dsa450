import java.util.HashMap;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // HashMap to store the frequency of prefix sums
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: prefix sum 0 occurs once

        int res = 0;   // To store the result (number of valid subarrays)
        int sum = 0;   // Running prefix sum

        for (int num : nums) {
            sum += num; // Update the prefix sum

            // Check if there exists a prefix sum such that (sum - goal) exists in the map
            // If it does, it means there are some subarrays that sum to the goal
            res += map.getOrDefault(sum - goal, 0);

            // Update the count of the current prefix sum in the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res; // Return the total number of subarrays with sum equal to goal
    }
}
