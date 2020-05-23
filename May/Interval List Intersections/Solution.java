class Solution {

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        int a = 0;
        int b = 0;
        List<List<Integer>> list = new ArrayList();
        while (a < A.length && b < B.length) {
            List curr = new ArrayList(2);
            int low = Math.max(A[a][0], B[b][0]);
            int high = Math.min(A[a][1], B[b][1]);
            if (low <= high) {
                curr.add(Math.max(A[a][0], B[b][0]));
                curr.add(Math.min(A[a][1], B[b][1]));
                list.add(curr);
            }
            if (B[b][1] > A[a][1])
                a++;
            else if (B[b][1] < A[a][1])
                b++;
            else {
                a++;
                b++;
            }
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < result.length; i++) {
            // System.out.println(list.get(i));
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
        return result;
    }
}