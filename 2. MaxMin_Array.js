// } Driver Code Ends


// User function Template for javascript
// User function Template for javascript

/**
 * @param {number[]} arr
 * @param {number} n
 * @returns {number[]}
 */

class Solution {
    getMinMax(arr) {
    let min=arr[0];
    let max=arr[0];
        for(let i=1; i<=arr.length; i++){
            if(arr[i]>max){
                max=arr[i]
            }
            if(arr[i]<min){
                min=arr[i]
            }
        }
        return [min,max]
    }
}