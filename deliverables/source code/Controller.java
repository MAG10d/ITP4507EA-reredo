/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author op7
 */
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;

public class Controller {

    static Scanner sc; // Java scanner object
    static ArrayList<Order> outstandingOrders;
    static ArrayList<Order> completedOrders;
    static ArrayList<CommandFactory> commands;

    public static void main(String[] args) {
	sc = new Scanner(System.in);
	outstandingOrders = new ArrayList();
	completedOrders = new ArrayList();
	commands = new ArrayList();

	while (true) {
	    System.out.println("Please enter command: [e | s | p | c | l | n | d | q]\n"
		    + "e = Edit menu, s = Show menu, p = Place order, c = Cancel order,\n"
		    + "l = List orders, d = order is Done, q = Quit");

	    String command_option = sc.nextLine();

	    if (command_option.equals("e")) {
		EditMenuCommand f = new EditMenuCommand(sc);
		executeCommand(f);
	    } else if (command_option.equals("s")) {
		ShowMenuCommand f = new ShowMenuCommand(sc);
		executeCommand(f);
	    } else if (command_option.equals("p")) {
		PlaceOrderCommand f = new PlaceOrderCommand(sc, outstandingOrders);
		executeCommand(f);
	    } else if (command_option.equals("c")) {
		CancelOrderCommand f = new CancelOrderCommand(sc);
		executeCommand(f);
	    } else if (command_option.equals("l")) {
		ListOrderCommand f = new ListOrderCommand(sc, outstandingOrders);
		executeCommand(f);
	    } else if (command_option.equals("n")) {
		// Not used.
	    } else if (command_option.equals("d")) {
		CompleteOrderCommand f = new CompleteOrderCommand(sc, outstandingOrders, completedOrders);
		executeCommand(f);
	    } else if (command_option.equals("q")) {
		System.exit(0);
	    }
	    // Will ask user to enter again if an unexpected input is received.

	}

    }
    
    
    private static void executeCommand(CommandFactory command){
	command.execute();
	commands.add(command);
    }
}