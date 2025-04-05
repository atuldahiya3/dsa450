public class Solution51 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) return -1;  // base condition fixed

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) return mid;

        if (nums[mid] > target) {
            // target is in left half
            return binarySearch(nums, target, start, mid - 1);
        } else {
            // target is in right half
            return binarySearch(nums, target, mid + 1, end);
        }
    }
}