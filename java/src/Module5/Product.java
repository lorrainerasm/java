package Module5;

public class Product {
	private String name;
	private int qty;
	private double price;

	public Product(String name, int qty, double price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQty() {
	    return qty;
	}
	
	public double getPrice() {
	    return price;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}