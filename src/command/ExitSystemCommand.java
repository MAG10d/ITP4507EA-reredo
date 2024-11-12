public class ExitSystemCommand extends Command {
    public ExitSystemCommand(Receiver receiver, CareTaker careTaker) {
        super(receiver, careTaker);
    }

    @Override
    public void execute() {
        receiver.shutdown();
    }

    @Override
    public void undo() {
    }
} 