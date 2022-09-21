/**
*This class only contains the main method to play the games out.
*Game 1 gets played out in this class.
*@see Game#play()
*/
public class CrazyEightsDriver {
  public static void main (String [] args) {
    Game game1 = new Game();
    System.out.print(game1.play());
  }
}
