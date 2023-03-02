package supermarketserviceproducer_search;

public class Items {

	int itemCode;
	String itemName;
	String brandName;
	int qty;
	double price;
	public Items(int itemCode, String itemName, String brandName, int qty, double price) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.brandName = brandName;
		this.qty = qty;
		this.price = price;
	}
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
}
