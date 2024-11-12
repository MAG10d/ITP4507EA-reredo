public class UndoCommand extends Command {
    public UndoCommand(Receiver receiver, CareTaker careTaker) {
        super(receiver, careTaker);
    }

    @Override
    public void execute() {
        receiver.undo();
    }

    @Override
    public void undo() {
    }
} 