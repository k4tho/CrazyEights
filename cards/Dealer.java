/*
*This class represents the Dealer's deck.
*It contains methods that will display the size of the Dealer's deck, the contents of
*the deck, and a method called deals(int n) that will deal a number of n cards and
*returns the cards that were dealt
*/

import java.util.Random;
import java.util.LinkedList;

public class Dealer {

  /**
  *contains dealer's deck of cards using the Deck class
  */
  private Deck m_deck;

  /**
  *contains a list of cards that were dealt from the dealer's deck
  */
  private LinkedList <Card> cardsDealt;

  /**
  *default constructor that initializes dealer's deck to a shuffled deck
  */
  public Dealer() {
    m_deck = new Deck();
  }

  /**
  *deals a number of cards from the dealer's deck m_deck
  *@param n number of cards that is going to be dealt
  *@return a linkedList containing all the cards that were dealt
  *@see Dealer#deal()
  */
  public LinkedList<Card> deals(int n) {
    this.cardsDealt = new LinkedList <Card> ();
    for (int i=0; i < n; ++i) {
      this.cardsDealt.add(m_deck.deal());                              //adds a random card from m_deck into the cardsDealt deck and removes that card from the m_deck in the process
    }
    return this.cardsDealt;
  }

  /**
  *prints out the dealer's deck size
  *@return an int representing the size of the dealer's deck
  */
  public int size() {
    return m_deck.size();
  }

  /**
  *prints out the dealer's deck contents to display
  *@return a string that represents the dealer's deck of cards contents
  *@see Deck#toString()
  */
  public String toString() {
    return m_deck.toString();
  }
}
