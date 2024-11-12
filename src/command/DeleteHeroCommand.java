public class DeleteHeroCommand extends Command {
    private String heroID;
    private Hero deletedHero;

    public DeleteHeroCommand(Receiver receiver, CareTaker careTaker, String heroID) {
        super(receiver, careTaker);
        this.heroID = heroID;
    }

    @Override
    public void execute() {
        deletedHero = receiver.getHero(heroID);
        receiver.removeHero(heroID);
        memento = receiver.createMemento();
        careTaker.saveMemento(memento);
    }

    @Override
    public void undo() {
        if (deletedHero != null) {
            receiver.addExistingHero(deletedHero);
        }
    }
} 