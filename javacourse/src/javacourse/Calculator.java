package javacourse;
import java.util.*;
public class Calculator 
{
	public static void main(String [] args) 
	{
		int choice;
		String continu;
		double num1, num2;
		Scanner inp = new Scanner(System.in);	// to read input
		
		while(true) {
			
			System.out.println("\nSelect operation\n1. add\n2. subtract\n3. multiply\n4. divide");
			System.out.println("Enter choice(1, 2, 3, 4): ");
			choice = inp.nextInt();
			
			System.out.println("Enter first number: ");
			num1 = inp.nextDouble();
			System.out.println("Enter second number: ");
			num2 = inp.nextDouble();
			
			if (choice == 1)
				System.out.println(num1+" + "+num2+" = "+ add(num1,num2));
			else if (choice == 2)
				System.out.println(num1+" - "+num2+" = "+ subtract(num1,num2));
			else if (choice == 3)
				System.out.println(num1+" * "+num2+" = "+ multiply(num1,num2));
			else if (choice == 4)
				System.out.println(num1+" / "+num2+" = "+ divide(num1,num2));
			else
				System.out.println("Invalid operation!");
				
			System.out.println ("\nContinue? y/n ");
			continu = inp.next();
			if (continu.equals("n"))
				break;
		}
	}
	public static double add(double n1, double n2) {
		return n1 + n2;
	}
	public static double subtract(double n1, double n2) {
		return n1 - n2;
	}
	public static double multiply(double n1, double n2) {
		return n1 * n2;
	}
	public static double divide(double n1, double n2) {
		if (n2 == 0) return 0;
		else return n1 / n2;
	}
}
