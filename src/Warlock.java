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
        // Implement Warlock's skill
    }

    @Override
    public void showHeroStatus() {
        // Display Warlock's status
    }
}