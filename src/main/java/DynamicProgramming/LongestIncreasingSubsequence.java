package DynamicProgramming;

import java.util.Scanner;

/**
 * @author Afrizal Fikri (https://github.com/icalF)
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ar[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
    	//int ar[] = {50, 3, 10, 7, 40, 80};
        System.out.println(LIS(ar));
    	
    	/*int[] ar = {3,10,20,0,0};
    	int l = -1;
    	int r = 3;
    	int key = 11;
    	
    	System.out.println(upperBound(ar, l, r, key));*/
    	
    	
    }

    public static int upperBound(int[] ar, int l, int r, int key) {
        while (l < r - 1) {
            int m = (l + r) / 2;
            if (ar[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    public static int LIS(int[] array) {
        int N = array.length;
        if (N == 0)
            return 0;

        int[] tail = new int[N];

        // always points empty slot in tail
        int length = 1;

        tail[0] = array[0];
        for (int i = 1; i < N; i++) {

            // new smallest value
            if (array[i] < tail[0])
                tail[0] = array[i];

                // array[i] extends largest subsequence
            else if (array[i] > tail[length - 1])
                tail[length++] = array[i];

                // array[i] will become end candidate of an existing subsequence or
                // Throw away larger elements in all LIS, to make room for upcoming grater elements than array[i]
                // (and also, array[i] would have already appeared in one of LIS, identify the location and replace it)
            else
                tail[upperBound(tail, -1, length - 1, array[i])] = array[i];
        }

        return length;
    }
}