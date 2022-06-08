import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {
    static Cards card1 = new Cards();
    static Cards card2 = new Cards();
    static Cards currentCard = card1;
    private Games games = new Games();
    private Terminals terminal = new Terminals();
    private PrizeCategories prizeCategories = new PrizeCategories();

    public static void main(String[] args) throws Exception {
        Test test = new Test();

        // Loop
        while(true) test.playArcade();
    }

    // Invoke player's chosen action
    public void playArcade() {
        String selectedOption = getAction();

        switch(selectedOption) {
            case "1" -> { arcadeGame(); }
            case "2" -> { showCategories(); }
            case "3" -> { terminals(); }
            case "4" -> { exit(); }
        }
    }

    // Arcade Game Options
    public void arcadeGame() {
        Scanner inArcadeGame = new Scanner(System.in);
        System.out.println("\n########################################################################################################\n");
        System.out.println("Select your game: ");
        System.out.println("[1] => Rock, Paper, and Scissor! (5 Credits)");
        System.out.println("[2] => Guess Number! (3 Credits)");
        System.out.println("[3] => Color Game! (4 Credits)");
        System.out.println("[4] => Back");
        System.out.print("Choose a number: ");
        String game = inArcadeGame.nextLine();

        while(!Pattern.compile("^(1|2|3|4)$").matcher(game).find()) {
            System.out.println("Your input is invalid!\n");
            System.out.println("Select your game: ");
            System.out.println("[1] => Rock, Paper, and Scissor! (5 Credits)");
            System.out.println("[2] => Guess Number! (3 Credits)");
            System.out.println("[3] => Color Game! (4 Credits)");
            System.out.println("[4] => Back");
            System.out.print("Choose a number: ");
            game = inArcadeGame.nextLine();
        }

        switch(game) {
            case "1" -> { startRPS(); }
            case "2" -> { startNumberGuessing(); }
            case "3" -> { startColorGame(); }
            case "4" -> { playArcade(); }
        }
    }

    // Rock Paper Scissor Game
    public void startRPS() {
        if(currentCard.getCurrentCredit() > 5) {
            currentCard.reduceCredit(5);

            Games.Rps rpsGame = games.new Rps();

            rpsGame.startRps();
            currentCard.setTransferredTickets(rpsGame.getTicket());
            System.out.println();
            currentCard.getCardDetails();
        } else {
            System.out.println("You have insufficient credit balance, please top-up!");
        }
    }

    // Color Game
    public void startNumberGuessing() {
        if(currentCard.getCurrentCredit() > 3) {
            currentCard.reduceCredit(3);
            Games.GuessNumber guessNumber = games.new GuessNumber();
            guessNumber.startGuessNumber();
            currentCard.setTransferredTickets(guessNumber.getTicket());
            currentCard.getCardDetails();
        } else {
            System.out.println("You have insufficient credit balance, please top-up!");
        }
    }

    // Color Game
    public void startColorGame() {
        if(currentCard.getCurrentCredit() > 4) {
            currentCard.reduceCredit(4);
            Games.ColorGame colorGame = games.new ColorGame();
            colorGame.startColorGame();
            currentCard.setTransferredTickets(colorGame.getTicket());
            currentCard.getCardDetails();
        } else {
            System.out.println("You have insufficient credit balance, please top-up!");
        }
    }

    // Prize Categories and ticket requirements
    public void showCategories() {
        System.out.println("\n########################################################################################################\n");
        
        currentCard.getCardDetails();

        Scanner inPrizeCategories = new Scanner(System.in);
        System.out.println("\n[1]: Pikachu Stuffed Toy (Small Size) => 10 Tickets");
        System.out.println("[2]: Doraemon Stuffed Toy (Medium Size) => 50 Tickets");
        System.out.println("[3]: Big Charmander Stuffed Toy (Large Size) => 100 Tickets");
        System.out.println("[4]: Back");
        System.out.print("Choose a number: ");
        String option = inPrizeCategories.nextLine();

        while(!Pattern.compile("^(1|2|3|4)$").matcher(option).find()) {
            System.out.println("Your input is invalid!\n");
            System.out.println("Prize Option: ");
            System.out.println("[1]: Pikachu Stuffed Toy (Tickets: 10)");
            System.out.println("[2]: Doraemon Stuffed Toy (Tickets: 50)");
            System.out.println("[3]: Big Charmander Stuffed Toy (Tickets: 100)");
            System.out.print("Choose a number: ");
            option = inPrizeCategories.nextLine();
        }

        prizeCategories.getPrize(option);
    }

    // Terminal
    public void terminals() {
        System.out.println("\n########################################################################################################\n");
        Scanner inTerminals = new Scanner(System.in);
        System.out.println("Select your game: ");
        System.out.println("[1] => Change Card");
        System.out.println("[2] => Transfer Credit & Tickets");
        System.out.println("[3] => Add Credits");
        System.out.println("[4] => Check Card Balance");
        System.out.println("[5] => Back");
        System.out.print("Choose a number: ");
        String option = inTerminals.nextLine();

        while(!Pattern.compile("^(1|2|3|4|5)$").matcher(option).find()) {
            System.out.println("Your input is invalid!\n");
            System.out.println("Select your game: ");
            System.out.println("[1] => Change Card");
            System.out.println("[2] => Transfer Credit & Tickets");
            System.out.println("[3] => Add Credits");
            System.out.println("[4] => Check Card Balance");
            System.out.println("[5] => Back");
            System.out.print("Choose a number: ");
            option = inTerminals.nextLine();
        }

        switch(option) {
            case "1" -> { terminal.changeCard(); }
            case "2" -> { terminal.transferCT(); }
            case "3" -> { terminal.addCredit(); }
            case "4" -> { terminal.getCardBalance(); }
            case "5" -> { playArcade(); }
        }
    }

    // Exit Arcade
    public void exit() {
        System.out.println("Thank you for coming and playing in our arcade! We hope you'll enjoy and come back here soon.");
        System.exit(0);
    }

    // Promt user to enter actions
    public String getAction() {
        Scanner in_action = new Scanner(System.in);
        System.out.println("\n########################################################################################################\n");
        System.out.println("[1] => Games");
        System.out.println("[2] => Prize Categories");
        System.out.println("[3] => Terminals");
        System.out.println("[4] => Exit");
        System.out.print("Choose a number: ");
        String action = in_action.next();

        while(!Pattern.compile("^(1|2|3|4)$").matcher(action).find()) {
            System.out.println("Your input is invalid!\n");
            System.out.println("[1] => Games");
            System.out.println("[2] => Prize Categories");
            System.out.println("[3] => Terminals");
            System.out.println("[4] => Exit");
            System.out.print("Choose a number: ");
            action = in_action.nextLine();
        }

        return action;
    }
}