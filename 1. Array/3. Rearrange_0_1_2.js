class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    sort012(arr) {
        let arr2=[]
        for(let i=0;i<arr.length;i++){
            if(arr[i]===0){
                arr2.push(arr[i])
            }
        }
        for(let i=0;i<arr.length;i++){
            if(arr[i]===1){
                arr2.push(arr[i])
            }
        }
        for(let i=0;i<arr.length;i++){
            if(arr[i]===2){
                arr2.push(arr[i])
            }
        }
        for(let i=0;i<arr.length;i++){
            arr[i]=arr2[i]
        }
    }
}