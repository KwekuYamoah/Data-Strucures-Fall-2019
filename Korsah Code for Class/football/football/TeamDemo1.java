
package football;

public class TeamDemo1 {

	public static void main(String[] args) {
		Team manU = new Team("Manchester United");
		Team manCity = new Team("Manchester City");
		
		System.out.println(manU.getTeamName() + " currently has " +
							manU.getTeamSize() + " players.");
		System.out.println(manCity.getTeamName() + " currently has " +
							manCity.getTeamSize() + " players.");
							
		System.out.println();
		System.out.println("Creating some players.");
		Player[] players = new Player[5];
		players[0] = new Player("Paul Pogba", Player.Position.MIDFIELDER);
		players[1] = new Player("David de Gea", Player.Position.GOALKEEPER);
		players[2] = new Player("Rodrigo", Player.Position.MIDFIELDER);
		players[3] = new Player("Mason Greenwood", Player.Position.FORWARD);
		players[4] = new Player("Benjamin Mendy", Player.Position.DEFENDER);
		System.out.println("Here are our players:");
		for (int i=0; i<players.length; i++) {
			players[i].displayPlayerInfo();
		}
		System.out.println("Here are our teams:");
		System.out.println("TEAM 1: " + manU.getTeamName());
		manU.listPlayers();
		System.out.println("TEAM 2: " + manCity.getTeamName());
		manCity.listPlayers();
				
		System.out.println();
		System.out.println("Assigning players to teams.");
		manU.addPlayer(players[0]);
		manU.addPlayer(players[1]);
		manU.addPlayer(players[3]);
		manCity.addPlayer(players[2]);
		manCity.addPlayer(players[4]);
		System.out.println("Here are our players:");
		for (int i=0; i<players.length; i++) {
			players[i].displayPlayerInfo();
		}
		System.out.println("Here are our teams:");
		System.out.println("TEAM 1: " + manU.getTeamName());
		manU.listPlayers();
		System.out.println("TEAM 2: " + manCity.getTeamName());
		manCity.listPlayers();

		
		System.out.println();
		System.out.println("Transferring " + players[0].getName() + 
							" from " + players[0].getTeam().getTeamName() + 
							" to " + manCity.getTeamName());
		manCity.addPlayer(players[0]);
		System.out.println("Here are our players:");
		for (int i=0; i<players.length; i++) {
			players[i].displayPlayerInfo();
		}
		System.out.println("Here are our teams:");
		System.out.println("TEAM 1: " + manU.getTeamName());
		manU.listPlayers();
		System.out.println("TEAM 2: " + manCity.getTeamName());
		manCity.listPlayers();
		
	}

}