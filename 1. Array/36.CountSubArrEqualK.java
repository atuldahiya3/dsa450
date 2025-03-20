import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Variable to keep track of the cumulative sum of elements
        int currSum = 0;
        // Variable to store the count of subarrays that sum to k
        int count = 0;
        // HashMap to store prefix sums and their frequency
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        
        // Initialize with {0:1} to handle cases where a subarray itself equals k
        prefixSum.put(0, 1);

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Add the current element to cumulative sum
            currSum += nums[i];

            // Check if there exists a prefix sum such that (currSum - k) exists in map
            // This means there exists a subarray with sum equal to k
            if (prefixSum.containsKey(currSum - k)) {
                count += prefixSum.get(currSum - k); // Add the count of such occurrences
            }

            // Store the current prefix sum in the HashMap
            // If it already exists, increment its count
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }

        // Return the total count of subarrays with sum equal to k
        return count;
    }
}