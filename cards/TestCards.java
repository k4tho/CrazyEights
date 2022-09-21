/*
This class tests the functions of the Card, Deck, and Dealer classes
*/

import java.util.Scanner;
import java.util.LinkedList;

public class TestCards {
  public static void main (String[] args) {
    Card card1 = new Card(2,1);                       //Creates 2 new cards and prints them to line
    Card card2 = new Card(13,2);
    Card card3 = new Card(card2);                     //tests the copy constructors
    System.out.println(card1.toString());
    System.out.println(card2.toString());
    System.out.println("Card 3 = Card 1? " + card3.equals(card1));          //tests the equals method
    System.out.println("Card 3 = Card 2? " + card3.equals(card2));

    Deck cardDeck = new Deck();                       //Creates a deck of 52 cards
    System.out.println("Deck Size: " + cardDeck.size());              //ensures there's 52 cards and prints them out
    System.out.println("Cards in Deck: " + cardDeck.toString());
    System.out.println("Card dealt: " + cardDeck.deal());              //tests if the deal method will select a random card and remove it from the deck
    System.out.println("Card size after card was dealt: " + cardDeck.size());

    Dealer dealerDeck = new Dealer();                 //creates a dealer's deck
    System.out.println("Dealer's deck size: " + dealerDeck.size());
    System.out.println("Dealer's deck: " + dealerDeck.toString());
    System.out.println("10 Cards Dealt from Dealer: " + dealerDeck.deals(10));         //deals cards from the dealer's deck
    System.out.println("5 Cards Dealt from Dealer: " + dealerDeck.deals(5));
    System.out.println("Dealer's deck after cards dealt: " + dealerDeck.size());            //tests to see if the dealt cards are still in the dealer's deck
  }
}
