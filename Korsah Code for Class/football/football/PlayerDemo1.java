package football;

public class PlayerDemo1 {

 public static void main(String[] args) {
  System.out.println("Testing the Player class.");
  Player player1 = new Player("Sulley Muntari", Player.Position.MIDFIELDER);
  Player player2 = new Player("Vincent Enyeama", Player.Position.GOALKEEPER);
  Player player3 = new Player("Kolo Toure", Player.Position.DEFENDER);
  
  System.out.println("Player 1's name is: " + player1.getName());
  System.out.println("Player 1's position is: " + player1.getPosition());
  System.out.println("Player 1's team is: " + player1.getTeam());
  if (player1.hasTeam() == false)
   System.out.println("Actually, player 1 doesn't have a team.");
  if (!player1.hasTeam())
   System.out.println("To reiterate, player 1 doesn't have a team.");
  System.out.println();
  
  System.out.println("Displaying info about all players.");
  player1.displayPlayerInfo();
  player2.displayPlayerInfo();
  player3.displayPlayerInfo();
  System.out.println();
  
  System.out.println("FYI, the possible player positions are:");
  Player.listValidPositions();
  
  System.out.println();
  System.out.println("Listed another way, the possible player positions are: "+
       Player.getValidPositionsStr());
 }
}