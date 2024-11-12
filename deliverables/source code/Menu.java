
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
public abstract class Menu {

    private static Menu single_instance = null;

    int price = 0;
    int availableCount = 0;
    final String CODE = "";

    public abstract void editMenu(Scanner sc);
    
    public abstract LunchSet createLunchSet();
    
    public Menu(){	
    }


}
