
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
public class WesternLunchSet extends LunchSet {

    WesternMenu menu = MenuFactory.westernMenu;
    String sideDish = "";
    String drink = "";
    String soup = "Western soup";

    public WesternLunchSet() {
	super();
    }

    public void placeOrder(Scanner sc) {
	while (!sideDish.equals("r") && !sideDish.equals("s") && !sideDish.equals("f")) {
	    System.out.print("side: rice, spaghetti, French fries (r | s | f):");
	    sideDish = sc.nextLine();
	}
	while (!drink.equals("ht") && !drink.equals("it") && !drink.equals("hc") && !drink.equals("ic")) {
	    System.out.print("tea or coffee, hot or iced (ht| it | hc | ic):");
	    drink = sc.nextLine();
	}
    }

    public String toString() {
	String msg = String.format("Western style Business Set Lunch\n"
		+ "main dish: %s\n"
		+ "with rice/spaghetti/French fries\n"
		+ "price: %d\n"
		+ "available count: %d",
		menu.mainDish, menu.price, menu.availableCount);

	return msg;
    }

    public String orderDetails() {
	String soup = "Western soup";
	String drink_verbose = "";

	if (drink.equals("ht")) {
	    drink_verbose = "Hot Tea";
	} else if (drink.equals("it")) {
	    drink_verbose = "Iced Tea";
	} else if (drink.equals("hc")) {
	    drink_verbose = "Hot Coffee";
	} else if (drink.equals("ic")) {
	    drink_verbose = "Iced Coffee";
	}

	return String.format("%s, %s, %s", menu.mainDish, soup, drink_verbose);

    }

    public WesternMenu getMenu() {
	return menu;
    }

    
    
}
