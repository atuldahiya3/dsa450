import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int LS = s.length();
        int LP = p.length();
        List<Integer> res = new ArrayList<>();

        if (LS < LP) return res; // Edge case: s is smaller than p

        HashMap<Character, Integer> HS = new HashMap<>();
        HashMap<Character, Integer> HP = new HashMap<>();

        // Initialize frequency maps for p and first LP characters of s
        for (int i = 0; i < LP; i++) {
            HS.put(s.charAt(i), HS.getOrDefault(s.charAt(i), 0) + 1);
            HP.put(p.charAt(i), HP.getOrDefault(p.charAt(i), 0) + 1);
        }

        // Check first window
        if (HS.equals(HP)) {
            res.add(0);
        }

        // Sliding window approach
        for (int i = LP; i < LS; i++) {
            char newChar = s.charAt(i);          // New character to add
            char oldChar = s.charAt(i - LP);     // Old character to remove

            // Update frequency map
            HS.put(newChar, HS.getOrDefault(newChar, 0) + 1);
            HS.put(oldChar, HS.get(oldChar) - 1);

            // Remove key if value is 0 (to keep maps comparable)
            if (HS.get(oldChar) == 0) {
                HS.remove(oldChar);
            }

            if (HS.equals(HP)) {
                res.add(i - LP + 1);
            }
        }

        return res;
    }
}
