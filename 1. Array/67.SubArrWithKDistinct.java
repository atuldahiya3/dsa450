import java.util.HashMap;
import java.util.Map;

class Solution67 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    public int atMostK(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            // Add current element to the map
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // If we have more than k distinct numbers, shrink the window
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            // Add number of subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }
}