import java.util.*;

public class ExperimentalAnalysis {

    static int[] generateSorted(int n) {

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        return arr;
    }

    static int[] generateReverse(int n) {

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }

        return arr;
    }

    static int[] generateRandom(int n) {

        int[] arr = new int[n];

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }

        return arr;
    }

    static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

    static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];

            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }

    static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {

                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void testAlgorithm(String algorithm, int[] original) {

        int[] arr = Arrays.copyOf(original, original.length);

        Runtime runtime = Runtime.getRuntime();

        System.gc();

        long memoryBefore =
                runtime.totalMemory() - runtime.freeMemory();

        long startTime = System.nanoTime();

        switch (algorithm) {

            case "Bubble Sort":
                bubbleSort(arr);
                break;

            case "Selection Sort":
                selectionSort(arr);
                break;

            case "Insertion Sort":
                insertionSort(arr);
                break;

            case "Merge Sort":
                mergeSort(arr, 0, arr.length - 1);
                break;

            case "Quick Sort":
                quickSort(arr, 0, arr.length - 1);
                break;
        }

        long endTime = System.nanoTime();

        long memoryAfter =
                runtime.totalMemory() - runtime.freeMemory();

        long executionTime = endTime - startTime;

        long memoryUsed = memoryAfter - memoryBefore;

        System.out.println(
                algorithm +
                " | Time: " + executionTime + " ns" +
                " | Memory: " + memoryUsed + " bytes"
        );
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000, 20000};

        String[] algorithms = {
                "Bubble Sort",
                "Selection Sort",
                "Insertion Sort",
                "Merge Sort",
                "Quick Sort"
        };

        for (int size : sizes) {

            System.out.println("\n==============================");
            System.out.println("INPUT SIZE: " + size);
            System.out.println("==============================");

            int[] sorted = generateSorted(size);
            int[] reverse = generateReverse(size);
            int[] random = generateRandom(size);

            System.out.println("\n--- SORTED DATA ---");

            for (String algorithm : algorithms) {
                testAlgorithm(algorithm, sorted);
            }

            System.out.println("\n--- REVERSE SORTED DATA ---");

            for (String algorithm : algorithms) {
                testAlgorithm(algorithm, reverse);
            }

            System.out.println("\n--- RANDOM DATA ---");

            for (String algorithm : algorithms) {
                testAlgorithm(algorithm, random);
            }
        }
    }
}
