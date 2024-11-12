import java.util.Vector;

public class Player {
    private String playerID;
    private String playerName;
    private Vector<Hero> heros;

    public Player(String playerID, String playerName) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.heros = new Vector<>();
    }

    public String getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void addHero(Hero hero) {
        heros.add(hero);
    }

    public void removeHero(Hero hero) {
        heros.remove(hero);
    }

    public Vector<Hero> getHeroes() {
        return heros;
    }

    public void showPlayerDetails() {
        // Display player's details
    }
}