package Controler;

import Model.Player; 
import java.util.ArrayList;
import java.util.List;

public class PlayerController {
    private List<Player> players;

    public PlayerController() {
        players = new ArrayList<>();
    }

    public void addPlayer(int id, String name, String team, String role, int runs, int wickets) {
        Player newPlayer = new Player(id, name, team, role, runs, wickets);
        players.add(newPlayer);
    }

    public Player getPlayerById(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }

    public void updatePlayerStatistics(int id, int runs, int wickets) {
        Player player = getPlayerById(id);
        if (player != null) {
            player.updateStatistics(runs, wickets);
        } else {
            System.out.println("Player with ID " + id + " not found.");
        }
    }

    public List<Player> getTeamRoster(String teamName) {
        List<Player> teamRoster = new ArrayList<>();
        for (Player player : players) {
            if (player.getTeam().equalsIgnoreCase(teamName)) {
                teamRoster.add(player);
            }
        }
        return teamRoster;
    }

    public Player getTopPlayer(String category) {
        Player topPlayer = null;
        for (Player player : players) {
            if (topPlayer == null || 
                (category.equals("runs") && player.getRuns() > topPlayer.getRuns()) || 
                (category.equals("wickets") && player.getWickets() > topPlayer.getWickets())) {
                topPlayer = player;
            }
        }
        return topPlayer;
    }
}
