class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        HashMap<Character, String> map= new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        findPairs(digits, 0, new StringBuilder(), map, result );
        return result;
    }
    public static void findPairs(String digits, int index, StringBuilder s, HashMap<Character, String> map, List<String> result ){
        if(index==digits.length()){
            result.add(s.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for(char ch: letters.toCharArray()){
            s.append(ch);
            findPairs(digits, index+1, s, map, result);
            s.deleteCharAt(s.length()-1);
        }
    }
}