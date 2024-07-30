// Link: https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
// Time Complexity: O(4^(n^2))
// Space Complexity: O(n^2)

class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> result = new ArrayList<>();
        
        if(mat == null || mat.length == 0 || mat[0][0] == 0){
            return result;
        }
        
        int n = mat.length;
        boolean[][] visited = new boolean[n][n];
        StringBuilder path = new StringBuilder();
        
        //start the dfs from mat[0][0]
        dfs(mat, 0, 0, visited, path, result);
        
        Collections.sort(result);
        return result;
    }
    
    private static void dfs(int[][] mat, int row, int col, boolean[][] visited, StringBuilder path, ArrayList<String> result){
        int n = mat.length;
        
        if(row == n - 1 && col == n - 1){
            result.add(path.toString());
            return;
        }
        
        visited[row][col] = true;
        
        if(isSafe(mat, row + 1, col, visited)){
            path.append('D');
            dfs(mat, row + 1, col, visited, path, result);
            path.deleteCharAt(path.length() - 1); //Bactrack
        }
        
        if(isSafe(mat, row - 1, col, visited)){
            path.append('U');
            dfs(mat, row - 1, col, visited, path, result);
            path.deleteCharAt(path.length() - 1); //Bactrack
        }
        
        if(isSafe(mat, row, col + 1, visited)){
            path.append('R');
            dfs(mat, row, col + 1, visited, path, result);
            path.deleteCharAt(path.length() - 1); //Bactrack
        }
        
         if(isSafe(mat, row, col - 1, visited)){
             path.append('L');
             dfs(mat, row, col - 1, visited, path, result);
             path.deleteCharAt(path.length() - 1); //Bactrack
         }
         
         visited[row][col] = false;
    }
    private static boolean isSafe(int[][] mat, int row, int col, boolean[][] visited){
        int n = mat.length;
        
        return (row >= 0 && row < n && col >= 0 && col < n && mat[row][col] == 1 && !visited[row][col]);
    }
}