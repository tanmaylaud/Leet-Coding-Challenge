class Solution {
    int[] initial = { 0, 1 };
    int[] zero = { 0 };

    public int[] countBits(int num) {
        if (num == 0)
            return zero;
        if (num == 1)
            return initial;
        int[] arr = new int[num + 1];
        arr[0] = 0;
        arr[1] = 1;
        int power = 2;
        int curr = power;
        for (int i = 2; i <= num; i++) {
            if (i == power) {
                curr = power;
                power = power * 2;
            }
            arr[i] = arr[i - curr] + 1;
        }
        return arr;
    }
}