package Module2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// Inventory Management System
	public static ArrayList<Product> products = new ArrayList<Product>();

	public static void main(String[] args) {
		char option = 'q';

		do {

			System.out.println("Welcome!");
			System.out.println("To Add Product - Press 'A' and click 'ENTER'");
			// System.out.println("Enter S to search Products");
			System.out.println("To Display Product(s) - Press 'D' and click 'ENTER'");
			System.out.println("To Quit - Press 'Q' and click 'ENTER'");
			System.out.println("===========================");

			// get input from user
			Scanner kb = new Scanner(System.in);
			option = kb.next().charAt(0); // get 1 char input from keyboard

			// user to insert product name, qty, and price
			if (option == 'A' || option == 'a') {
				System.out.println("To Add Product:\nPlease enter a product name: ");
				String productName = kb.next();
				System.out.println("To Add Product:\nPlease enter a product quantity: ");
				int productQty = kb.nextInt();
				System.out.println("To Add Product:\nPlease enter a product price: ");
				double productPrice = kb.nextDouble();
				AddProduct(productName, productQty, productPrice);

				/*
				 * System.out.print("Quantity: "); int quantity = kb.nextInt();
				 * GetProductQty(quantity);
				 */

				/*
				 * System.out.print("Price (per item): "); double price = kb.nextDouble();
				 */
			}

			if (option == 'D' || option == 'd') {
				System.out.println("Displaying all products in the DB");
				DisplayProducts();
			}

			if (option == 'Q' || option == 'q') {
				System.out.println("Thank you for using the Inventory Management System");
			}

		} while (option != 'q');

	}

	// add products
	public static void AddProduct(String name, int qty, double price) {
		Product p = new Product(name, qty, price);
		products.add(p); // add to the static db
	}

	// search db using a name
	public static Product GetProduct(String name) {
		for (Product product : products) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}

	// getProductQTY
	public static int GetProductQty(int quantity) {
		int total = 0;
		for (Product product : products) {
			if (product.getName().equals(quantity)) {
				total++;
			}
		}
		return total;
	}

	// displayFormat
	public static void displayFormat() {
		System.out.print("\nName      Quantity    Price\n");
	}

	// display all products
	public static void DisplayProducts() {
		displayFormat();

		for (Product product : products) {
			System.out.format("%-9s %8d %10.2f\n", product.getName(), product.getQty(), product.getPrice());
			// System.out.println(product.getName());
			// System.out.println(product.getQty());
			// System.out.println(product.getPrice());
		}
	}

}