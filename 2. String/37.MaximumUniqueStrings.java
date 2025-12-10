
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxDistinct(String s) {
        Set<Character> set= new HashSet<>();
        for(char c: s.toCharArray()){
            set.add(c);
        }
        return set.size();
    }
}