
package football;

public class Team {
	public static final int DEFAULT_MAX_TEAM_SIZE = 20;
	
	private String teamName;
	private Player[] players;
	private int teamSize;
	
	public Team(String name){
		this(name, DEFAULT_MAX_TEAM_SIZE);
	}
	
	public Team(String name, int maxTeamSize){
		teamName = name;
		players = new Player[maxTeamSize];
		teamSize = 0;
	}
	
	public String getTeamName() { return teamName; }
	
	public int getTeamSize() { return teamSize; }
	
	public int getMaxTeamSize() { return players.length; }
	
	public boolean addPlayer(Player newPlayer){
		if (newPlayer.getTeam() == this)
			// player is already on this team; no need to add
			return true; 
			
		else if (teamSize < players.length) {
			// this team has space for this player.  However, we first
			// need to make sure that the player is not already on another team
			
			if (newPlayer.getTeam() != null)
				// player is on another team.  Need to remove him/her
				// from other team before adding to this team
				newPlayer.getTeam().removePlayer(newPlayer.getName());
			
			// now, we can go ahead to add the new player to this team.
			newPlayer.setTeam(this);
			players[teamSize] = newPlayer;
			teamSize++;
			return true;
		}
		
		else // no space on this team to add a new player!
			return false;
	}
	
	public boolean removePlayer(String playerName) {
		boolean foundPlayer = false;
		for(int i=0; i<teamSize; i++) {
			if (playerName.equals(players[i].getName())) {
				players[i].setTeam(null);
				players[i] = players[teamSize-1];
				teamSize--;
				foundPlayer = true;
				break;
			}
		}
		
		return foundPlayer;
	}
	
	public void listPlayers() {
		for(int i=0; i<teamSize; i++){
			System.out.println((i+1) + ") " + players[i].getName() + ", " +
								players[i].getPosition());
		}
	}
				
}
		