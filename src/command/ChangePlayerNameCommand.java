package command;

import system.Receiver;
import memento.Memento;
import memento.CareTaker;

public class ChangePlayerNameCommand extends Command {
    private String playerID;
    private String newName;
    private String oldName;

    public ChangePlayerNameCommand(Receiver receiver, CareTaker careTaker, String playerID, String newName) {
        super(receiver, careTaker);
        this.playerID = playerID;
        this.newName = newName;
    }

    @Override
    public void execute() {
        oldName = receiver.getPlayerName(playerID);
        receiver.changePlayerName(playerID, newName);
        memento = receiver.createMemento();
        careTaker.saveMemento(memento);
    }

    @Override
    public void undo() {
        if (oldName != null) {
            receiver.changePlayerName(playerID, oldName);
        }
    }
} 