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
        Player dealer = new Player("dealer");
        Deck deck = new Deck();
        
        //Dealing first Card, dealer's is hidden
        deck.shuffle();
        /** */
        player.giveCard(deck.draw());
        //System.out.println("\n" + player.showHand(nickname));

        dealer.giveCard(deck.draw());
        //System.out.println("\n" + "Dealer: " + "\n" + "Hidden");
        
      //  if (cheatOn)
        // {System.out.println("(?)");}
        // System.out.println("\n" + "One more card!" + "\n");
        
        //Second card is dealt
        player.giveCard(deck.draw());
        System.out.println(player.showHand(nickname));
        if (cheatOn)
        {
            System.out.println("(" + player.getSum() + ")");
        }

        holdCard = deck.draw();
        System.out.println("\n" + "Dealer: " + "\n" + "Hidden" + "\n" + dealer.giveCard(holdCard));
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
                System.out.println("\n" + player.showHand(nickname));
                if (cheatOn)
                {
                    System.out.println("(" + player.getSum() + ")" + "\n");
                }
                
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
                System.out.println(nickname + " stands with " + player.getSum() + "\n");
            }
        } while (input.equalsIgnoreCase("hit") && !gameOver);

        if (gameOver)
        {
            System.out.println();
            System.exit(0);
        }
        //Dealer's turn
        System.out.println(dealer.showHand("Dealer"));
        System.out.println("(" + dealer.getSum() + ")");
        do {
            System.out.println(dealer.giveCard(deck.draw()));
            if (dealer.getSum() == 21)
            {
                System.out.println("Blackjack! Dealer wins this time");
                gameOver = true;
            }
            else if (dealer.getSum() > 21)
            {
                System.out.println("Dealer busted! You win!");
                gameOver = true;
            }

        }while (dealer.getSum() < 17 && !gameOver);

        if (gameOver)
        {   System.out.println();
            System.exit(0);}

        System.out.println("(" + dealer.getSum() +")");
        System.out.println("\n" + "Dealer: " + "(" + dealer.getSum() + ")");

        //Hand comparison
        System.out.println(nickname + " : " + "(" + player.getSum() + ")" + "\n");
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
        System.exit(0);
    }
}