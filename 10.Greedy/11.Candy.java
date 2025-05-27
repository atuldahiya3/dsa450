import java.util.Arrays;

class Solution11 {
    public int candy(int[] ratings) {
        int count=0;
        int n=ratings.length;
        int[] candies= new int[n];
        Arrays.fill(candies,1);
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
        }
        for(int item:candies){
            count+=item;
        }
        return count;
    }
}