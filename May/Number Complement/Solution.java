class Solution {
    public int findComplement(int num) {
        int comp = ~num;
        int pow = 0;
        while (Math.pow(2, pow) < num)
            pow++;
        comp = comp & ((int) (Math.pow(2, pow) - 1));
        return comp;
    }
}