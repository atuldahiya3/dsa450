import java.util.HashMap;

class Solution17 {
    public int romanToInt(String s) {
        HashMap<Character,Integer> data=new HashMap<>();
        data.put('I',1);
        data.put('V',5);
        data.put('X',10);
        data.put('L',50);
        data.put('C',100);
        data.put('D',500);
        data.put('M',1000);
        int count=0;
        for(int i=0;i<s.length()-1;i++){
            if(data.get(s.charAt(i))<data.get(s.charAt(i+1))){
                count-=data.get(s.charAt(i));
            }else{
                count+=data.get(s.charAt(i));
            }
        }
        count+=data.get(s.charAt(s.length()-1));
        return count;
   }
}