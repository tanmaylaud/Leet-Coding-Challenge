class Solution {
    public int singleNumber(int[] nums) {
        int solo = 0;
        for (int i = 0; i < nums.length; i++) {
            solo = solo ^ nums[i];
        }

        return solo;
    }
}