package command;

import memento.Memento;
import memento.CareTaker;
import system.Receiver;

public abstract class Command {
    protected Receiver receiver;
    protected Memento memento;
    protected CareTaker careTaker;

    public Command(Receiver receiver, CareTaker careTaker) {
        this.receiver = receiver;
        this.careTaker = careTaker;
    }

    public abstract void execute();
    public abstract void undo();
} 