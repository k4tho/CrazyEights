import java.util.LinkedList;

/*
*This class represents a game of crazy eights with two players. Players will take turns until one person wins
*by getting rid of their hand, or if both players have unplayable cards in which the person with less cards win.
*If both players have the same amount of cards, the player with the most points calculated wins.
*/

public class Game {

  /**
  *represents the dealer deck
  */
  private Dealer dealer = new Dealer();

  /**
  *list to collect the cards in the starter pile
  */
  private LinkedList <Card> starterPile = new LinkedList <Card>();

  /**
  *first player identified
  */
  private Player player1;

  /**
  *second player identified
  */
  private Player player2;

  /**
  *default constructor that initializes two players to five cards each
  *and deals a card to the starter pile
  */
  public Game() {
    starterPile.add(dealer.deals(1).get(0));
    player1 = new Player(1, dealer, starterPile);
    player2 = new Player(2, dealer, starterPile);
  }

  /**
  *gets the contents of Player 1's hand
  *@return LinkedList that represents the first player's hand
  */
  public LinkedList <Card> getPlayer1Hand(){
    return player1.getPlayerHand();
  }

  /**
  *gets the contents of Player 2's hand
  *@return LinkedList that represents the second player's hand
  */
  public LinkedList <Card> getPlayer2Hand(){
    return player2.getPlayerHand();
  }

  /**
  *gets the contents of the dealer's deck
  *@return Dealer object that represents the contents of the dealer's deck
  *@see Player#getDealerDeck()
  */
  public Dealer getDealer() {
    return player1.getDealerDeck();
  }

  /**
  *gets the top card of the starter pile
  *@return Card object that represents the top card of the starter pile
  *@see Player#getStarterPile()
  */
  public Card getStarter() {
    int starterPileSize = player1.getStarterPile().size();
    return player1.getStarterPile().get(starterPileSize-1);
  }

  /**
  *game commences and two players take turns until the turns run out and a winner is declared
  *@see Player#getDealerDeck()
  *@see Player#getStarterPile()
  *@see Player#getPlayerHand()
  *@see Player#takeTurn()
  *@see Player#newSuit()
  *@see Card#getValue()
  *@see Card#getSuit()
  *@return String that prints the winner and the player identifier number
  */
  public String play() {
    //Initialization before the players start taking turns printed to diplay
    System.out.println("Dealer's deck (" + player1.getDealerDeck().size() + " cards): " + player1.getDealerDeck());
    System.out.println("Player 1 hand: " + player1.getPlayerHand());
    System.out.println("Player 2 hand: " + player2.getPlayerHand());
    System.out.println("Starter pile top card: " + player1.getStarterPile());
    System.out.println("Dealer's Deck: " + player1.getDealerDeck().size());
    System.out.println();

    Card tempPlayableCard1 = new Card(2,2);                                                 //playable cards will be copied into temporary cards when a player take their turn
    Card tempPlayableCard2 = new Card(2,2);                                                 //temporary cards initialized to a random card to enter the while loop below

    /**print statements are used to print to display how the game is progressing
    *loop represents the players taking turns until a player has won the game
    *while one or both players have playable cards, the loop will continue which allows them to take turns
    */
    while (!((tempPlayableCard1 == null) && (tempPlayableCard2 == null))) {
      if ((player1.getPlayerHand().size() == 0) || (player2.getPlayerHand().size() == 0)) { //a player has emptied out their hand and the game/loop ends
        break;
      }
      if (tempPlayableCard1 != null) {                                                      //if the playable card is null, then the turn gets skipped
        System.out.println("Player 1 hand: " + player1.getPlayerHand());
        tempPlayableCard1 = player1.takeTurn();
        System.out.println("Player 1 hand after turn: " + player1.getPlayerHand());
        System.out.println("Card played: " + tempPlayableCard1);
        if ((tempPlayableCard1 != null) && (tempPlayableCard1.getValue() == 8)) {           //if the playable card has the value 8, then a new suit is declared
          System.out.println("New suit: " + player1.newSuit());
        }
        System.out.println("Dealer's Deck: " + player1.getDealerDeck().size());
        System.out.println();
      }
      if (tempPlayableCard2 != null) {
        System.out.println("Player 2 hand: " + player2.getPlayerHand());
        tempPlayableCard2 = player2.takeTurn();
        System.out.println("Player 2 hand after turn: " + player2.getPlayerHand());
        System.out.println("Card played: " + tempPlayableCard2);
        if ((tempPlayableCard1 != null) && (tempPlayableCard2.getValue() == 8)) {
          System.out.println("New suit: " + player2.newSuit());
        }
        System.out.println("Dealer's Deck: " + player1.getDealerDeck().size());
        System.out.println();
      }
    }

    /**
    *game has ended and the winner will be declared
    */
    int winner;
    int player1pts = 0;
    int player2pts = 0;
    if (player1.getPlayerHand().size() < player2.getPlayerHand().size()) {                        //player 1 wins if they have less cards in their hand than player 2
      winner = player1.getPlayerNum();
    }
    else if (player1.getPlayerHand().size() > player2.getPlayerHand().size()) {                   //player 2 wins if they have less cards in their hand than player 1
      winner = player2.getPlayerNum();
    }
    else {                                                                                        //if both players have the same number of cards, winner is determined by total value of their cards
      for (Card card: player1.getPlayerHand()) {                                                  //player 1 points get added
        if (card.getValue() == 8) {
          player1pts += 50;
        }
        else if ((card.getValue() == 10) || (card.getValue() == 11) || (card.getValue() == 12) || (card.getValue() == 13)) {
          player1pts += 10;
        }
        else if (card.getValue() == 14)  {
          player1pts += 1;
        }
        else {
          player1pts += card.getValue();
        }
      }
      for (Card card: player2.getPlayerHand()) {                                                   //player 2 points get added
        if (card.getValue() == 8) {
          player2pts += 50;
        }
        else if (card.getValue() == 10 || card.getValue() == 11 || card.getValue() == 12 || card.getValue() == 13) {
          player2pts += 10;
        }
        else if (card.getValue() == 14) {
          player2pts += 1;
        }
        else {
          player2pts += card.getValue();
        }
      }
      if (player1pts > player2pts) {
        winner = player1.getPlayerNum();
      }
      else {
        winner = player2.getPlayerNum();
      }
    }
    return "Winner: player " + winner;
  }
}
