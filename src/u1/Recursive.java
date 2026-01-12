package u1;

public class Recursive {
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Fibonacci sequence
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
   }

     public static void imprimirFibonacci(int terminos) {
        for (int i = 1; i <= terminos; i++) {
            System.out.print(fibonacci(i-1) + " ");
        }
    }
  
    public static int forward(int limit) {
        int number = 5, result = 0;
        for (int i = 0; i < limit; i++) {
            result += number;
        }
        return result;
    }

    public static int backward(int limit) { // with recursive de 5 en 5
        int number = 5;
        // Base case
        if (limit <= 1) {
            return number;
        } else {
            return number + backward(limit - 1);
        }
    }

    public static int countUp(int current) {
        if (current > 5) {
            return 0;
        } else {
            System.out.println(current);
            return countUp(current + 1);
        }
    }

    public static int countDown(int current) {
        if (current < 1) {
            return 0;
        } else {
            System.out.println(current);
            return countDown(current - 1);
        }
    }

    static void recurseMethod(int num) {
        if (num == 0)
            return;
        else {
            System.out.println("hello " + num);
            recurseMethod(--num);
            System.out.println("" + num);
            return;
        }
    } 

    public static void main(String[] args) {
        /*
         * int number = 5; // Example input
         * int result = factorial(number);
         * System.out.println("Factorial of " + number + " is: " + result);
         * 
         * int limit = 3; // Example input
         * int forwardResult = forward(limit);
         * System.out.println("Forward  result with limit " + limit + " is: " +
         * forwardResult);
         */
        int limit = 3; // Example input
        int backwardResult = backward(limit);
        System.out.println("Backward result with limit " + limit + " is: " + backwardResult);

        /*
         * System.out.println("Counting to five:");
         * countUp(1);
         * 
         * System.out.println("Counting down from five:");
         * countDown(5);
         */
        System.out.println("Demonstrating recurseMethod:");
        recurseMethod(3);

        imprimirFibonacci(4);  // partiendo de la posicion 1 


    }
}
