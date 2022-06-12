package Module5;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
import java.sql.*;
import Module4.Logging;

public class Main {

	/* static Logger logger = Logger. */

	// Inventory Management System
	public static ArrayList<Product> products = new ArrayList<Product>();

	public static void main(String[] args) throws SQLException {
		char option = 'q';

		do {

			System.out.println("Welcome to the Cosmetic Store Inventory Management System!");
			System.out.println();
			System.out.println("========================================");
			System.out.println();
			System.out.println("\u2022 To Add Product - Press 'A' and click 'ENTER'");
			System.out.println();
			// System.out.println("Enter S to search Products");
			System.out.println("\u2022 To Display Product(s) - Press 'D' and click 'ENTER'");
			System.out.println();
			System.out.println("\u2022 To Quit - Press 'Q' and click 'ENTER'");
			System.out.println();
			System.out.println("========================================");
			System.out.println();

			// get input from user
			Scanner kb = new Scanner(System.in);
			option = kb.next().charAt(0); // get 1 char input from keyboard

			// user to insert product name, qty, and price
			if (option == 'A' || option == 'a') {
				System.out.println("Add Product to the database");
				System.out.println();
				System.out.println("----------------------------------------");
				System.out.println();
				System.out.println("Enter product name:");
				String productName = kb.next(); // get a strong input from user

				System.out.println("Enter product quantity:");
				int productQty = kb.nextInt(); // get an int input from user

				System.out.println("Enter product price:");
				double productPrice = kb.nextDouble(); // get decimal input from user
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
				getAllProducts(); // DisplayProducts();
			}
			
			if (option == 'R' || option == 'r') {
				System.out.println("Remove product by ID");
				deleteProduct(4); // DeletesProduct
			}

			if (option == 'Q' || option == 'q') {
				System.out.println("Thank you for using the Inventory Management System");
			}

		} while (option != 'q');

	}

	// 1. add products
	public static void AddProduct(String name, int qty, double price) throws SQLException {
		Product p = new Product(name, qty, price);
		products.add(p); // add to the static db

		// insert or add the product
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/walmart", "root", "root");
		PreparedStatement sql = conn.prepareStatement("insert into products(name, qty, cost) values(?,?,?)");
		sql.setString(1, name);
		sql.setInt(2, qty);
		sql.setDouble(3, price);

		sql.executeUpdate();

		// 2. get the product ID after insert
		Statement sqlST = conn.createStatement();
		ResultSet rs = sqlST.executeQuery("select * from products where name ='" + name + "'");
		System.out.println();
		System.out.println("Product added succesfully to the database. Here is your product ID:");
		System.out.println();
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		while (rs.next()) {
			System.out.println("Product ID: " + rs.getString(1)/* + " " + rs.getString(2) */);
		}
		System.out.println();
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		System.out.println();

		// System.out.println("Insert Successful");

	}

	// 3. gets all products from the database
	public static void getAllProducts() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/walmart", "root", "root");
		Statement sql = conn.createStatement();
		ResultSet rs = sql.executeQuery("select * from products");
		System.out.print("\nID   |   Name   |   Quantity  |  Price\n");
		while (rs.next()) {
			System.out.println(
					rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4));

		}

	}
	
	// 4. delete product from the database
		public static void deleteProduct(int productID) throws SQLException {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/walmart", "root", "root");
			Statement sql = conn.createStatement();
			sql.executeUpdate("delete from products where productId = " + 4);
			System.out.println("Delete successful");
			}


	// Ideas to add to final project: update, search, get me all total inventory

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