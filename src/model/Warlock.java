package model;

public class Warlock extends Hero {
    private int mp;

    public Warlock(String heroID, String heroName) {
        super(heroID, heroName);
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    @Override
    public void callSkill() {
        System.out.println("Warlock " + getHeroName() + " casts Shadow Bolt!");
    }

    @Override
    public void showHeroStatus() {
        System.out.println("Warlock Status:");
        System.out.println("ID: " + getHeroID());
        System.out.println("Name: " + getHeroName());
        System.out.println("HP: " + getHp());
        System.out.println("Damage: " + getDamage());
        System.out.println("MP: " + mp);
    }
}