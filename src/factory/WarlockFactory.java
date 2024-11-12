package factory;

import model.Hero;
import model.Warlock;

public class WarlockFactory extends HeroFactory {
    @Override
    public Hero createHero(String heroID, String heroName) {
        return new Warlock(heroID, heroName);
    }
} 