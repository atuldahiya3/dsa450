import java.util.Stack;

class StockSpanner {
    Stack<int[]> s1;
   
    public StockSpanner() {
        s1=new Stack<>();
    }
    
    public int next(int price) {
        int count=1;
        while(!s1.isEmpty() && s1.peek()[0]<=price){
            count+=s1.pop()[1];
        }
        s1.push(new int[]{price,count});
        return count;
    }
}