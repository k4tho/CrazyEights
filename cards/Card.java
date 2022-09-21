/**
*This class represents a singular card for a deck. It creates a card object that stores its
*object that stores its suit and value.
*/

public class Card {

  /**
  *Assigns values to each of the suits and face card values.
  *Values and suits of the cards can not be changed.
  */
  public static final int JACK = 11;
  public static final int QUEEN = 12;
  public static final int KING = 13;
  public static final int ACE = 14;

  public static final int HEARTS = 0;
  public static final int SPADES = 1;
  public static final int CLUBS = 2;
  public static final int DIAMONDS = 3;

  /**
  *value portion of a card
  */
  private int cardValue;                    //stores the value of the card (2-14) privately

  /**
  *suit portion of a card
  */
  private int cardSuit;                     //stores the suit of the card (0-3) privately

  /**
  *Initializes a card to a suit and value of -1
  *since cards of this suit and value do not exist
  */
  public Card(){
    cardSuit = -1;
    cardValue = -1;
  }

  /**
  *Overload constructor that initializes a card object containing a value and suit
  *@param cardValue Value of the card
  *@param cardSuit Suit of the card
  */
  public Card(int cardValue, int cardSuit){
    this.cardValue = cardValue;
    this.cardSuit = cardSuit;
  }

  /**
  *Shallow copy constructor that creates a duplicate of a card
  *@param card An object of the class Card
  */
  public Card(Card card) {                                            //takes in object card as a parameter
    this.cardValue = card.getValue();                                 //uses the parameter card's value and suit to copy into this
    this.cardSuit = card.getSuit();
  }

  /**
  *mutator that changes the value of the card
  */
  public void setValue(int cardValue) {
    this.cardValue = cardValue;
  }

  /**
  *mutator that changes the suit of the card
  */
  public void setSuit(int cardSuit) {
    this.cardSuit = cardSuit;
  }

  /**
  *accesses the private card value
  *@return an int that represents the card's value
  */
  public int getValue() {
    return this.cardValue;
  }

  /**
  *accesses the private card suit
  *@return an int that represents the card's suit
  */
  public int getSuit() {
    return this.cardSuit;
  }

  /**
  *tests if two cards contains the same value and suit
  *@param an object card to compare to
  *@return a boolean that states whether the two cards are the same
  */
  public boolean equals(Card card) {
    if (this.getSuit() != card.getSuit()) {                   //tests if the suits of the cards are the same
      return false;
    }
    if (this.getValue() != card.getValue()) {                 //tests if the values of the cards are the same
      return false;
    }
    else {
      return true;
    }
  }

  /**
  *prints out card's value and suit
  *represented textually rather than by its integer value
  *@return a string that represents the card's contents
  */
  public String toString() {
    String valueIntToText="";                               //initializes string for value and suit for conversion from integer value to text
    String suitIntToText="";

    if (this.getSuit()==0) {                                //converts the integer value to its textual counterpart to be printed
      suitIntToText = "Hearts";
    }
    if (this.getSuit()==1) {
      suitIntToText = "Spades";
    }
    if (this.getSuit()==2) {
      suitIntToText = "Clubs";
    }
    if (this.getSuit()==3) {
      suitIntToText = "Diamonds";
    }

    if (this.getValue()==11) {
      valueIntToText = "Jack";
    }
    if (this.getValue()==12) {
      valueIntToText = "Queen";
    }
    if (this.getValue()==13) {
      valueIntToText = "King";
    }
    if (this.getValue()==14) {
      valueIntToText = "Ace";
    }

    if (this.getValue() <= 10) {                          //prints value out numerically if the value is less than 11
      return this.getValue() + " of " + suitIntToText;
    }
    else {                                                //prints out value textually rather than numerically is value is 11 or greater
      return valueIntToText + " of " + suitIntToText;
    }
  }
}
