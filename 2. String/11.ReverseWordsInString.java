import java.util.ArrayList;

class Solution11 {
    public String reverseWords(String s) {
        StringBuilder res= new StringBuilder();
        StringBuilder word= new StringBuilder();
        ArrayList<String> arr=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                word.append(s.charAt(i));
            }else{
                if (word.length() > 0) {
                    arr.add(word.toString());
                    word.setLength(0);
                }
            }
        }
        if (word.length() > 0) {
            arr.add(word.toString());
        }

        for (int i = arr.size() - 1; i >= 0; i--) {
            res.append(arr.get(i));
            if (i != 0) res.append(" ");
        }
        return res.toString();
    }
}