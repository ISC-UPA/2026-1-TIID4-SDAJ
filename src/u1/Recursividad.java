package u1;

public class Recursividad {

    public static int factorial(int n) { // 1*2*3*...*n
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }  

    public static int factorialR(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorialR(n - 1);
        }
    }

    public static void contadorDescendente(int n) {
        for (int i = n; i>=0; i--) {
            System.out.println(i);
        }
        System.out.println("Booom");
    }

    public static void contadorDescendenteR(int n) { //recursive
        if (n < 0) { //base case
            System.out.println("Booom");
        } else {
            System.out.println(n);
            contadorDescendenteR(n - 1); //recursive case

        } 
    }


    public static int factor(int limit) {
        int number = 5, result = 0;
        for (int i = 0; i < limit; i++) {
            result += number;
        }
        return result;
    }
 /*
    // Tabla de multiplicar(5)
    5*10= 50
    5*9 = 45
    . . .
    5*1 = 5
  
    
    5*1 = 5
    5*2 =10
    . . .
    5*10 =50
*/
 


    

    public static void main(String[] args) {
        int r = factorialR(4);
        System.out.println(r);
        contadorDescendenteR(5);

    }
}
