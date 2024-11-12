package memento;

import model.Originator;

public class Memento {
    private Object state;
    private Originator originator;

    public Memento(Originator originator) {
        this.originator = originator;
        this.state = originator.getState();
    }

    public void restore() {
        originator.restoreFromMemento(this);
    }

    protected Object getState() {
        return state;
    }
} 