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
		
		HashMap<String, Item> booksMap = new HashMap<String, Item>();
		booksMap.put("AP-200", new Item("Apple",150,"AP-200","Fresh Fruits", 100));
		booksMap.put("OR-233", new Item("Orange",100,"OR-233","Fresh Fruits", 130));
		booksMap.put("BS-222", new Item("Mari Biscut",80,"BS-222","Maliban", 30));
		booksMap.put("SP-099", new Item("Soap",200,"SP-099","LUX", 40));
		
		System.out.println();
		System.out.println("-----------------Welcome To Supermarket----------------");
		System.out.println("** You Can Purchase Items **");
		System.out.println("** Enter Blank To Exit **");
		System.out.println("---------------------------------------------------");
		System.out.println();
		
		try {
			while(true) {
				System.out.print("Enter Item Code: ");
				search = in.readLine();
				System.out.println();
				if(search.length() > 0 && booksMap.containsKey(search)) {
					if(booksMap.get(search).getQuantity() > 0) {
						System.out.print( "Item Available!");
						System.out.println("---------------------------------------------------");
						System.out.println("  Item Name : " + booksMap.get(search).getName());
						System.out.println("  Price :    " + String.valueOf(booksMap.get(search).getPrice()));
						System.out.println("  Item Code :  " + booksMap.get(search).getItemCode());
						System.out.println("  Item Brand :      " + booksMap.get(search).getBrand());
						System.out.println("  Available Quantity :      " + String.valueOf(booksMap.get(search).getQuantity()));
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
						
						while(quantity > booksMap.get(search).getQuantity()) {
							System.out.println("Minimum Quantity Availble in stock is " + String.valueOf(booksMap.get(search).getQuantity()));
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
						
						booksMap.get(search).setQuantity(booksMap.get(search).getQuantity() - quantity);
						Item newArr = booksMap.get(search);
						newArr.setQuantity(quantity);
						purchaseItems.add(newArr);
						float purchaseAmount = booksMap.get(search).getPrice() * quantity;
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
