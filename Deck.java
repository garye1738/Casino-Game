/* Name: Gabriel Arye
   Email: gabrielarye@brandeis.edu
   Date: December 9, 2018
   PA7, Deck Class: Program creates an array of Card objects with a constructor. It has other other methods that objects of its
   class can use to shuffle, draw another card, and discard a card.
   Bugs: in the drawNextCard method, .clone() was not working when applied to the Card[] cards array, so i used loops that
   are present in the Deck constructor.
*/

import java.util.*;
import java.io.*;

/*public class Deck: creates several instance variables. public Card[] cards is declared as an array to hold objects of type Card.
public Card[] discardPile is declared as another array to hold Card objects. public int[] values is declared and initialized to
reference numbers 1 to 13 inclusive; this will be used as the values of cards. public String[] suits is declared and
initilaized to "Hearts", "Diamonds", "Spades", and "Clubs".
*/
public class Deck
{
  public Card[] cards;
  public Card[] discardPile;
  public int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
  public String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};

  /*public Deck: this is a constructor for a Deck object of Card objects. cards (from above) is initialized to be an array
  that is 52 spaces long of type Card. discardPile is initialized to be an array that is also 52 spaces long of type Card.

  int index is declared and initilaized to 0. A for loop is created and initlialized with int i equals 0, i is less
  than values.length, and i++. This array will go through every value of 1 to 13 (and every card from Ace to King).

  An inner for loop is created and initialized to int j equals 0, j is less than suits.length, and j++.
  A new card object is created with a numeric value from values[i] and a suit from suits[j] and assigned to cards[index].
  index is incremented by 1. Every iteration of this inner for loop will create one of the 4 suits for a one card card value.
  It will repeat 4 times per card (or values[i]). Both these for loops work to create a new deck of complete cards. After
  both for loops end, the suffle method is called to shuffle the newly formed deck.
  */
  public Deck()
  {
    cards = new Card[52];
    discardPile = new Card[52];

    int index = 0;
    for(int i = 0; i < values.length; i++) {
      for(int j = 0; j < suits.length; j++) {
       cards[index] = new Card(values[i], suits[j]);
       index++;
      }
    }
    shuffle();
  }

  /*void method shuffle(): declared and initializes int len to cards.length. Random rand is declared and created as a new Random object.
  boolean works is delcared and initilaized as false.

  A for loop is created and initialized to int i equals len, i is greater than 1, and i--. false is assigned to works.
  int cardOneIndex is declared and initialized as rand.nextInt(52). int cardTwoIndex is declared and initialized as rand.nextInt(52).
  Both of these variables will represent the index of a random card in the array cards.

  A while loop has the condition that while works equals false, it will lead to an if statement. The if statement says that if
  cards[cardOneIndex] doesn't equal null and cards[cardTwoIndex] doesn't equal null (null would mean there is no card present) and cardOneIndex
  doesn't equal cardTwoIndex, then Card tempCard is created and initialized to cards[cardOneIndex]. cards[cardTwoIndex] is assigned to
  cards[cardOneIndex]. Then, tempCard is assigned to cards[cardTwoIndex]. This swapping will randomly shuffle the cards into different places
  the array cards. works is set to true so that it can break out of the while loop.

  An else statement states that in any other case, rand.nextInt(52) is assigned to cardOneIndex and rand.nextInt(52) is assigned to cardTwoIndex.
  This else loop will be reached in the case that either cards[cardOneIndex] equals null, cards[cardTwoIndex] equals null, or cardOneIndex equals
  cardtwoIndex. The while loop will repeat until it the conditions of the first if statement are met.
  */
  public void shuffle()
  {
    int len = cards.length;
    Random rand = new Random();
    boolean works = false;

    for(int i = len; i > 1; i--)
    {
      works = false;
      int cardOneIndex = rand.nextInt(52);
      int cardTwoIndex = rand.nextInt(52);

      while(works == false)
      {
        if(cards[cardOneIndex] != null && cards[cardTwoIndex] != null && cardOneIndex != cardTwoIndex)
        {
          Card tempCard = cards[cardOneIndex];
          cards[cardOneIndex] = cards[cardTwoIndex];
          cards[cardTwoIndex] = tempCard;
          works = true;
        }

        else
        {
          cardOneIndex = rand.nextInt(52);
          cardTwoIndex = rand.nextInt(52);
        }
      }
    }
  }

  /*Card method drawNextCard() has one parameter (int r), meant to take int rounds in the client code (see Casino.java). r will go up to 26 to see
  if there are any cards left to pick. 26 means 26 rounds have been played, and 52 cards have been picked (2 cards per round).
  Card nextCard is declared and initialized to null.

  An if statement states that if r is less then 26, then it leads to a for loop, which is initialized to int i equals 0, i is less than
  cards.length, and i++. An if statement states that if cards[i] does not equal null (meaning cards[i] hasn't been drawn yet),
  then cards[i] is assigned to next card. null is assigned to cards[i] to indicate that the card has been removed from the deck by a player.
  nextCard is returned and the for loop and entire method stop. This for loop will repeat until it finds a card that hasn't been drawn.

  An else if statement states that if r is greater than or equal to 26 (indicating an empty deck), then int index is delcared and initialized to 0.
  A for loop is created and initlialized with int i equals 0, i is less than values.length, and i++.

  An inner for loop is created and initialized to int j equals 0, j is less than suits.length, and j++.
  A new card object is created with a numeric value from values[i] and a suit from suits[j] and assigned to cards[index].
  index is incremented by 1. Every iteration of this inner for loop will create one of the 4 suits for a one card card value.
  It will repeat 4 times per card (or values[i]). index is incremented by 1. Both these for loops work to create another deck of complete cards.
  (.clone() didn't work here for some reason, so I made the constructor over).

  discardPile invokes new Card to be made into a new 52 space long array of type card, with all of it's elements as null. The shuffle()
  method is called upon to shuffle the remade deck. cards[0] is assigned to nextCard as the next card to be drawn. null is assigned to cards[0],
  to indicate that it has been chosen. nextCard is returned to the method.
  */
  public Card drawNextCard(int r)
  {
    Card nextCard = null;

    if(r < 26)
    {
      for(int i = 0; i < cards.length; i++)
      {
        if(cards[i] != null)
        {
          nextCard = cards[i];
          cards[i] = null;
          return nextCard;
        }
      }
    }

    else if(r >= 26)
    {
      int index = 0;
      for(int i = 0; i < values.length; i++) {
        for(int j = 0; j < suits.length; j++) {
         cards[index] = new Card(values[i], suits[j]);
         index++;
        }
      }
      discardPile = new Card[52];
      shuffle();
      nextCard = cards[0];
      cards[0] = null;
    }
    return nextCard;
  }

  /*void method discard(): has one parameter, Card c, which will be the card to be discarded.
  A for loop is created and initialized to i equals 0, i is less than discardPile.length, and i++.
  An if statement states that if discardPile[i] equals null (indicating a blank space in the discard pile and that
  a card can be place there), then c is assigned to discardPile[i] as a card out of the main deck.
  discardPile.length is then assigned to i to stop the loop as Card c has be discarded. This loop will repeat until it
  has found an empty spot to put Card c.  
  */
  public void discard(Card c)
  {
    for(int i = 0; i < discardPile.length; i++)
    {
      if(discardPile[i] == null)
      {
        discardPile[i] = c;
        i = discardPile.length;
      }
    }
  }
}
