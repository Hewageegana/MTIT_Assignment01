package supermarketserviceproducer_search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SupermarketServiceSearchIMPL implements SupermarketServiceSearch{

	public void SearchItems() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String itemname = "";
		
		ArrayList<Items> items = new ArrayList<>();
		
		items.add(new Items(001,"chocolate biscuit","munchee", 250, 470.0 ));
		items.add(new Items(002,"vanilla icecream 4L","magic", 150, 2600.0 ));
		items.add(new Items(003,"vanilla icecream 2L","magic", 120, 1300.0 ));
		items.add(new Items(004,"chocolate icecream 4L","immorich",100, 2350.0 ));
		items.add(new Items(005,"chocolate icecream 4L","immorich", 100, 2450.0 ));
		items.add(new Items(006,"chashew nut chocolate 175g","rysbury", 450, 380.0 ));
		items.add(new Items(007,"chashew nut chocolate 100g","kandos", 250, 470.0 ));
		items.add(new Items(010,"casava bites 150g","rancrysp", 450, 300.0 ));
		items.add(new Items(011,"twist apple juice","elephant house", 350, 420.0 ));
		items.add(new Items(012,"chocolate biscuit","munchee", 250, 470.0 ));
		items.add(new Items(013,"chocolate biscuit","munchee", 250, 470.0 ));
		
//		System.out.println();
//		System.out.println("==========================================");
//		System.out.println("   ******* Welcome To the Presto *******");
//		System.out.println("***The largest grocery mart in the town***");
//		System.out.println("==========================================");
//		System.out.println("!!! Enter Blank To Exit !!!");
//		System.out.println("------------------------------------------------");
//		System.out.println();

	try {
		while(true) {
			System.out.print("Enter Item Name or Brand Name: ");
			itemname = in.readLine();
			
			if(itemname.length() > 0) {
				boolean isfound = false;
				for (Items item : items) {
					String itemName = item.getItemName();
					String brandName = item.getBrandName();
					
					if(itemname.equalsIgnoreCase(itemName) || itemname.equalsIgnoreCase(brandName)) {
						
						isfound = true;
						
						System.out.println();
						System.out.println("Item is available");
						System.out.println("-------------------------------------");
						System.out.println("Item Name :     " + item.getItemName());
						System.out.println("Brand Name :   " + item.getBrandName());
						System.out.println("Quantity :          " + item.getQty());
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
				else {
					System.out.println();
					System.out.println("-------------------------------------");
					System.out.println("              ThankYou!              ");
					System.out.println("             Come Again!            ");
					System.out.println("-------------------------------------");
					System.out.println();
					break;
				}
			}
		}
	}catch(IOException e) {
		e.printStackTrace();
		}
	}
}
