package supermarketservicepublisher_purchaseitem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class PurchaseItemServiceImp implements PurchaseItemService {

	private float totalAmount = 0;
	private ArrayList<Item> purchaseItems = new ArrayList<>();
	
	@Override
	public void purchaseItem() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String search = "";
		String quantityStr = "";
		int quantity = 0;
		
		boolean inValid = true;
		boolean secondInValid = true;
		
		ArrayList<Item> item = new ArrayList<>();
		HashMap<String, Item> ItemMap = new HashMap<String, Item>();
		ItemMap.put("AP-200", new Item("Apple",150,"AP-200","Fresh Fruits", 100));
		ItemMap.put("OR-233", new Item("Orange",100,"OR-233","Fresh Fruits", 130));
		ItemMap.put("BS-222", new Item("Mari Biscut",80,"BS-222","Maliban", 30));
		ItemMap.put("SP-099", new Item("Soap",200,"SP-099","LUX", 40));
		
//		item.add(new Item("Apple",150,"AP-200","Fresh Fruits", 100));
//		item.add(new Item("Orange",100,"OR-233","Fresh Fruits", 130));
//		item.add(new Item("Mari Biscut",80,"BS-222","Maliban", 30));
//		item.add(new Item("Soap",200,"SP-099","LUX", 40));
		
		System.out.println();
		System.out.println("-----------------Welcome To Supermarket----------------");
		System.out.println("** You Can Purchase Items **");
		System.out.println("** Enter Blank To Exit **");
		System.out.println("---------------------------------------------------");
		System.out.println();
		
		try {
			System.out.println("-----------------Available Item List----------------");
			for(HashMap.Entry<String, Item> itemlist: ItemMap.entrySet()) {
				System.out.println("---------------------------------------------------");
				System.out.println("  Item Name : " + itemlist.getValue().getName());
				System.out.println("  Price :    " + String.valueOf(itemlist.getValue().getPrice()));
				System.out.println("  Item Code :  " + itemlist.getValue().getItemCode());
				System.out.println("  Item Brand :      " + itemlist.getValue().getBrand());
				System.out.println("  Available Quantity :      " + String.valueOf(itemlist.getValue().getQuantity()));
				System.out.println("-----------------------------------------------");
			}
			System.out.println("------------------------------------------------");
			while(true) {
				System.out.print("Enter Item Code: ");
				search = in.readLine();
				System.out.println();
				if(search.length() > 0 && ItemMap.containsKey(search)) {
					if(ItemMap.get(search).getQuantity() > 0) {
						System.out.print( "Item Available!");
						System.out.println("---------------------------------------------------");
						System.out.println("  Item Name : " + ItemMap.get(search).getName());
						System.out.println("  Price :    " + String.valueOf(ItemMap.get(search).getPrice()));
						System.out.println("  Item Code :  " + ItemMap.get(search).getItemCode());
						System.out.println("  Item Brand :      " + ItemMap.get(search).getBrand());
						System.out.println("  Available Quantity :      " + String.valueOf(ItemMap.get(search).getQuantity()));
						System.out.println("-----------------------------------------------");
		
						while(inValid) {
							System.out.println();
							System.out.print("Enter Required Item Quantity: ");
							try {
								quantity = Integer.parseInt(in.readLine());
								inValid = false;
							}
							catch(NumberFormatException e) {
								System.out.println( "InValid Quantity");
							} catch(IOException e) {
					            e.printStackTrace();
					        }
							
						}
						
						while(quantity > ItemMap.get(search).getQuantity()) {
							System.out.println("Minimum Quantity Availble in stock is " + String.valueOf(ItemMap.get(search).getQuantity()));
							secondInValid = true;
							while(secondInValid) {
								System.out.println();
								System.out.print("Enter Required Item Quantity: ");
								try {
									quantity = Integer.parseInt(in.readLine());
									secondInValid = false;
								}
								catch(NumberFormatException e) {
									System.out.println("InValid Quantity");
								} catch(IOException e) {
						            e.printStackTrace();
						        }
								
							}
						}
						
						ItemMap.get(search).setQuantity(ItemMap.get(search).getQuantity() - quantity);
						Item newArr = ItemMap.get(search);
						newArr.setQuantity(quantity);
						purchaseItems.add(newArr);
						float purchaseAmount = ItemMap.get(search).getPrice() * quantity;
						totalAmount = totalAmount + purchaseAmount;
						
						System.out.println();
						System.out.println(".............................................................................");
						System.out.printf("                   Amount for this purchase: Rs. %.2f",(float)purchaseAmount);
						System.out.println();
						System.out.printf("                          Total Bill Amount: Rs. %.2f ", totalAmount);
						System.out.println();
						System.out.println(".............................................................................");
						
						System.out.println();
						System.out.println("If you want to buy another items press 'y'.");
						System.out.println("If you want to see bill details press 'x'.");
						String next = in.readLine();
						
						search = "";
						quantityStr = "";
						quantity = 0;
						
						inValid = true;
						secondInValid = true;
						
						if(next.equals("x")) {
							System.out.println("=============================================================================");
							System.out.println("                          Super Market Bill                                     ");
							System.out.println("=============================================================================");

							System.out.println("  Items - Brand\t\t\t\t\t\tQTY\tUnit(Rs.)\tAmount(Rs.)");
							
							for (Item obj : purchaseItems) {

								
								System.out.printf("%-50s \t", obj.getName() + " - " + obj.getBrand());
								System.out.print(" " + obj.getQuantity() + " \t");
								System.out.printf("%.2f \t\t", obj.getPrice());
								System.out.printf("%.2f\n", obj.getPrice() * obj.getQuantity());

							}

							System.out.println("-----------------------------------------------------------------------------");
							System.out.printf("   	Total Amount : Rs.%.2f", totalAmount);
							System.out.println();

							System.out.println("*****************************************************************************");
							System.out.println("        End of the bill. Thank you & come again...!          ");
							purchaseItems.clear();

							totalAmount = 0;
							String res = in.readLine();
							break;
						}
					}
					
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
