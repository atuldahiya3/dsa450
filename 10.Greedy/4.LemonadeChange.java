class Solution3333 {
    public boolean lemonadeChange(int[] bills) {
        int count10=0, count5=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) count5++;
            if(bills[i]==10){
                if(count5<=0) return false;
                count10++;
                count5--;
            }
            if(bills[i]==20){
                if(count5<=0) return false;
                if(count10<=0 && count5<3) return false;
                if(count10<=0){
                    count5-=3;
                }else{
                    count10--;
                    count5--;
                }
                
            }
        }
        return true;
    }
}