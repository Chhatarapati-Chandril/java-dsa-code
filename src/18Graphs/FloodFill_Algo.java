public class FloodFill_Algo {

    // O(m * n)
    public void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int originalCol) {
        if(sc < 0 || sr < 0 || sr>= image.length || sc >= image[0].length) {
            return;
        }
        if(vis[sr][sc] || image[sr][sc] != originalCol) {
            return;
        }

        vis[sr][sc] = true;

        image[sr][sc] = color;
        
        // left
        helper(image, sr, sc - 1, color, vis, originalCol);
        // right
        helper(image, sr, sc + 1, color, vis, originalCol);
        // top
        helper(image, sr - 1, sc, color, vis, originalCol);
        // bottom
        helper(image, sr + 1, sc, color, vis, originalCol);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        int originalCol = image[sr][sc];
        helper(image, sr, sc, color, vis, originalCol);
        return image;
    }

    public static void main(String[] args) {
        
    }
}
