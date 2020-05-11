class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (image[sr][sc] == newColor)
            return image;
        ff(image, sr, sc, newColor, oldColor);
        return image;
    }

    public void ff(int[][] image, int r, int c, int newColor, int oldColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != oldColor)
            return;

        image[r][c] = newColor;
        ff(image, r + 1, c, newColor, oldColor);
        ff(image, r - 1, c, newColor, oldColor);
        ff(image, r, c + 1, newColor, oldColor);
        ff(image, r, c - 1, newColor, oldColor);
    }
}