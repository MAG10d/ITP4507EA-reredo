package model;

public class Warrior extends Hero {
    private int defencePoint;

    public Warrior(String heroID, String heroName) {
        super(heroID, heroName);
    }

    public int getDefencePoint() {
        return defencePoint;
    }

    public void setDefencePoint(int defencePoint) {
        this.defencePoint = defencePoint;
    }

    @Override
    public void callSkill() {
        System.out.println("Warrior " + getHeroName() + " uses Charge!");
    }

    @Override
    public void showHeroStatus() {
        System.out.println("Warrior Status:");
        System.out.println("ID: " + getHeroID());
        System.out.println("Name: " + getHeroName());
        System.out.println("HP: " + getHp());
        System.out.println("Damage: " + getDamage());
        System.out.println("Defence Point: " + defencePoint);
    }
}