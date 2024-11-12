package command;

import system.Receiver;
import memento.Memento;
import memento.CareTaker;
import model.Player;

public class CreatePlayerCommand extends Command {
    private String playerID;
    private String playerName;
    private Player createdPlayer;

    public CreatePlayerCommand(Receiver receiver, CareTaker careTaker, String playerID, String playerName) {
        super(receiver, careTaker);
        this.playerID = playerID;
        this.playerName = playerName;
    }

    @Override
    public void execute() {
        createdPlayer = receiver.createPlayer(playerID, playerName);
        memento = receiver.createMemento();
        careTaker.saveMemento(memento);
    }

    @Override
    public void undo() {
        if (memento != null) {
            receiver.restoreFromMemento(memento);
        }
    }
} 