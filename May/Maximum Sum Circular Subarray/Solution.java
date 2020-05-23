class Solution {
    public int maxSubarraySumCircular(int[] a) {
        int n = a.length;

        // Case 1: get the maximum sum using standard kadane'

        // s algorithm

        int max_kadane = kadane(a);

        // Case 2: Now find the maximum sum that includes

        // corner elements.

        int max_wrap = 0;

        for (int i = 0; i < n; i++)

        {

            max_wrap += a[i]; // Calculate array-sum

            a[i] = -a[i]; // invert the array (change sign)

        }

        // max sum with corner elements will be:

        // array-sum - (-max subarray sum of inverted array)
        int temp = kadane(a);
        if (max_wrap == -temp)
            return max_kadane;

        max_wrap = max_wrap + temp;

        // The maximum circular sum will be maximum of two sums

        return (max_wrap > max_kadane) ? max_wrap : max_kadane;

    }

    static int kadane(int a[])

    {

        int max_so_far = a[0];

        int curr_max = a[0];

        for (int i = 1; i < a.length; i++)

        {

            curr_max = Math.max(a[i], curr_max + a[i]);

            max_so_far = Math.max(max_so_far, curr_max);

        }

        return max_so_far;

    }

}