// Problem statement
// Given the 'start' and the 'end'' positions of the array 'input'. Your task is to sort the elements between 'start' and 'end' using quick sort.



// Note :
// Make changes in the input array itself.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1 :
// 6 
// 2 6 8 5 4 3
// Sample Output 1 :
// 2 3 4 5 6 8
// Sample Input 2 :
// 5
// 1 2 3 5 7
// Sample Output 2 :
// 1 2 3 5 7 
// Constraints :
// 1 <= N <= 10^3
// 0 <= input[i] <= 10^9

public class Solution {

    public static void quickSort(int[] input, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int pivot = input[endIndex];
            int i = startIndex - 1;

            for (int j = startIndex; j < endIndex; j++) {
                if (input[j] <= pivot) {
                    i++;
                    swap(input, i, j);
                }
            }

            swap(input, i + 1, endIndex);
            quickSort(input, startIndex, i);
            quickSort(input, i + 2, endIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
		
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
