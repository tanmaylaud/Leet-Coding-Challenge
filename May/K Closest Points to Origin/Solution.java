class Solution {

    public class Pair implements Comparable<Pair> {
        int distance;
        int index;

        public Pair(int d, int index) {
            this.distance = d;
            this.index = index;
        }

        public int compareTo(Pair o) {
            return this.distance - o.distance;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        if (K == points.length)
            return points;
        int[][] result = new int[K][2];
        if (K == 0)
            return result;
        // Sorted map with key = Distance from Origin and value=Index in array
        List<Pair> list = new ArrayList();
        int distance = 0;
        for (int i = 0; i < points.length; i++) {
            distance = (int) Math.pow(points[i][0], 2) + (int) Math.pow(points[i][1], 2);
            list.add(new Pair(distance, i));
        }
        Collections.sort(list);
        for (int i = 0; i < K; i++) {
            int index = list.get(i).index;
            result[i][0] = points[index][0];
            result[i][1] = points[index][1];
        }
        return result;
    }
}