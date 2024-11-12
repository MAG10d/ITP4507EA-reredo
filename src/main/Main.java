package main;

import system.GameSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameSystem gameSystem = new GameSystem();
        gameSystem.initialize();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlease enter command: [c|g|a|d|m|s|p|t|u|r|l|x]");
            System.out.println("c = create player, g = set current player");
            System.out.println("a = add hero, d = delete hero");
            System.out.println("m = call hero skill, s = show player");
            System.out.println("p = display all players, t = change player's name");
            System.out.println("u = undo, r = redo");
            System.out.println("l = list undo/redo, x = exit system");

            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];
            
            try {
                switch (command) {
                    case "x":
                        gameSystem.executeCommand("exit", new Object[]{});
                        return;
                    case "c":
                        if (parts.length == 3) {
                            gameSystem.executeCommand("create", new Object[]{parts[1], parts[2]});
                        }
                        break;
                    case "g":
                        if (parts.length == 2) {
                            gameSystem.executeCommand("select", new Object[]{parts[1]});
                        }
                        break;
                    case "a":
                        if (parts.length == 4) {
                            gameSystem.executeCommand("add", new Object[]{parts[1], parts[2], parts[3]});
                        }
                        break;
                    case "d":
                        if (parts.length == 2) {
                            gameSystem.executeCommand("delete", new Object[]{parts[1]});
                        }
                        break;
                    case "m":
                        if (parts.length == 2) {
                            gameSystem.executeCommand("skill", new Object[]{parts[1]});
                        }
                        break;
                    case "s":
                        gameSystem.executeCommand("show", new Object[]{});
                        break;
                    case "p":
                        gameSystem.executeCommand("display", new Object[]{});
                        break;
                    case "t":
                        if (parts.length == 3) {
                            gameSystem.executeCommand("change", new Object[]{parts[1], parts[2]});
                        }
                        break;
                    case "u":
                        gameSystem.undoLastCommand();
                        break;
                    case "r":
                        gameSystem.redoLastCommand();
                        break;
                    case "l":
                        gameSystem.executeCommand("list", new Object[]{});
                        break;
                    default:
                        System.out.println("Unknown command!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
} 