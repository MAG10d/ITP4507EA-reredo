package factory;

import model.Hero;
import model.Warrior;

public class WarriorFactory extends HeroFactory {
    @Override
    public Hero createHero(String heroID, String heroName) {
        return new Warrior(heroID, heroName);
    }
} 