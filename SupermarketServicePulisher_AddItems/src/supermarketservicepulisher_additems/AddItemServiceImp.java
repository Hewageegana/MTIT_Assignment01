package supermarketservicepulisher_additems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class AddItemServiceImp implements AddItemService {

	@Override
	public void addItem() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String name;
		float price;
		String itemCode;
		String brand;
		int quantity;
		String answer = " ";
		ArrayList<Item> itemList = new ArrayList<>();
		
		System.out.println();
		System.out.println("Welcome To Online Supermarket - Admin");
		System.out.println("!Enter Blank To Exit!");
		System.out.println("---------------------------------------------------");
		System.out.println();
		
		
		try {
			while(true) {
				System.out.print("Enter A to Add Item R to Remove Item: ");
				answer = in.readLine();
				System.out.println();
				if (answer.equalsIgnoreCase("A")) {
					System.out.println();
					System.out.println("---- Item Details ---- ");
					System.out.print("Enter Item Name: ");
					name = in.readLine();
					System.out.print("Enter Price: ");
					price = Float.valueOf(in.readLine());
					System.out.print("Enter Item Code: ");
					itemCode = in.readLine();
					System.out.print("Enter Item Brand: ");
					brand = in.readLine();
					System.out.print("Enter Item Quantity: ");
					quantity = Integer.valueOf(in.readLine());
					System.out.println();
					
					if (name.isEmpty() || itemCode.isEmpty() || brand.isEmpty() || String.valueOf(price).isEmpty() || String.valueOf(quantity).isEmpty() || price <= 0 || quantity <= 0) {
						System.out.println();
						System.out.println("-----------------------------------------------");
						System.out.println("                Have A Good Day!               ");
						System.out.println("-----------------------------------------------");
						System.out.println();
						break;
					} else {
						itemList.add(new Item(name, price, itemCode, brand, quantity));

					}
					
					if (itemList.size() > 0) {
						System.out.println();
						System.out.println("---------------- Item List ------------------- ");
						System.out.println();
						for (Item item : itemList) {
							System.out.println("  Item Name : " + item.getName());
							System.out.println("  Price :    " + String.valueOf(item.getPrice()));
							System.out.println("  Item Code :  " + item.getItemCode());
							System.out.println("  Item Brand :      " + item.getBrand());
							System.out.println("  Quantity :      " + String.valueOf(item.getQuantity()));
							System.out.println("  Successfully Added!");
							System.out.println("-----------------------------------------------");
							System.out.println();
						}
					} else {
						System.out.println();
						System.out.println("No Items in List");
						System.out.println();
						break;
					}
				} else if (answer.equalsIgnoreCase("R")) {
					System.out.println("Enter Item Code: ");
					String itemCodeSt = " ";
					itemCodeSt = in.readLine();
					System.out.println();
					if (itemCodeSt.length() > 0) {
						for (int i = 0; i < itemList.size(); i++) {
							if (itemCodeSt.equals(itemList.get(i).getItemCode())) {
								itemList.remove(i);
								System.out.println();
								System.out.println("-----------------------------------------------");
								System.out.println("              Succusfully Removed              ");
								System.out.println("-----------------------------------------------");
								System.out.println();
							} else {
								System.out.println();
								System.out.println("Item Not Found");
								System.out.println();
							}

						}

					} else {
						System.out.println();
						System.out.println("-----------------------------------------------");
						System.out.println("                Have A Good Day!               ");
						System.out.println("-----------------------------------------------");
						break;
					}
				} else {
					System.out.println();
					System.out.println("-----------------------------------------------");
					System.out.println("                Have A Good Day!               ");
					System.out.println("-----------------------------------------------");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
