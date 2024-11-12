public class RedoCommand extends Command {
    public RedoCommand(Receiver receiver, CareTaker careTaker) {
        super(receiver, careTaker);
    }

    @Override
    public void execute() {
        receiver.redo();
    }

    @Override
    public void undo() {
    }
} 