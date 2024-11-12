public class SetCurrentPlayerCommand extends Command {
    private String playerID;
    private String previousPlayerID;

    public SetCurrentPlayerCommand(Receiver receiver, CareTaker careTaker, String playerID) {
        super(receiver, careTaker);
        this.playerID = playerID;
    }

    @Override
    public void execute() {
        previousPlayerID = receiver.getCurrentPlayerID();
        receiver.selectPlayer(playerID);
        memento = receiver.createMemento();
        careTaker.saveMemento(memento);
    }

    @Override
    public void undo() {
        if (previousPlayerID != null) {
            receiver.selectPlayer(previousPlayerID);
        }
    }
} 