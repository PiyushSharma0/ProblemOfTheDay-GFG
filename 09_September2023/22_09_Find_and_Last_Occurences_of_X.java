import java.util.ArrayList;

class GFG
{
    // This function finds the first occurrence of element x in the sorted array arr
    private int findFirstOccurrence(int arr[], int n, int x)
    {
        int low = 0, high = n - 1, first = -1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2; // Calculate the middle index
            
            if (arr[mid] == x)
            {
                first = mid; // Update the first occurrence
                high = mid - 1; // Continue searching in the left half
            }
            else if (arr[mid] < x)
            {
                low = mid + 1; // If x is greater, search in the right half
            }
            else
            {
                high = mid - 1; // If x is smaller, search in the left half
            }
        }
        return first; // Return the index of the first occurrence (or -1 if not found)
    }
    
    // This function finds the last occurrence of element x in the sorted array arr
    private int findLastOccurrence(int arr[], int n, int x)
    {
        int low = 0, high = n - 1, last = -1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2; // Calculate the middle index
            
            if (arr[mid] == x)
            {
                last = mid; // Update the last occurrence
                low = mid + 1; // Continue searching in the right half
            }
            else if (arr[mid] < x)
            {
                low = mid + 1; // If x is greater, search in the right half
            }
            else
            {
                high = mid - 1; // If x is smaller, search in the left half
            }
        }
        return last; // Return the index of the last occurrence (or -1 if not found)
    }
    
    // This is the main function to find the first and last occurrences of element x
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Find the first occurrence of x
        int firstOccurrence = findFirstOccurrence(arr, n, x);
        
        // Find the last occurrence of x
        int lastOccurrence = findLastOccurrence(arr, n, x);
        
        // Add the results to the ArrayList
        result.add(firstOccurrence);
        result.add(lastOccurrence);
        
        return result; // Return the ArrayList containing the results
    }
}
