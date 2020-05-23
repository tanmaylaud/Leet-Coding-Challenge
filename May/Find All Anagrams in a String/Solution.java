class Solution {
    int MAX = 26;

    boolean compare(int arr1[], int arr2[]) {
        for (int i = 0; i < MAX; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        if (s.length() == 0 || s.length() < p.length())
            return result;
        int M = p.length();
        int N = s.length();

        // countP[]: Store count of all
        // characters of pattern
        // countTW[]: Store count of current
        // window of text
        int[] countP = new int[MAX];
        int[] countTW = new int[MAX];
        for (int i = 0; i < M; i++) {
            (countP[p.charAt(i) - 'a'])++;
            (countTW[s.charAt(i) - 'a'])++;
        }

        // Traverse through remaining characters
        // of pattern
        for (int i = M; i < N; i++) {
            // Compare counts of current window
            // of text with counts of pattern[]
            if (compare(countP, countTW))
                result.add(i - M);

            // Add current character to current
            // window
            (countTW[s.charAt(i) - 'a'])++;

            // Remove the first character of previous
            // window
            countTW[s.charAt(i - M) - 'a']--;
        }

        // Check for the last window in text
        if (compare(countP, countTW))
            result.add(N - M);

        return result;
    }
}