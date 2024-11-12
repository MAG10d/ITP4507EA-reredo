package system;

import model.*;
import factory.*;
import memento.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Receiver {
    private Map<String, Player> players;
    private Player currentPlayer;
    private HeroFactory warriorFactory;
    private HeroFactory warlockFactory;

    public Receiver() {
        this.players = new HashMap<>();
        this.warriorFactory = new WarriorFactory();
        this.warlockFactory = new WarlockFactory();
    }

    // Player management
    public Player createPlayer(String playerID, String playerName) {
        if (players.containsKey(playerID)) {
            throw new IllegalArgumentException("Player ID already exists");
        }
        Player player = new Player(playerID, playerName);
        players.put(playerID, player);
        if (currentPlayer == null) {
            currentPlayer = player;
        }
        return player;
    }

    public void selectPlayer(String playerID) {
        Player player = players.get(playerID);
        if (player == null) {
            throw new IllegalArgumentException("Player not found");
        }
        currentPlayer = player;
    }

    public String getCurrentPlayerID() {
        return currentPlayer != null ? currentPlayer.getPlayerID() : null;
    }

    public String getPlayerName(String playerID) {
        Player player = players.get(playerID);
        if (player == null) {
            throw new IllegalArgumentException("Player not found");
        }
        return player.getPlayerName();
    }

    public void changePlayerName(String playerID, String newName) {
        Player player = players.get(playerID);
        if (player == null) {
            throw new IllegalArgumentException("Player not found");
        }
        player.setPlayerName(newName);
    }

    // Hero management
    public Hero addHero(String heroType, String heroID, String heroName) {
        if (currentPlayer == null) {
            throw new IllegalStateException("No player selected");
        }

        Hero hero;
        if ("warrior".equalsIgnoreCase(heroType)) {
            hero = warriorFactory.createHero(heroID, heroName);
        } else if ("warlock".equalsIgnoreCase(heroType)) {
            hero = warlockFactory.createHero(heroID, heroName);
        } else {
            throw new IllegalArgumentException("Invalid hero type");
        }

        currentPlayer.addHero(hero);
        return hero;
    }

    public void removeHero(String heroID) {
        if (currentPlayer == null) {
            throw new IllegalStateException("No player selected");
        }
        Hero hero = getHero(heroID);
        if (hero != null) {
            currentPlayer.removeHero(hero);
        }
    }

    public Hero getHero(String heroID) {
        if (currentPlayer == null) {
            throw new IllegalStateException("No player selected");
        }
        Vector<Hero> heroes = currentPlayer.getHeroes();
        for (Hero hero : heroes) {
            if (hero.getHeroID().equals(heroID)) {
                return hero;
            }
        }
        return null;
    }

    public void addExistingHero(Hero hero) {
        if (currentPlayer == null) {
            throw new IllegalStateException("No player selected");
        }
        currentPlayer.addHero(hero);
    }

    // Display methods
    public void showCurrentPlayer() {
        if (currentPlayer == null) {
            System.out.println("No player selected");
            return;
        }
        currentPlayer.showPlayerDetails();
    }

    public void displayAllPlayers() {
        if (players.isEmpty()) {
            System.out.println("No players found");
            return;
        }
        for (Player player : players.values()) {
            player.showPlayerDetails();
            System.out.println();
        }
    }

    // System methods
    public void shutdown() {
        System.out.println("Shutting down system...");
        System.exit(0);
    }

    public void undo() {
    }

    public void redo() {
    }

    public void showUndoRedoHistory() {
    }

    // Memento methods
    public Memento createMemento() {
        return null;
    }

    public void restoreFromMemento(Memento memento) {
    }
}