/*
*This class represents the player. Methods in this class inlude a takeTurn
*which allows a player a turn where they will or will not play a playable card.
*Players can be passed if they have no playable cards.
*/

import java.util.LinkedList;
import java.util.Random;

public class Player {

  /**
  *player identifier to identify who is playing
  */
  private int playerNumber;

  /**
  *initializes deck for the dealer
  */
  private Dealer dealerDeck = new Dealer();

  /**
  *list to represent the starterPile where cards will be played
  */
  private LinkedList <Card> starterPile = new LinkedList <Card> ();

  /**
  *list to represent the players hand
  */
  private LinkedList <Card> playerHand = new LinkedList <Card> ();

  /**
  *default constructor that deals 5 cards to the player's player's hand from the dealer's deck
  *@param player identifies which player is playing
  *@param dealer the dealer deck that the cards are being dealt from
  *@param starter pile where the cards will be played
  */
  public Player(int player, Dealer dealer, LinkedList <Card> starter) {
    playerNumber = player;
    dealerDeck = dealer;
    starterPile = starter;

    for (Card card: dealerDeck.deals(5)) {
      playerHand.add(card);                                             //adds 5 cards to playerHand one by one
    }
  }

  /**
  *player will take a turn where they will either play a playable card from their hand,
  *draw from the dealer's deck if they have no playable cards in hand, or pass
  *their turn if the dealer's deck is depleted and they still have no playable card
  *@return a Card object of a card that is playable
  */
  public Card takeTurn() {
    Card playableCard = new Card();
    Card starterTopCard = new Card();
    Card eightsCard = new Card();

    starterTopCard = starterPile.get(starterPile.size()-1);           //starter card that the player will have to match suits or value with
    playableCard = null;
    eightsCard = null;

    //checks for a playable card in player's hand with either the same suit, value, or an eight
    for (Card card: playerHand) {
      if (card.getValue() == 8) {                                     //checks for an eight card and continues if there is
        eightsCard = card;
      }

      if ((card.getSuit() == starterTopCard.getSuit()) ||             //checks the card for the same value or suit and continues if there is
      (card.getValue() == starterTopCard.getValue())) {
        if (eightsCard != null) {                                     //if there is an eights card in the playerHand, there is a 10% chance of it being played, despite having a card of matching suit or value
          Random rand = new Random();
          int randNum = rand.nextInt(10);                             //1 number out of 10 gives it a 10% chance
          if (randNum == 8) {                                         //the value 8 is selected from the random number generator so the eights card will be the playableCard
            playableCard = eightsCard;
            break;
          }
        }
        playableCard = card;                                          //disregards the eights cards and uses the card with matching suit/value as the playable card
        break;                                                        //breaks since the first playable card in the player's hand will be used
      }
      else {                                                          //the card is not playable and the loop continues onto the next card to check for a playable card
        continue;
      }
    }

    //no playable card so player must draw cards from a dealer's deck
    Card tempCard = new Card();
    if (playableCard == null) {
      if (dealerDeck.size() != 0) {                                    //if dealer's deck is not empty, it will deal one card
        tempCard = dealerDeck.deals(1).get(0);
        while ((tempCard.getValue() != starterTopCard.getValue()) &&   //if card is not playable, loop will continue until deck is depleted or there is a playable card
        (tempCard.getSuit() != starterTopCard.getSuit())) {
          playerHand.add(tempCard);
          if (dealerDeck.size() != 0) {
            tempCard = dealerDeck.deals(1).get(0);
          }
          else {
            playableCard = null;
            break;
          }
        }
        if ((tempCard.getValue() == starterTopCard.getValue()) || (tempCard.getSuit() == starterTopCard.getSuit())) {
          playableCard = tempCard;
        }
      }
      else {
        playableCard = null;
      }
    }

    //adds playable card to the starter pile if the player has a playable card
    if (playableCard != null) {
      playerHand.remove(playableCard);
      starterPile.add(playableCard);
    }
    return playableCard;
  }

  /**
  *if the playable card has a value of 8, a new suit is assigned with the method
  *@return Card object with a value of 8 but a new suit
  */
  public Card newSuit() {
    Random rand = new Random();
    Card newStarterCard = new Card();
    int randNum = rand.nextInt(4);                                    //range 0-3 because those are the values of the suits

    newStarterCard.setValue(8);
    newStarterCard.setSuit(randNum);                                  //sets suit to a random suit generated from a 25% probability
    starterPile.add(newStarterCard);
    return newStarterCard;
  }

  /**
  *gets player number identifier
  *@return int that represents the player's number
  */
  public int getPlayerNum() {
    return this.playerNumber;
  }

  /**
  *gets the contents of the player's hand
  *@return LinkedList that contains the cards in the player's hand
  */
  public LinkedList <Card> getPlayerHand() {
    return this.playerHand;
  }

  /**
  *gets the contents of the starter pile
  *@return LinkedList that contains the cards in the starter pile
  */
  public LinkedList <Card> getStarterPile() {
    return this.starterPile;
  }

  /**
  *gets the top card of the starter pile, which is the card whose suit or value needs to be matched
  *@return Card object that represents the top card of the starter pile
  */
  public Card getStarterTopCard() {
    int starterPileSize = this.starterPile.size();
    return starterPile.get(starterPileSize-1);
  }

  /**
  *gets the contents of the the dealer's deck
  *@return Dealer object that represents the dealer's deck
  */
  public Dealer getDealerDeck() {
    return this.dealerDeck;
  }
}
