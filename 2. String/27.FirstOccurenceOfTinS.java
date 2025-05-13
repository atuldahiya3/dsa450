class Solution27 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        
        int n = haystack.length(), m = needle.length();
        int left = 0, right = 0, second = 0;

        while (right < n) {
            if (haystack.charAt(right) == needle.charAt(second)) {
                right++;
                second++;
                if (second == m) return left;
            } else {
                left++;
                right = left;
                second = 0;
            }
        }

        return -1;
    }
}
