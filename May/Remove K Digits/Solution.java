class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";
        char[] nums = num.toCharArray();
        Stack<Character> stack = new Stack();

        stack.push(nums[0]);
        int i = 1;
        int count = k;
        while (i < nums.length) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && count > 0) {
                stack.pop();
                count--;
            }
            stack.push(nums[i]);
            i++;
        }
        while (count > 0) {
            stack.pop();
            count--;
        }
        if (stack.isEmpty())
            return "0";
        char[] c = new char[nums.length - k];
        i = nums.length - k - 1;
        while (!stack.isEmpty()) {
            c[i] = stack.pop();
            i--;
        }
        i = 0;
        while (i < c.length && c[i] == '0')
            i++;
        if (i == c.length)
            return "0";
        return String.valueOf(c).substring(i);
    }
}
