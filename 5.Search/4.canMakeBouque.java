class Solution4 {
    public int minDays(int[] bloomDay, int m, int k) {
        long total = (long) m * k;
        if (total > bloomDay.length) return -1;

        int min = minimum(bloomDay);
        int max = maximum(bloomDay);
        int result = -1;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (canMakeBouquets(bloomDay, mid, m, k)) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return result;
    }

    public int minimum(int[] bloomDay) {
        int ans = Integer.MAX_VALUE;
        for (int day : bloomDay) {
            ans = Math.min(ans, day);
        }
        return ans;
    }

    public int maximum(int[] bloomDay) {
        int ans = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            ans = Math.max(ans, day);
        }
        return ans;
    }

    public boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}
