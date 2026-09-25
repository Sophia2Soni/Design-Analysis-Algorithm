public class FibonacciAnalysis {

    static long recursiveFibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        return recursiveFibonacci(n - 1)
                + recursiveFibonacci(n - 2);
    }

    static long iterativeFibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        long first = 0;
        long second = 1;

        for (int i = 2; i <= n; i++) {

            long next = first + second;

            first = second;
            second = next;
        }

        return second;
    }

    static void testRecursive(int n) {

        Runtime runtime = Runtime.getRuntime();

        System.gc();

        long memoryBefore =
                runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        recursiveFibonacci(n);

        long end = System.nanoTime();

        long memoryAfter =
                runtime.totalMemory() - runtime.freeMemory();

        System.out.println(
                "Recursive | n = " + n +
                " | Time = " + (end - start) + " ns" +
                " | Memory = " +
                (memoryAfter - memoryBefore) + " bytes"
        );
    }

    static void testIterative(int n) {

        Runtime runtime = Runtime.getRuntime();

        System.gc();

        long memoryBefore =
                runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        iterativeFibonacci(n);

        long end = System.nanoTime();

        long memoryAfter =
                runtime.totalMemory() - runtime.freeMemory();

        System.out.println(
                "Iterative | n = " + n +
                " | Time = " + (end - start) + " ns" +
                " | Memory = " +
                (memoryAfter - memoryBefore) + " bytes"
        );
    }

    public static void main(String[] args) {

        int[] values = {10, 20, 25, 30, 35};

        for (int n : values) {

            System.out.println("\nFibonacci n = " + n);

            testRecursive(n);
            testIterative(n);
        }
    }
}
