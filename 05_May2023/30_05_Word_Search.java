<<<<<<< HEAD
// Link: https://practice.geeksforgeeks.org/problems/word-search/0/?track=Java-Collections-ArrayList&batchId=318#
// Time complexity: O(R * C * 4^L) where R = number of rows, C = number of columns, L = length of the word
// Space complexity: O(R * C) for the visited matrix and the recursive stack

public boolean isWordExist(char[][] board, String word) {
    if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
        return false;
    }

    int rows = board.length;
    int cols = board[0].length;
    boolean[][] visited = new boolean[rows][cols]; // Matrix to track visited cells

    // Iterate through each cell on the board
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (board[i][j] == word.charAt(0)) {
                if (dfs(board, word, i, j, visited, 0)) {
                    return true; // Word found
                }
            }
        }
    }

    return false; // Word not found
}

private boolean dfs(char[][] board, String word, int row, int col, boolean[][] visited, int index) {
    if (index == word.length()) {
        return true; // All characters in the word have been matched
    }

    // Check if the current cell is out of bounds, has been visited, or does not match the character at the current index
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
        return false;
    }

    visited[row][col] = true; // Mark the current cell as visited

    // Recursively check the neighboring cells for the next character in the word
    boolean found =
        dfs(board, word, row - 1, col, visited, index + 1) || // Up
        dfs(board, word, row + 1, col, visited, index + 1) || // Down
        dfs(board, word, row, col - 1, visited, index + 1) || // Left
        dfs(board, word, row, col + 1, visited, index + 1); // Right

    visited[row][col] = false; // Mark the current cell as unvisited (backtracking)

    return found;
} {
    
}
=======
// Link: https://practice.geeksforgeeks.org/problems/word-search/0/?track=Java-Collections-ArrayList&batchId=318#
// Time complexity: O(R * C * 4^L) where R = number of rows, C = number of columns, L = length of the word
// Space complexity: O(R * C) for the visited matrix and the recursive stack

public boolean isWordExist(char[][] board, String word) {
    if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
        return false;
    }

    int rows = board.length;
    int cols = board[0].length;
    boolean[][] visited = new boolean[rows][cols]; // Matrix to track visited cells

    // Iterate through each cell on the board
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (board[i][j] == word.charAt(0)) {
                if (dfs(board, word, i, j, visited, 0)) {
                    return true; // Word found
                }
            }
        }
    }

    return false; // Word not found
}

private boolean dfs(char[][] board, String word, int row, int col, boolean[][] visited, int index) {
    if (index == word.length()) {
        return true; // All characters in the word have been matched
    }

    // Check if the current cell is out of bounds, has been visited, or does not match the character at the current index
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
        return false;
    }

    visited[row][col] = true; // Mark the current cell as visited

    // Recursively check the neighboring cells for the next character in the word
    boolean found =
        dfs(board, word, row - 1, col, visited, index + 1) || // Up
        dfs(board, word, row + 1, col, visited, index + 1) || // Down
        dfs(board, word, row, col - 1, visited, index + 1) || // Left
        dfs(board, word, row, col + 1, visited, index + 1); // Right

    visited[row][col] = false; // Mark the current cell as unvisited (backtracking)

    return found;
} {
    
}
>>>>>>> 180277b61981e5710a02aeb4d4ca58318af8dff5
