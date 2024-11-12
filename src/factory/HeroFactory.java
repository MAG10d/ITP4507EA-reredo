package factory;

import model.Hero;

public abstract class HeroFactory {
    public abstract Hero createHero(String heroID, String heroName);
} 