import java.util.ArrayList;
import java.util.Arrays;

class Solution100 {
    
    static class Pairs{
            int deadline;
            int profit;
            Pairs(int deadline, int profit){
                this.deadline=deadline;
                this.profit=profit;
            }
        }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n=deadline.length;
        Pairs[] dp= new Pairs[n];
        for(int i=0;i<n;i++){
            dp[i]= new Pairs(deadline[i],profit[i]);
        }
        Arrays.sort(dp, (a,b)-> (b.profit-a.profit));
        int maxDeadline=0;
        for(Pairs job:dp){
            maxDeadline=Math.max(maxDeadline,job.deadline);
        }
        int maxJobs=0, maxProfit=0;
        boolean[] slot= new boolean[maxDeadline+1];
        for(Pairs job:dp){
            for(int j=job.deadline;j>0;j--){
                if(!slot[j]){
                    slot[j]=true;
                    maxJobs++;
                    maxProfit+=job.profit;
                    break;
                }
            }
        }
        ArrayList<Integer> res= new ArrayList<>();
        res.add(maxJobs);
        res.add(maxProfit);
        return res;
    }
}