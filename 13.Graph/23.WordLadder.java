class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set= new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q= new LinkedList<>();
        q.offer(beginWord);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int i=0;i<size;i++){
                String curr= q.poll();
                char[] currArray=curr.toCharArray();
                for(int j=0;j<currArray.length;j++){
                    char orignal=currArray[j];
                    for(char temp='a';temp<='z';temp++){
                        currArray[j]=temp;
                        String newWord= new String(currArray);
                        if(endWord.equals(newWord)) return level+1;
                        if(set.contains(newWord)){
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    currArray[j]=orignal;
                }
            }
            level++;
        }
        return 0;
    }
}