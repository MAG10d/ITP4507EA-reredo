package command;

import system.Receiver;
import memento.CareTaker;

public class DisplayAllPlayersCommand extends Command {
    public DisplayAllPlayersCommand(Receiver receiver, CareTaker careTaker) {
        super(receiver, careTaker);
    }

    @Override
    public void execute() {
        receiver.displayAllPlayers();
    }

    @Override
    public void undo() {
    }
} 