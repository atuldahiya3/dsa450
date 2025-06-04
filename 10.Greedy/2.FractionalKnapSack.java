import java.util.Arrays;

class Solution2 {
    static class Item{
        int weight, value;
        Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        }
    }
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        int n=values.length;
        Item[] items= new Item[n];
        for(int i=0;i<n;i++){
            items[i]=new Item(values[i],weights[i]);
        }
        Arrays.sort(items, (a,b)-> Double.compare((double)b.value/b.weight, (double)a.value/a.weight));
        double res=0.0;
        int i=0;
        while(W>0 && i<n){
            if(W>=items[i].weight){
                res+=items[i].value;
                W-=items[i].weight;
            }else{
                res+=((double)items[i].value/items[i].weight)*W;
                break;
            }
            i++;
        }
        return res;
    }
}