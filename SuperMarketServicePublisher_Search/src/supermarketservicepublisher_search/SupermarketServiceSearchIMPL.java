package supermarketservicepublisher_search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SupermarketServiceSearchIMPL implements SupermarketServiceSearch{

	@SuppressWarnings("unused")
	private boolean isOver = true;
	public void SearchItems() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String itemname = "";
		
		ArrayList<Items> items = new ArrayList<>();
		
		items.add(new Items("001","chocolate biscuit - 250g","munchee", 250, 470.0 ));
		items.add(new Items("002","vanilla icecream","magic", 150, 2600.0 ));
		items.add(new Items("003","vanilla icecream","magic", 120, 1300.0 ));
		items.add(new Items("004","chocolate icecream","immorich",100, 2350.0 ));
		items.add(new Items("005","chocolate icecream","immorich", 100, 2450.0 ));
		items.add(new Items("006","chashew nut chocolate","rysbury", 450, 380.0 ));
		items.add(new Items("007","chashew nut chocolate","kandos", 250, 470.0 ));
		items.add(new Items("010","casava bites","rancrysp", 450, 300.0 ));
		items.add(new Items("011","twist apple juice","elephant house", 350, 420.0 ));
		items.add(new Items("012","chocolate biscuit - 100g","munchee", 250, 470.0 ));
		items.add(new Items("013","chocolate biscuit - 50g","munchee", 250, 470.0 ));
		
//		System.out.println();
//		System.out.println("==========================================");
//		System.out.println("   ******* Welcome To the Presto *******");
//		System.out.println("***The largest grocery mart in the town***");
//		System.out.println("==========================================");
//		System.out.println("!!! Enter Blank To Exit !!!");
//		System.out.println("------------------------------------------------");
//		System.out.println();

	try {
		System.out.println("Available Item List");
		for(Items item : items) {
			System.out.println("-------------------------------------");
			System.out.println("Item Name :     " + item.getItemName());
			System.out.println("Brand Name :   " + item.getBrandName());
			System.out.println("Quantity :          " + item.getQuantity());
			System.out.println("Price : " + item.getPrice());
			System.out.println("-------------------------------------");
		}
		while(true) {
			System.out.print("Enter Item Name or Brand Name: ");
			itemname = in.readLine();
			
			if(itemname.length() > 0) {
				boolean isfound = false;
				for (Items item : items) {
					String itemName = item.getItemName();
					String brandName = item.getBrandName();
					
					if(itemname.toLowerCase().contains(itemName) || itemname.toLowerCase().contains(brandName)) {
						
						isfound = true;
						
						System.out.println();
						System.out.println("Item is available");
						System.out.println("-------------------------------------");
						System.out.println("Item Name :     " + item.getItemName());
						System.out.println("Brand Name :   " + item.getBrandName());
						System.out.println("Quantity :          " + item.getQuantity());
						System.out.println("Price : " + item.getPrice());
						System.out.println("*************************************");
						System.out.println();
					}
				}
				if (!isfound) {
					System.out.println();
					System.out.println("Item is not available");
					System.out.println();
				}
//				else {
//					System.out.println();
//					System.out.println("-------------------------------------");
//					System.out.println("              ThankYou!              ");
//					System.out.println("             Come Again!            ");
//					System.out.println("-------------------------------------");
//					System.out.println();
//					break;
//				}
			}
		}
	}catch(IOException e) {
		e.printStackTrace();
		}
	}
}
