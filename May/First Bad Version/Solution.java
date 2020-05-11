/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        Long nLong = new Long(n);
        return (int) firstBadVersion(1, nLong);
    }

    public long firstBadVersion(long n1, long n2) {
        if (n1 == n2)
            return n1;
        long middle = (n1 + n2) / 2;

        if (isBadVersion((int) middle)) {
            return firstBadVersion(n1, middle);
        } else {
            return firstBadVersion(middle + 1, n2);
        }
    }
}