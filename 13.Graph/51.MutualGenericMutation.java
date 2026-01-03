public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet= new HashSet<>(Arrays.asList(bank));
        int count=0;
        if(!bankSet.contains(endGene)) return -1;
        Queue<String> q=new LinkedList<>();
        q.offer(startGene);
        char[] possibles={'A','C','G','T'};
        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                String curr=q.poll();
                char[] currWordArray= curr.toCharArray();
                for(int j=0;j<currWordArray.length;j++){
                    char orignal=currWordArray[j];
                    for(int temp=0;temp<possibles.length;temp++){
                        currWordArray[j]=possibles[temp];
                        String tempStr= new String(currWordArray);
                        if(tempStr.equals(endGene)) return count+1;
                        if(bankSet.contains(tempStr)){
                            q.offer(tempStr);
                            bankSet.remove(tempStr);
                        }
                    }
                    currWordArray[j]=orignal;
                }
            }
            count++;
        }
        return -1;
    }
} {
    
}
