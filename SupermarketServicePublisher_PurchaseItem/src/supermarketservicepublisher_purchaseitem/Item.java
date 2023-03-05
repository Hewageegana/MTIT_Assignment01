package supermarketservicepublisher_purchaseitem;

public class Item {
	private String name;
	private float price;
	private String itemCode;
	private String brand;
	private int quantity;
	
	public Item() {
		
	}

	public Item(String name, float price, String itemCode, String brand, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.itemCode = itemCode;
		this.brand = brand;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
