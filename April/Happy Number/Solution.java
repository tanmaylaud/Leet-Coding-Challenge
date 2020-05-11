class Solution {

    public boolean isHappy(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;

        int fastSum = sumOfSquares(sumOfSquares(n));
        int slowSum = sumOfSquares(n);
        do {
            fastSum = sumOfSquares(sumOfSquares(fastSum));
            slowSum = sumOfSquares(slowSum);
            if (slowSum == 1 || fastSum == 1)
                return true;

        } while (slowSum != fastSum);

        return false;

    }

    public int sumOfSquares(int n) {
        int temp = n;
        int sum = 0;
        while (temp != 0) {
            sum += (temp % 10) * (temp % 10);
            temp = temp / 10;
        }
        return sum;
    }
}