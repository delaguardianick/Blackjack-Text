import java.util.Scanner;

public class Blackjack
{
    public static void main(String[] args) {
        String nickname ;
        Scanner scanner = new Scanner(System.in);
        Boolean cheatOn;
        String input;
        Card holdCard;

        //Asks for name
        System.out.println("Please insert a nickname:");
        nickname = scanner.nextLine();

        //cheating?
        System.out.println("Would you like to display the sum? (y/n)");
        input = scanner.nextLine();
        System.out.println();
        if (input.equals("n"))
        {
            cheatOn = false;
        }
        else {cheatOn = true ;}

        //Game restarts here when asked for new game
        do {
            System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n");

            Boolean gameOver = false;
            System.out.println("\n" + "A new game has begun:" + "\n");

            //Initiates players and deck
            Player player = new Player(nickname);
            Player dealer = new Player("Dealer");
            Deck deck = new Deck();
            
            //Shuffle deck
            deck.shuffle();
        
            //Give first cards to player and dealer
            player.giveCard(deck.draw());
            dealer.giveCard(deck.draw()); // Will be hidden
            player.giveCard(deck.draw());

            System.out.println(player.showHand(cheatOn));

            //Checks if cheat is on and if so, prints the total value of the hand

            // As the first card the dealer receives is hidden to the the player,
            // I can't use the function showHand() as it will also show the hidden card.
            holdCard = deck.draw();
            System.out.println("\n" + "Dealer: " + "\n" + "Hidden" + "\n" + dealer.giveCard(holdCard));
        
            // Can't use checkCheat() either because it would display the value of the hidden card
            if (cheatOn)
            {
            System.out.println("(" + holdCard.getFace().getValue() + ")");
            }
            
            //in case of immediate blackjack with 2 initial cards.
           if (player.isBlackjack() == true)
            {
                System.out.println("\n" + "Blackjack! You win!");
                gameOver = true;
            }

            //Loops the "hit"
            do{  

                //Player's turn
                //checks that input is either "hit" or "stand"
                do {
                    System.out.println("\n" + "Would you like one more card? (hit/stand)");
                    input = scanner.nextLine();
                }while(!input.equalsIgnoreCase("hit") && !input.equalsIgnoreCase("stand"));

                //Player Hit
                if (input.equalsIgnoreCase("hit"))
                {
                    player.giveCard(deck.draw());
                    System.out.println("\n" + player.showHand(cheatOn));

                    //Player Bust
                    if (player.getSum() > 21)
                    {
                        gameOver = true;
                        System.out.println("\n" + "You busted! Sorry, dealer wins.");
                    }
                    //Player Blackjack
                    else if (player.getSum() == 21)
                    {
                        if (player.isBlackjack() == true)
                        {
                            System.out.println("\n" + "Blackjack! You win!");
                            gameOver = true;
                        }
                    }
                }
                //Player Stand - doesn't loop
                else if (input.equalsIgnoreCase("stand"))
                {
                    System.out.println("\n" + nickname + " stands with (" + player.getSum() + ")" + "\n");
                }
            } while (input.equalsIgnoreCase("hit") && !gameOver); // loops this part as long as input is "hit" and not a game over

            //Dealer's turn
            //Prints initial dealer's hand without hidden card
            if (gameOver == false)
            {
                System.out.println(dealer.showHand(cheatOn));
                if (dealer.isBlackjack() == true)
                {
                    System.out.println("\n" + "Blackjack - Dealer wins");
                }
                    
            }     
            
            //Dealer hits if his hand sums at least 16, if not stand
            while(dealer.getSum() < 17 && gameOver == false)
                {
                    System.out.println(dealer.giveCard(deck.draw()));
                    System.out.println(dealer.checkCheat(cheatOn));

                    if (dealer.getSum() == 21)
                    {   
                        System.out.println("\n" + "21 - Dealer wins");
                        gameOver = true;
                    }
                    else if (dealer.getSum() > 21)
                    {
                        System.out.println("\n" + "Dealer busted! You win!");
                        gameOver = true;
                    }
                }

            //Hand comparison 
            if(!gameOver)
            {    
                System.out.println("\n" + "Dealer: " + "(" + dealer.getSum() + ")");
                System.out.println(nickname + " : " + "(" + player.getSum() + ")");

                if (dealer.getSum() > player.getSum())
                {
                    System.out.println("Sorry! Dealer wins");
                }
                else if (dealer.getSum() < player.getSum())
                {
                    System.out.println("Congratulations! You win!");
                }
                else 
                {
                    System.out.println("You tied!");
                }
            }

            //New Game?
            System.out.println();
            System.out.println("Would you like to start a new game?  'y/n' :");
            do {
                input = scanner.nextLine();
            } while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n"));

        }while (input.equalsIgnoreCase("y"));

    //Closing scanner
    scanner.close();    }
}