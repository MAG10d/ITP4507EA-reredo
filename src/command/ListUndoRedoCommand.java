public class ListUndoRedoCommand extends Command {
    public ListUndoRedoCommand(Receiver receiver, CareTaker careTaker) {
        super(receiver, careTaker);
    }

    @Override
    public void execute() {
        receiver.showUndoRedoHistory();
    }

    @Override
    public void undo() {
    }
} 