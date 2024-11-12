public class ShowPlayerCommand extends Command {
    public ShowPlayerCommand(Receiver receiver, CareTaker careTaker) {
        super(receiver, careTaker);
    }

    @Override
    public void execute() {
        receiver.showCurrentPlayer();
    }

    @Override
    public void undo() {
    }
} 