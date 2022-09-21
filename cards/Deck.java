/**
*This class represents a deck of 52 shuffled cards, created from a linkedlist.
*Contains methods that displays the size of the deck, prints
*information out to display, and deals a card from the deck.
*/

import java.util.Random;
import java.util.LinkedList;

public class Deck {

  /**
  *contains a stack of cards into a deck
  */
  private LinkedList <Card> m_cards;

  /**
  *default constructor that first initializes a deck of 52 card in order
  *from least to greatest value and then shuffles the cards
  */
  public Deck() {
    LinkedList <Card> orderedCards = new LinkedList<Card>();            //creates an empty deck that will contain ordered cards from value 2 to 14
    m_cards = new LinkedList<Card>();                                   //ordered deck that is shuffled
    Card card = new Card();                                             //creates the object card that will modified to have specific values and suits
    Card tempCard = new Card();                                         //temporarily stores the above card to be added into the default deck

    //creates an ordered deck of 52 cards
    for (int i=2; i<=14; ++i) {                                         //iterates through all 14 values with the exception of 1 and sets the value
      card.setValue(i);
      for (int j=0; j<=3; ++j) {                                        //iterates through all 4 suits and sets the suit
        card.setSuit(j);
        tempCard = new Card(card.getValue(), card.getSuit());           //sets the tempCard to the same values and suits as the card variable
        orderedCards.add(tempCard);                                     //adds tempCard and not card because using card will add the same card to the deck 52 times
      }
    }

    //creates a shuffled deck of cards
    int i = 51;
    while (i>=0) {                                                      //shuffles the deck by using a random number generator that will pick a card at a random index
      Random rand = new Random();                                       //and add that card to the m_cards deck
      int randNum = rand.nextInt(orderedCards.size());
      m_cards.add(orderedCards.get(randNum));
      orderedCards.remove(randNum);
      --i;
    }
  }

  /**
  *duplicates a deck of card
  *@param deck Deck object to duplicate
  */
  public Deck(Deck deck) {
    Card duplicatedCard = new Card();                                   //creates a Card object that will represent the copy of the card we want to duplicate
    Card cardToDuplicate = new Card();                                  //creates a Card object that will represent the card we want to duplicate
    for (int i=0; i<deck.size(); ++i) {                                 //iterates through all 52 cards in deck and modified each card one by one
      cardToDuplicate = deck.m_cards.get(i);
      for (int j=2; j<=14; ++j) {                                       //iterates through 14 values
        duplicatedCard.setValue(cardToDuplicate.getValue());
        for (int k=0; k<=3; ++i) {                                      //iterates through 4 suits
          duplicatedCard.setSuit(cardToDuplicate.getSuit());
          m_cards.add(duplicatedCard);
        }
      }
    }
  }

  /**
  *prints out the deck's contents to display
  *@return a string that represents the deck of cards' contents
  *@see Card#toString()
  */
  public String toString() {
    String printOut = "";
    for (Card card: m_cards) {
      printOut += card.toString() + ", ";
    }
    return printOut;
  }

  /**
  *prints out the deck's size
  *@return an int representing the size of the deck
  */
  public int size() {
    return m_cards.size();
  }

  /**
  *deals a card from a deck
  *picks a random card from the deck with random number generator to get
  *card at randNum index and removes that card from the deck
  *@return a Card object of the card that was dealt from the deck
  */
  public Card deal() {
    Random rand = new Random();
    int randNum = rand.nextInt(m_cards.size());                          //picks a random number and sets the variable randum to represent that
    Card dealtCard = m_cards.get(randNum);                               //dealtCard represents the card that is being dealt; is assigned the card from m_cards deck at the index of randNum
    m_cards.remove(randNum);                                             //removes the dealtCard from the original deck
    return dealtCard;
  }
}
