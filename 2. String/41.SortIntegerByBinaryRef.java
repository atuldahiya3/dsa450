
import java.util.Arrays;

class Solution {
    public int[] sortByReflection(int[] nums) {
        int n = nums.length;

        // store pairs: [reflectedValue, originalValue]
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String bin = Integer.toBinaryString(nums[i]);
            String rev = new StringBuilder(bin).reverse().toString();
            int reflected = Integer.parseInt(rev, 2);
            System.out.println(bin+","+rev);
            arr[i][0] = reflected;     // key for sorting
            arr[i][1] = nums[i];       // original number
        }

        // sort by reflected value
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];   // reflection
            return a[1] - b[1];                     // original value
        });

        // extract sorted original values
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = arr[i][1];
        }

        return res;
    }
}
