import java.util.Properties;
import java.util.Scanner;

public class Test {
	
	
	public static void main(String[] args) {
		int r,sum = 0, temp;
		int n = 122;

		temp = n;
		while (n > 0) {
			r = n % 10;
			sum = (sum*10) + r;
			n = n/10;
			System.out.println(r);
			System.out.println(sum);
			
		}
		if (temp == sum)
            System.out.println(temp + " is a palindrome number.");
        else
            System.out.println(temp + " is not a palindrome number.");
	}

}