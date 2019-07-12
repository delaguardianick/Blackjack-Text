import java.util.Scanner;

public class Blackjack
{
    public static void main(String[] args) {
        String nickname ;
        Scanner scanner = new Scanner(System.in);
        Boolean gameOver = false;
        Boolean cheatOn;
        String input;
        Card holdCard;

        System.out.println("Please insert a nickname:");
        nickname = scanner.nextLine();
        do {
        System.out.println("\n" + "A new game has begun:" + "\n");

        System.out.println("Would you like to display the sum? (y/n)");
        input = scanner.nextLine();
        System.out.println();
        if (input.equals("y"))
        {
            cheatOn = true;
        }
        else {cheatOn = false ;}

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
        //System.out.println(player.checkCheat(cheatOn));

        // As the first card the dealer receives is hidden to the the player,
        // I can't use the function showHand() as it will also show the hidden card.
        holdCard = deck.draw();
        System.out.println("\n" + "Dealer: " + "\n" + "Hidden" + "\n" + dealer.giveCard(holdCard));
       
        // Can't use checkCheat() either because it would display the value of the hidden card
        if (cheatOn)
        {
        System.out.println("(" + holdCard.getFace().getValue() + ")");
        }
       
       //Player's turn
        do{  
            do {
            System.out.println("\n" + "Would you like one more card? (hit/stand)");
            input = scanner.nextLine();
            }while(!input.equalsIgnoreCase("hit") && !input.equalsIgnoreCase("stand"));

            //Hit
            if (input.equalsIgnoreCase("hit"))
            {
                player.giveCard(deck.draw());
                System.out.println("\n" + player.showHand(cheatOn));
                
                //Player Bust
                if (player.getSum() > 21)
                {
                    gameOver = true;
                    System.out.println("You busted! Sorry, dealer wins.");
                }
                //Player Blackjack
                else if (player.getSum() == 21)
                {
                    System.out.println("Blackjack! You win!");
                    gameOver = true;
                }
            }
            //Stand
            else if (input.equalsIgnoreCase("stand"))
            {
                System.out.println("\n" + nickname + " stands with " + player.getSum() + "\n");
            }
        } while (input.equalsIgnoreCase("hit") && !gameOver);

        //Exit if gameOver for player
        if (gameOver)
        {
            System.out.println();
            System.exit(0);
        }

        //Dealer's turn
        System.out.println(dealer.showHand(cheatOn));
        
        while(dealer.getSum() < 17 && gameOver == false)
            {
                System.out.println(dealer.giveCard(deck.draw()));
                System.out.println(dealer.checkCheat(cheatOn));

                if (dealer.getSum() == 21)
                {
                    System.out.println("\n" + "Blackjack! Dealer wins this time");
                    gameOver = true;
                }
                else if (dealer.getSum() > 21)
                {
                    System.out.println("\n" + "Dealer busted! You win!");
                    gameOver = true;
                }
            }

        //Exit if gameOver for dealer
        if (gameOver)
        {   System.out.println();
            System.exit(0);
        }
        
        //Hand comparison 
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

        System.out.println();
        System.out.println("Would you like to start a new game?  'y/n' :");
        do {
            input = scanner.nextLine();
        } while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n"));

        }while (input.equalsIgnoreCase("y"));
    // tidy up
    scanner.close();    }
}