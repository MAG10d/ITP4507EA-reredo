import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author op7
 */
public class ChineseLunchSet extends LunchSet {

    ChineseMenu menu = MenuFactory.chineseMenu;
    String drink = "";
    String soup = "Chinese soup";

    public ChineseLunchSet() {
	super();
    }

    public void placeOrder(Scanner sc) {
	while (!drink.equals("h") && !drink.equals("i")) {
	    System.out.print("Oolong Tea: hot or iced (h | i): ");
	    drink = sc.nextLine();
	}
    }

    public String toString() {
	String msg = String.format("Chinese style Business Set Lunch\n"
		+ "main dish: %s\n"
		+ "with rice, Chinese soup, Chinese tea\n"
		+ "price: %d\n"
		+ "available count: %d",
		menu.mainDish, menu.price, menu.availableCount);

	return msg;
    }

    public String orderDetails() {
	String soup = "Chinese soup";
	String drink_verbose = "";

	if (drink.equals("h")) {
	    drink_verbose = "Hot Tea";
	} else if (drink.equals("i")) {
	    drink_verbose = "Iced Tea";
	}

	return String.format("%s, %s, %s", menu.mainDish, soup, drink_verbose);

    }

    public ChineseMenu getMenu() {
	return menu;
    }

    
    
}
