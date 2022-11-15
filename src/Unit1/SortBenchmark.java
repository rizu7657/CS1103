package Unit1;

import java.util.Arrays;

import static java.lang.System.in;

/**
 * Sorting benchmark of an array of integers with selection sort or Java's builtin sort method
 *
 * length of array - times to sort (Selection sorting), (Arrays.sort())
 * 1,000 - 4ms, 2ms
 * 10,000 - 65ms, 7ms
 * 100,000 - 4821ms, 66ms
 * 1,000,000 - 478ms
 *
 * @author (retracted for assignment submission)
 */

public class SortBenchmark {
    static int[] A = new int[100000];
    static int[] B = new int[100000];


    public static void main(String[] args) {
        // The array is filled with random values
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) (Integer.MAX_VALUE * Math.random());
        }
        B = A.clone(); // Array A is cloned and assigned to B

        // Test the selection sort algorithm & benchmark a million records with Arrays.sort()
//        testSort();
//        experimentMillionSort();

        // Conduct test of measuring time for sorting to complete
        // Array A with selection sort
        System.out.println("Sorting A with selection sort and length " + A.length);
        long startTime = System.currentTimeMillis();
        selectionSort(A);
        long runTime = System.currentTimeMillis() - startTime;
        System.out.println("Run time: " + runTime);
        if (runTime > 1000) {
            System.out.println("Run time in seconds: " + runTime/1000.0);
        }

        // Array B with Arrays.sort()
        System.out.println("Sorting B with Arrays.sort() and length " + B.length);
        startTime = System.currentTimeMillis();
        Arrays.sort(B);
        runTime = System.currentTimeMillis() - startTime;
        System.out.println("Run time: " + runTime);
    }

    /**
     * A method to test whether the selection sorting algorithm works.
     */
    static void testSort() {
        int[] test = new int[10];

        for (int i = 0; i < test.length; i++) {
            test[i] = (int) (100 * Math.random());
        }

        System.out.println("Unsorted test array: " + Arrays.toString(test));
        selectionSort(test);
        System.out.println("Sorted test array: " + Arrays.toString(test));

    }

    /**
     * The sort method that utilizes the selection sort algorithm.
     *
     * @param A Array of integers to be sorted
     */
    static void selectionSort(int[] A) {
            // Sort A into increasing order, using selection sort

        for (int lastPlace = A.length - 1; lastPlace > 0; lastPlace--) {
                // Find the largest item among A[0], A[1], ...,
                // A[lastPlace], and move it into position lastPlace
                // by swapping it with the number that is currently
                // in position lastPlace.

            int maxLoc = 0; // Location of largest item seen so far.

            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
                        // Since A[j] is bigger than the maximum we’ve seen
                        // so far, j is the new location of the maximum value
                        // we’ve seen so far.

                    maxLoc = j;
                }
            }

            int temp = A[maxLoc]; // Swap largest item with A[lastPlace].
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;
        }
    }

    /**
     * A method to test the benchmark time of sorting an array with a million values using Java's
     * builtin sorting method (Arrays.sort()).
     */
    public static void experimentMillionSort() {
        int[] M = new int[1000000];

        for (int i = 0; i < M.length; i++) {
            M[i] = (int) (Integer.MAX_VALUE * Math.random());
        }

        System.out.println("Sorting M with Arrays.sort() and length " + M.length);
        Long startTime = System.currentTimeMillis();
        Arrays.sort(M);
        Long runTime = System.currentTimeMillis() - startTime;
        System.out.println("Run time: " + runTime);
    }
}
/*
  Test selection sort method's results with int[10] containing random number 0 - 100:
  Unsorted test array: [56, 11, 35, 4, 7, 48, 91, 49, 75, 55]
  Sorted test array: [4, 7, 11, 35, 48, 49, 55, 56, 75, 91]
 */