public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res= new ArrayList<>();
        int n=words.length;
        for(int t=0;t<n;t++){
            String top=words[t];
            for(int l=0;l<n;l++){
                String left=words[l];
                if(top.charAt(0)!=left.charAt(0) || l==t) continue;
                for(int r=0;r<n;r++){
                    String right=words[r];
                    if(top.charAt(3)!=right.charAt(0) || t==r || r==l) continue;
                    for(int b=0;b<n;b++){
                        String bottom=words[b];
                        if(b==l || b==r || b==t) continue;
                        if(bottom.charAt(0)==left.charAt(3) && bottom.charAt(3)==right.charAt(3)){
                            List<String> list= new ArrayList<>();
                            list.add(top);
                            list.add(left);
                            list.add(right);
                            list.add(bottom);
                            res.add(list);
                        }
                    }
                }
            }
        }
        Collections.sort(res, new Comparator<List<String>>(){
            @Override
            public int compare(List<String> a, List<String> b){
                if(a.get(0).compareTo(b.get(0)) != 0) return a.get(0).compareTo(b.get(0));
                if(a.get(1).compareTo(b.get(1)) != 0) return a.get(1).compareTo(b.get(1));
                if(a.get(2).compareTo(b.get(2)) != 0) return a.get(2).compareTo(b.get(2));
                return a.get(3).compareTo(b.get(3));
            }
        });

        return res;
    }
} {
    
}
