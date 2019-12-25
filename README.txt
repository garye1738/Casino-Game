/* Name: Gabriel Arye
   Email: gabrielarye@brandeis.edu
   Date: December 9, 2018
   PA7, README.txt: Contains program design choices for objects and Main Client code (which is what is in Casino.java).
   Also contains comments for Main client code (Casino.java).
*/

README.txt

Casino.java Comments:

main method: calls the void method simpleWar() and then ends.

void method simpleWar(): Creates a Scanner object (console) and invokes new Scanner to take input from the
standard input (keyboard). A print statement tells the user they are playing war. Another print statement asks the
user how much money they want to play with. console then assigns the user's input to double bank (using console.nextDouble()).
bank is a double so that the user can bet cents if they want to. double bet is declared and initialized as 0.
String procede is declared and initialized as "yes". int rounds is declared and initialized as 0.

Deck warDeck is delcared and invoked as a new Deck(). Card userCard is declared and initialized to null. It will represent the card that the user draws each round.
Card compCard is declared and initialized to null as well. It will represent the card that the computer draws each round.

A while loop has the condition that while procede.substring(0, 1) equals "y" (indicating yes), then it will lead to a println statement
for spacing. After this, a print statement prompts the user for how much money they would like to bet that round. console then assigns the
user input to bet using nextDouble(). warDeck.drawNextCard(rounds) is called to draw a card from warDeck, and the resulting card is then
assigned to userCard. This is the user drawing a card from warDeck, the deck of cards.

Then, an if statement states that if rounds equals 26 (indicating that there are no more cards in the deck), then rounds is set to 0
so the incrementation process of it can start over again with every iteration of the previous while loop. warDeck.drawNextCard(rounds)
is called to draw a card from warDeck, and the resulting card is then assigned to compCard. This is the user drawing a card from warDeck
rounds is then incremented by 1 to signal the pass of one round.

An if statement states that if userCard.getValue() is greater than compCard.getValue(), then a print statement tells the user that they won as they got a
card with a higher value than that of the computer's. bank is incremented by the user's bet to indicate the win.

An else if statement states that if userCard.getValue() is less than compCard.getValue(), then a print statement tells the user that lost as they got a
card with a lower value than that of the computer's. bank is decremented by the user's bet to indicate the loss.

An else if statement states that if userCard.getValue() is equal to compCard.getValue(), then a print statement tells the user that lost as they got a
card with an equal value to that of the computer's, and the computer wins since the dealer has priority over the player. bank is decremented by the user's
bet to indicate the loss.

warDeck.discard(userCard) is called upon to put the user's card into the discard pile. warDeck.discard(compCard) is called upon to put computer's card
into the discard pile. A println statement is added for spacing.

An if statement states that if bank equals 0 (indicating that the user has run out of money), then a printf statement will tell the user that they are
out of money and are being kicked out of the casino. procede is set to "stop" to get out of the while loop.

An else if statement states that if bank is less than 0 (indicating that the user has run out of money and is in debt to the bank), then a printf statement
will tell the user that they are out of money and need to pay back the casino when they come back, and that they are being kicked out of the casino.
procede is set to "stop" to get out of the while loop.

An else if statement states that if bank is greater than 0, then a printf statement will tell the user how much money they currently have, and ask them if
the want to continue playing or not and answer with yes or no. console then assigns the user's input to procede using next().toLowerCase(). The while loop ends.

An if statement states that if procede.substring(0, 1) equals "n" (indicating the user has said "no,"" they want to stop playing), then a print statement is used
for spacing. A final printf statement tells the user the final value in their winnings, and to come back next time. The Casino class ends.


Design Choice Comments for Objects and Client Code:

In the Card class, I made the instance variable/objects of value, suit, and color all public so that any class or client code could access them.
The if statements in the Card constructor having to do with red and black being assigned to color are present as it would easy to assign a color to
a card based on its suit (hearts and diamonds are always red, clubs and spades always black). The if statements in the toString method are present to distinguish between
special cards (ace, jack, queen and king) as their names are different from their values. This way, their names could easily be concatenated to
the res String with their suit. Meanwhile, all values that aren't 1, 11, 12 or 13 will just be concatenated to the res String as they are with their suit.

In the Deck class, I made the instance objects of cards, discardPile, values, and suits public so that any class or client code could access them.
values contains numbers 1 to 13, and suits contains Strings called Hearts, Diamonds, Clubs and Spades. values and suits are here to be used in the deck constructor,
and make the process of constructing cards easier. in the Deck constructor (public Deck()), for loops are designed so that every suit of every card is added to
the array of cards. This seemed like a simple and efficient way to construct the card deck. I designed the shuffle() method in a way so that the shuffler won't replace one card
in card with itself, nor will it replace a null card with another card or null card. The for loop will ensure that every card is shuffled once. The while loop will ensure
that cards will attempt to be shuffled until they meet the conditions for shuffling (not null, two indexes aren't equal to each other). In that case, works is set
to true so the while loop is exited, and the process goes back to the for loop.

In the drawNextCard() method, I thought it would be efficient to add the int r parameter so that the method would be able to tell if there weren't any cards left in
the deck (if r == 26). If r is under 26, then a for loop would search for the next available card to pick from the deck and return that. When a card is found, it would be returned
after the card in the deck of cards was set to null to indicate it had been chosen. If r was equal to 26, then a new deck of cards would be made. I used a process similar to the one
I have in the constructor because clone() wouldn't work but this constructor worked. Discard discardPile would be set to a new array of Cards (all elements would be null), the deck
is shuffled the first card in the deck is assigned to nextCard, that first card in the deck becomes null, and nextCard would be returned. In the discard method, I thought it would
be efficient for a loop to go through the discard array and assign Card c to the first array element that was null and vacant. Once that was done, i would be set to cards
length so that the for loop would stop.

In the Casino class, design choices are explained in the comments above (lines 12 to 57). Most of the designs are just simple print statements, method calls, and Scanner objects and Scanner methods to interact with the user.
