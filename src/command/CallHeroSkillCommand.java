package command;

import system.Receiver;
import memento.CareTaker;
import model.Hero;

public class CallHeroSkillCommand extends Command {
    private String heroID;
    private Hero hero;

    public CallHeroSkillCommand(Receiver receiver, CareTaker careTaker, String heroID) {
        super(receiver, careTaker);
        this.heroID = heroID;
    }

    @Override
    public void execute() {
        hero = receiver.getHero(heroID);
        if (hero != null) {
            hero.callSkill();
            memento = receiver.createMemento();
            careTaker.saveMemento(memento);
        }
    }

    @Override
    public void undo() {
        if (memento != null) {
            receiver.restoreFromMemento(memento);
        }
    }
} 