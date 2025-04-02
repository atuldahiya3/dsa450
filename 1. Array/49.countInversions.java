class Solution49 {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        int temp[] = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    static int mergeSortAndCount(int arr[], int temp[], int start, int end) {
        int inv_count = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;
            inv_count += mergeSortAndCount(arr, temp, start, mid);
            inv_count += mergeSortAndCount(arr, temp, mid + 1, end);
            inv_count += mergeAndCount(arr, temp, start, mid + 1, end);
        }
        return inv_count;
    }

    static int mergeAndCount(int arr[], int temp[], int start, int mid, int end) {
        int i = start, j = mid, k = start;
        int inv_count = 0;

        while (i <= mid - 1 && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inv_count += (mid - i); // **Fixed inversion count**
            }
        }

        while (i <= mid - 1) temp[k++] = arr[i++];
        while (j <= end) temp[k++] = arr[j++];

        for (i = start; i <= end; i++) arr[i] = temp[i];

        return inv_count;
    }

    public static void main(String args[]) {
        int arr[] = {1, 20, 6, 4, 5};
        System.out.println("Number of inversions: " + inversionCount(arr));
    }
}
