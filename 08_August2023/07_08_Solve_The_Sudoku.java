// Link: https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1
// Time Complexity: O(9^(N*N))
// Space Complexity: O(N*N)

class Solution
{
    //Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][])
    {
        int row, col;
        
        // Find an empty cell in the grid
        int[] emptyCell = findEmptyCell(grid);
        
        // If no empty cell is found, the Sudoku is solved
        if (emptyCell == null)
            return true;
        
        row = emptyCell[0];
        col = emptyCell[1];
        
        // Try placing digits from 1 to 9 in the empty cell
        for (int num = 1; num <= 9; num++)
        {
            if (isValidPlacement(grid, row, col, num))
            {
                // Place the digit if valid
                grid[row][col] = num;
                
                // Recur to solve the rest of the Sudoku
                if (SolveSudoku(grid))
                    return true;
                
                // If placing digit doesn't lead to a solution, backtrack
                grid[row][col] = 0;
            }
        }
        
        // No valid placement found, trigger backtracking
        return false;
    }
    
    //Function to check if a digit can be placed in a given cell.
    static boolean isValidPlacement(int grid[][], int row, int col, int num)
    {
        // Check row and column constraints
        for (int x = 0; x < 9; x++)
        {
            if (grid[row][x] == num || grid[x][col] == num)
                return false;
        }
        
        // Check 3x3 sub-grid constraints
        int subGridRow = row - row % 3;
        int subGridCol = col - col % 3;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (grid[subGridRow + i][subGridCol + j] == num)
                    return false;
            }
        }
        
        return true;
    }
    
    //Function to find an empty cell in the grid.
    static int[] findEmptyCell(int grid[][])
    {
        int N = grid.length;
        int[] emptyCell = new int[2];
        
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (grid[i][j] == 0)
                {
                    emptyCell[0] = i;
                    emptyCell[1] = j;
                    return emptyCell;
                }
            }
        }
        
        // No empty cell found
        return null;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid(int grid[][])
    {
        int N = grid.length;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
