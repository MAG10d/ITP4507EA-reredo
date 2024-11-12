package system;

import command.Command;
import factory.CommandFactory;
import memento.CareTaker;
import model.Player;

public class GameSystem {
    private Receiver receiver;
    private CommandFactory commandFactory;
    private CommandInvoker commandInvoker;
    private CareTaker careTaker;

    public GameSystem() {
        this.careTaker = new CareTaker();
        this.receiver = new Receiver();
        this.commandFactory = new CommandFactory(receiver, careTaker);
        this.commandInvoker = new CommandInvoker();
    }

    public void executeCommand(String commandType, Object[] params) {
        Command command = commandFactory.createCommand(commandType, params);
        commandInvoker.executeCommand(command);
    }

    public void undoLastCommand() {
        commandInvoker.undo();
    }

    public void redoLastCommand() {
        commandInvoker.redo();
    }

    public void initialize() {
        // Initialize system components
        System.out.println("Game System Initialized");
    }

    public void shutdown() {
        System.out.println("Shutting down system...");
        System.exit(0);
    }
} 