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
public class ChineseMenu extends Menu {

    String mainDish;
    String soup;
    final String CODE = "C";

    public ChineseMenu() {
	super();
	soup = "Chinese Soup";
    }

    @Override
    public ChineseLunchSet createLunchSet() {
	return new ChineseLunchSet();
    }

    public void editMenu(Scanner sc) {
	System.out.print("Enter main dish: ");
	mainDish = sc.nextLine();

	System.out.print("Enter price: ");
	price = Integer.parseInt(sc.nextLine());

	System.out.print("Enter available count: ");
	availableCount = Integer.parseInt(sc.nextLine());

    }

    public String toString() {
	String msg = String.format("Chinese style Business Set Lunch\n"
		+ "main dish: %s\n"
		+ "with rice, Chinese soup, Chinese tea\n"
		+ "price: %d\n"
		+ "available count: %d",
		mainDish, price, availableCount);

	return msg;
    }
}
