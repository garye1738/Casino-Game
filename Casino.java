/* Name: Gabriel Arye
   Email: gabrielarye@brandeis.edu
   Date: December 9, 2018
   PA7, Casino Class: Program tells the user that they will play a game of simple war. The program prompts the user for
   how much money they want to play with, then it will draw cards and play the game with the user until either the
   user says they want to stop, or if the user has 0 dollars or negative dollars.
   Bugs: None. Note: See README.txt file for comments on this method.
*/

import java.util.*;
import java.io.*;

public class Casino
{
  public static void main(String[] args)
  {
    simpleWar();
  }

  public static void simpleWar()
  {
    Scanner console = new Scanner(System.in);
    System.out.println("Hey there buddy! Welcome to Antonella's Cyber Casino! \nWell, it's not really a true casino. We only have one game (Simple War), since the author had too many \npaper's and finals due to make Black Jack. Anyway, let's play some Simple War!");
    System.out.println("How much money do you have to play with? The more money you have, the longer you can play: ");
    double bank = console.nextDouble();
    double bet = 0;
    String procede = "yes";
    int rounds = 0;

    Deck warDeck = new Deck();

    Card userCard = null;
    Card compCard = null;

    while(procede.substring(0, 1).equals("y"))
    {
      System.out.println();
      System.out.println("How much money would you like to bet this round? ");
      bet = console.nextDouble();

      userCard = warDeck.drawNextCard(rounds);

      if(rounds == 26)
      {
        rounds = 0;
      }

      compCard = warDeck.drawNextCard(rounds);
      rounds++;

      if(userCard.getValue() > compCard.getValue())
      {
        System.out.println("Nice! You won this round! You have a " + userCard.toString() + " and I have a "  + compCard.toString() + ".");
        bank += bet;
      }

      else if(userCard.getValue() < compCard.getValue())
      {
        System.out.println("Tough luck! You lost this round! I have a "  + compCard.toString() + " and you have a "  + userCard.toString() + ".");
        bank -= bet;
      }

      else if(userCard.getValue() == compCard.getValue())
      {
        System.out.println("Tough luck! You lost this round! I have a "  + compCard.toString() + " and you have a "  + userCard.toString() + ". \nOur cards have the same values, but I win because Antonella's Cyber Casino is superior (and we need money to pay off the tuition debts of the TAs).");
        bank -= bet;
      }
      //System.out.println(rounds);

      warDeck.discard(userCard);
      warDeck.discard(compCard);
      System.out.println();

      if(bank == 0)
      {
        System.out.printf("Excuse me, sir? SIR! You are out of money. You currently have %.2f dollars in your account here.\nI'm going to have to kick you out. Please, do come back when you have more money. See you later!\n", bank);
        procede = "stop";
      }

      else if(bank < 0)
      {
        System.out.printf("Excuse me, sir? SIR! You are out of money. You are currently %.2f dollars in debt with your account here.\nI'm going to have to kick you out. Please, do come back when you have more money and you can pay us back. See you later!\n", bank);
        procede = "stop";
      }

      else if(bank > 0)
      {
        System.out.printf("You currently have %.2f dollars in your account here. Would you like to continue? Say either \"yes\" or \"no\": \n", bank);
        procede = console.next().toLowerCase();
      }
    }

    if(procede.substring(0, 1).equals("n"))
    {
      System.out.println();
      System.out.printf("Enjoy your winnings! You are leaving with %.2f dollars! Come back soon to Antonella's Cyber Casino!\n", bank);
    }
  }
}
