public class IterativeFibonacci {

    public static void main(String[] args) {

        int n = 10;

        long first = 0;
        long second = 1;

        System.out.println("Fibonacci Series:");

        for (int i = 0; i < n; i++) {

            System.out.print(first + " ");

            long next = first + second;

            first = second;
            second = next;
        }
    }
}
