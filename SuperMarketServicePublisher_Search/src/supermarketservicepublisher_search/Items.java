package supermarketservicepublisher_search;

public class Items {

	String itemCode;
	String itemName;
	String brandName;
	int quantity;
	double price;
	public Items(String itemCode, String itemName, String brandName, int quantity, double price) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.brandName = brandName;
		this.quantity = quantity;
		this.price = price;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
