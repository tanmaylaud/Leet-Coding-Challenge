class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length == 0)
            return 0;
        int lcs = 0;
        int sum = 0;
        int maxLcs = 0;
        int i = 0;
        HashMap<Integer, Integer> map = new HashMap();

        while (i < nums.length) {

            if (nums[i] == 0)
                sum += -1;
            else
                sum += 1;

            if (sum == 0) {
                lcs = i + 1;
            }

            else if (map.containsKey(sum)) {
                lcs = i - map.get(sum);
            } else
                map.put(sum, i);

            if (lcs > maxLcs)
                maxLcs = lcs;

            i++;
        }

        return maxLcs;
    }

}