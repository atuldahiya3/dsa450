class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if (i > 0 && arr[i] == arr[i - 1]) continue; 
            for(int j=i+1;j<n-2;j++){
                if (j > i + 1 && arr[j] == arr[j - 1]) continue; 
                int p=j+1, q=n-1;
                while(p<q){
                    ArrayList<Integer> temp= new ArrayList<>();
                    long sum = (long)arr[i] + arr[j] + arr[p] + arr[q];
                    if(sum==target){
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[p]);
                        temp.add(arr[q]);
                        res.add(temp);
                        while (p < q && arr[p] == arr[p + 1]) p++;
                        while (p < q && arr[q] == arr[q - 1]) q--;
                        p++;
                        q--;
                    }else if(sum<target){
                        p++;
                    }else{
                        q--;
                    }
                }
            }
        }
        return res;
    }
}