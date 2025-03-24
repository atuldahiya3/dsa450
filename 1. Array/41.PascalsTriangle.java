import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution41 {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0) return new ArrayList<>();
        if(numRows==1){
            List<List<Integer>> res= new ArrayList<>();
            res.add(Arrays.asList(1));
            return res;
        }
        List<List<Integer>> prevRows= generate(numRows-1);
        List<Integer> newRow=new ArrayList<>();

        for(int i=0;i<numRows;i++){
            newRow.add(1);
        }
        for(int i=1;i<numRows-1;i++){
            newRow.set(i,prevRows.get(numRows-2).get(i-1)+prevRows.get(numRows-2).get(i));
        }
        prevRows.add(newRow);
        return prevRows;
    }
}