package Practice;

public class Factorial {

    public static void main(String[] args) {
        int number = 5; // Example number 
        int result = factorial(number); 
                System.out.println("Factorial of " + number + " is: " + result);
            }
        
        private static int factorial(int number) {
            if (number == 0) {
                return 1;
            }
            System.out.println(number);
            number = number * factorial(number - 1);
            return number;
        }

}
