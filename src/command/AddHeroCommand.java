public class AddHeroCommand extends Command {
    private String heroType;
    private String heroID;
    private String heroName;
    private Hero addedHero;

    public AddHeroCommand(Receiver receiver, CareTaker careTaker, String heroType, String heroID, String heroName) {
        super(receiver, careTaker);
        this.heroType = heroType;
        this.heroID = heroID;
        this.heroName = heroName;
    }

    @Override
    public void execute() {
        addedHero = receiver.addHero(heroType, heroID, heroName);
        memento = receiver.createMemento();
        careTaker.saveMemento(memento);
    }

    @Override
    public void undo() {
        if (addedHero != null) {
            receiver.removeHero(addedHero.getHeroID());
        }
    }
} 