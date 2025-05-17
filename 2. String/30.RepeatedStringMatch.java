class Solution30 {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder repeatA= new StringBuilder();
        int count=0;
        while(repeatA.length()<b.length()){
            repeatA.append(a);
            count++;
            if(repeatA.toString().contains(b)) return count;
        }
        repeatA.append(a);
        count++;
        if(repeatA.toString().contains(b)) return count;
        return -1;
    }
}