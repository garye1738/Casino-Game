/* Name: Gabriel Arye
   Email: gabrielarye@brandeis.edu
   Date: December 9, 2018
   PA7, Card Class: Program creates a card class with card objects (each card having a value, suit, and color). It also has
   methods that can be used only by objects of the Card class. Used in the Deck class and the Casino class. These methods (getter
   methods), get the color, value, and suit of a card object, and there is a toString method as well.
   Bugs: None.
*/

import java.util.*;
import java.io.*;

/*public class Card: has three instance variables: public int value for the value of a card, public String suit for the suit of a card,
and public String color for the color of a card.
*/
public class Card
{
  public int value;
  public String suit;
  public String color;

  /*public Card(): has two paramters: int v and String s. This is a constructor for one card object that uses the instance variables above.
  v is assigned to value, and s is assigned to suit to construct these fields of a Card object.

  An if statement states that if s equals Hearts or if s equals Diamonds, then "red" wil be assigned to color. An else if statement states
  that if s equals Clubs or if s equals Spades, then "black" will be assigned to color.
  */
  public Card(int v, String s)
  {
    value = v;
    suit = s;

    if(s.equals("Hearts") || s.equals("Diamonds"))
    {
      color = "red";
    }

    else if(s.equals("Spades") || s.equals("Clubs"))
    {
      color = "black";
    }
  }

  /*String method getColor(): will return color.
  */
  public String getColor()
  {
    return color;
  }

  /*String method getSuit(): will return suit.
  */
  public String getSuit()
  {
    return suit;
  }

  /*int method getValue(): will return value.
  */
  public int getValue()
  {
    return value;
  }

  /*String method toString(): String res is declared and initialized as "". It will be used to print out the field values of a card object as a String
  An if statement states that if  the card value equals 1, then "Ace of " is concatenated with the card's suit and is assigned to res.

   An else if statement states that if the card value equals 11, then "Jack of " is concatenated with the card's suit and is assigned to res.

   An else if statement states that if the card value equals 12, then "Queen of " is concatenated with the card's suit and is assigned to res.

   An else if statement states that if the card value equals 13, then "King of " is concatenated with the card's suit and is assigned to res.

   An else statement states that in any other case,  is concatenated with " of " which is concatenated with the card's suit and this is assigned to res.
   res is returned to the method.
  */
  public String toString()
  {
    String res = "";

    if(value == 1)
    {
      res = "Ace of " + suit;
    }

    else if(value == 11)
    {
      res = "Jack of " + suit;
    }

    else if(value == 12)
    {
      res = "Queen of " + suit;
    }

    else if (value == 13)
    {
      res = "King of " + suit;
    }

    else
    {
      res = value + " of " + suit;
    }
    return res;
  }
}
