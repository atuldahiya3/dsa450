class TimeMap {
    public static class Pair{
        int timeStamp;
        String value;
        Pair(int t, String v){
            this.timeStamp=t;
            this.value=v;
        }
    }
    private Map<String, List<Pair>> map;
    public TimeMap() {
        map= new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> list= map.get(key);

        int l=0, r=list.size()-1;
        String res="";
        while(l<=r){
            int mid=(l+r)/2;
            if(list.get(mid).timeStamp<=timestamp){
                res=list.get(mid).value;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
    return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */