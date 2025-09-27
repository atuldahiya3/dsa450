import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        String[] newStrs= new String[n];
        HashMap<String, List<String>> map= new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            newStrs[i] = new String(chars);   // proper string from sorted chars
            map.putIfAbsent(newStrs[i], new ArrayList<>());  // create list if key not present
            map.get(newStrs[i]).add(strs[i]);                // add element to the list
        }
        List<List<String>> res= new ArrayList<>();
        for(List<String> val : map.values()){
            res.add(val);
        }
        return res;
    }
}