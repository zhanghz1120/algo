package search;

public class _01_binary_search {
    int binary_search(int[] A, int left, int right, int target)
    {
        if(left > right)
        {
            return -1;
        }
        int mid = (left + right) / 2;

        if(target < A[mid])
        {
            return binary_search(A, left, mid-1, target);
        }
        if(target > A[mid])
        {
            return binary_search(A, mid+1, right, target);
        }
        return mid;
    }

}
