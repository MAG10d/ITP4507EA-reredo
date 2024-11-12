
import java.util.ArrayList;
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
public interface CommandFactory {

    public void execute();

    public void undo();
}

class EditMenuCommand implements CommandFactory {

    Scanner sc;

    public EditMenuCommand(Scanner sc) {
	this.sc = sc;
    }

    public void execute() {
	Menu menu = null;
	System.out.println("Edit Menu");
	// Create lunchset
	while (menu == null) {
	    menu = MenuFactory.getMenu(sc);
	    menu.editMenu(sc);
//	    lunchSet = LunchSetFactory.createLunchSet(sc);
	}

	System.out.print("Menu Updated\n\n");
    }

    public void undo() {

    }
}

class ShowMenuCommand implements CommandFactory {

    Scanner sc;

    public ShowMenuCommand(Scanner sc) {
	this.sc = sc;
    }

    public void execute() {
	for (Menu menu : MenuFactory.getMenus()) {
	    if (menu != null) {
		System.out.print("\n\n" + menu.toString());
	    }
	}
	System.out.print("\n\n");
    }

    public void undo() {

    }
}

class ListOrderCommand implements CommandFactory {

    Scanner sc;
    ArrayList<Order> outstandingOrders;

    public ListOrderCommand(Scanner sc, ArrayList outstandingOrders) {
	this.sc = sc;
	this.outstandingOrders = outstandingOrders;
    }

    public void execute() {
	System.out.println("\nOutstanding Orders");
	for (Order order : outstandingOrders) {
	    System.out.println(order.toString());
	}
	System.out.println("");
    }

    public void undo() {

    }
}

class PlaceOrderCommand implements CommandFactory {

    Scanner sc;
    ArrayList<Order> orders;

    public PlaceOrderCommand(Scanner sc, ArrayList orders) {
	this.sc = sc;
	this.orders = orders;
    }

    public void execute() {
	Order order = new Order();
	Menu menu = MenuFactory.getMenu(sc);
	LunchSet lunchset = menu.createLunchSet();
	order.lunchset = lunchset;
	System.out.println(order.lunchset);
	order.place(sc);
    }

    public void undo() {

    }
}

class CancelOrderCommand implements CommandFactory {

    Scanner sc;
    ArrayList<Order> orders;

    public CancelOrderCommand(Scanner sc) {
	this.sc = sc;
	this.orders = orders;

    }

    public void execute() {
	System.out.println("\nCancel Order");
	System.out.println("Staff Number: ");
	String input = sc.nextLine();
	for (Order order : orders) {
	    if (order.staffNumber.equals(input)) {
		orders.remove(order);
		System.out.println(order.toString());
		break;
	    }
	}
	System.out.println("");
    }

    public void undo() {

    }
}

class CompleteOrderCommand implements CommandFactory {

    Scanner sc;
    ArrayList<Order> outstandingOrders;
    ArrayList<Order> completedOrders;

    public CompleteOrderCommand(Scanner sc, ArrayList outstandingOrders, ArrayList completedOrders) {
	this.sc = sc;
	this.outstandingOrders = outstandingOrders;
	this.completedOrders = completedOrders;
    }

    public void execute() {
	System.out.println("Complete Order");
	if (outstandingOrders.size() > 0) {
	    Order order = outstandingOrders.remove(0);
	    completedOrders.add(order);
	    System.out.println(order.toString());
	    System.out.println("Order marked as done\n");
	} else {
	    System.out.println("All orders have been completed");
	}
    }

    public void undo() {

    }
}
