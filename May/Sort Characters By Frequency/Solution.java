class Solution {
    class Pair {
        private char c;
        public int count;

        public Pair(int count, char c) {
            this.c = c;
            this.count = count;
        }

    }

    public String frequencySort(String s) {
        Pair[] list = new Pair[110];
        char[] arr = s.toCharArray();
        int length = arr.length;
        for (char c : arr) {
            if (list[c - ' '] == null)
                list[c - ' '] = new Pair(1, c);
            else
                list[c - ' '].count += 1;
        }
        Arrays.sort(list, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if (p1 == null && p2 != null)
                    return 1;
                else if (p2 == null && p1 != null)
                    return -1;
                else if (p1 == null && p2 == null)
                    return 0;
                return p2.count - p1.count;
            }
        });

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (list[i] != null) {
            Pair p = list[i];
            for (int j = 0; j < p.count; j++)
                sb.append(p.c);

            i++;
        }
        return sb.toString();

    }
}