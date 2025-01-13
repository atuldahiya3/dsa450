/**
 * @param {number[]} arr
 * @returns {number[]}
 */

class Solution {
    // Function to reverse the array.
    reverseArray(arr) {
       let a=0;
       let l=arr.length
       for (let i=0; i<l/2 ; i++){
           a=arr[i]
           arr[i]=arr[l-1-i]
           arr[l-1-i]=a
       }
    }
}