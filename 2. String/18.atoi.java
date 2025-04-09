class Solution18 {
    public int myAtoi(String s) {
        long result=0;
        boolean positive=true;
        int i=0;
        int count=0;
        while(i<s.length()){
            if(s.charAt(i)==' ') {
                if(count>0){
                    if(!positive){
                        return (int)(-result);
                    }
                    return (int)result;
                }
                i++;
                continue;
            }
            if(s.charAt(i)=='-'){
                if(count>0){
                    if(!positive){
                        return (int)(-result);
                    }
                    return (int)result;
                }
                count++;
                positive=false;
            }else if(s.charAt(i)=='+'){
                if(count>0){
                    if(!positive){
                        return (int)(-result);
                    }
                    return (int)result;
                }
                count++;
                 positive=true;
            }else if(s.charAt(i)=='.'){
                    if(!positive){
                        return (int)(-result);
                    }
                    return (int)result;
                // if(count>0){
                // }
                //  positive=true;
            }
            else if(Character.isLetter(s.charAt(i))){
                if(!positive){
                    return (int)(-result);
                }
                return (int)result;
            }else if(Character.isDigit(s.charAt(i))){
                result = result * 10 + (s.charAt(i) - '0');
                if(result>Integer.MAX_VALUE && positive) return Integer.MAX_VALUE;
                if((-result)<Integer.MIN_VALUE && !positive) return Integer.MIN_VALUE;
                count++;
            }
            i++;
        }
        if(!positive){
            return (int)(-result);
        }
        return (int)result;
    }
    
}