package Module4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
import java.sql.*;
import Module4.Logging;

//Take a program that you have done in the past and make a variety of changes. 
//Take a screen shot – make sure you pay attention to any commit changes.

public class Main {
	
	/*static Logger logger = Logger.*/

	// Inventory Management System
	public static ArrayList<Product> products = new ArrayList<Product>();
	
	public static void main(String[] args) throws SQLException {
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
				String productName = kb.next(); //get a strong input from user
				
				System.out.println("To Add Product:\nPlease enter a product quantity: ");
				int productQty = kb.nextInt(); //get an int input from user
				System.out.println("To Add Product:\nPlease enter a product price: ");
				double productPrice = kb.nextDouble(); //get decimal input from user
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
				getAllProducts();  //DisplayProducts();
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
		
		//insert or add the product
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/walmart", "root", "root");
		PreparedStatement sql = conn.prepareStatement("insert into products(name, qty, cost) values(?,?,?)");
		sql.setString(1,name);
		sql.setInt(2, qty);
		sql.setDouble(3, price);
		
		sql.executeUpdate();
		
		// 2. get the product ID after insert
		Statement sqlST = conn.createStatement ();
		ResultSet rs = sqlST.executeQuery("select * from products where name ='" + name + "'");
		System.out.println("Here are the current products in the Database with Name: " + name);
		System.out.println("++++++++++++++++++++++++++++++++++");
		while(rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2));
		}
		
		System.out.println("++++++++++++++++++++++++++++++++++\n");

		System.out.println("Insert Successful");
		
	}
	
	// 3. gets all products from the database
	public static void getAllProducts() throws SQLException{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/walmart", "root", "root");
		Statement sql = conn.createStatement ();
		ResultSet rs = sql.executeQuery("select * from products");
		while(rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2));
		}
		
	}

	// 4. update, 5. search, 6. get me all total sales for today ?????
	
	
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