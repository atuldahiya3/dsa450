class Solution {
    public ArrayList<String> possibleWords(int[] arr) {
        // code here
        HashMap<Integer, String> map= new HashMap<>();
        ArrayList<String> res= new ArrayList<>();
        if (arr == null || arr.length == 0) return res;
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        map.put(1, "");
        map.put(0, "");
        
        helper(0,arr,new StringBuilder(), map, res);
        return res;
    }
    public void helper(int index, int[] arr, StringBuilder s, HashMap<Integer,String> map, ArrayList<String> res){
        if(index>=arr.length){
            res.add(new String(s));
            return;
        }

        String chars=map.get(arr[index]);
        if (chars.isEmpty()) {
            helper(index + 1, arr, s, map, res);
            return;
        }
        for(char c: chars.toCharArray()){
            s.append(c);
            helper(index+1,arr,s,map,res);
            s.deleteCharAt(s.length()-1);
        }
    }
}