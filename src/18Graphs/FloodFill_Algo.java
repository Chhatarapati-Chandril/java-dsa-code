public class FloodFill_Algo {

    // O(m * n)
    public void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orginalCol) {
        // base case
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length 
            || vis[sr][sc] || image[sr][sc] != orginalCol) {
            return;
        }
        image[sr][sc] = color;
        // left
        helper(image, sr, sc - 1, color, vis, orginalCol);
        // right
        helper(image, sr, sc + 1, color, vis, orginalCol);
        // up
        helper(image, sr - 1, sc, color, vis, orginalCol);
        // down
        helper(image, sr + 1, sc, color, vis, orginalCol);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, color);
        return image;
    }

    public static void main(String[] args) {
        
    }
}
