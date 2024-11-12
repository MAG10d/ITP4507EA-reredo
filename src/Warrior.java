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
        // Implement Warrior's skill
    }

    @Override
    public void showHeroStatus() {
        // Display Warrior's status
    }
}