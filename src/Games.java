import java.util.*;
import java.util.regex.Pattern;

public class Games {
    public class Rps {
        private int scorePlayer = 0;
        private int scoreComputer = 0;
        private String[] choice= {"ROCK", "PAPER", "SCISSOR"};
        private String winnerPlayer = "";
    
        // Instantiating Class
        Rps() {
            System.out.println("\n########################################################################################################");
            System.out.println("# WELCOME TO ROCK, PAPER, SCISSOR GAME!                                                                #");
            System.out.println("# Description: You need to win against the computer, the first player who reach 3points win the game!  #");
            System.out.println("# Prizes:                                                                                              #");
            System.out.println("# If you win: 10 tickets                                                                               #");
            System.out.println("# If you lose: 5 tickets                                                                               #");
            System.out.println("########################################################################################################\n");
    
            System.out.println("--- GAME HAS BEEN STARTED! ---");
        }
    
        // Start the RPS Game
        public void startRps() {
            Scanner in = new Scanner(System.in);
            
            while(winnerPlayer.equals("")) {
                String computerResponse = computerChoice();
    
                System.out.print("\n########################################################################################################\n");
                System.out.print("\nYour response (Rock, Paper, Scissor): ");
                String playerResponse = in.nextLine().toUpperCase();
    
                while(!Pattern.compile("^(ROCK|PAPER|SCISSOR)$").matcher(playerResponse).find()) {
                    System.out.println("Your response is invalid!\n");
                    System.out.print("Your response (Rock, Paper, Scissor): ");
                    playerResponse = in.nextLine().toUpperCase();
                }
    
                System.out.println("You choose: " + playerResponse);
                System.out.println("Computer choose: " + computerResponse);
                getDecision(playerResponse, computerResponse);
    
                getWinner();
            }
        }
    
        // Get the computer choice
        public String computerChoice() {
            Random random = new Random();
            String response = choice[random.nextInt(3)];
            return response;
        }
    
        // Make decision for winners
        public void getDecision(String playerResponse, String computerResponse) {
            if(playerResponse.equals(computerResponse)) {
                System.out.println("\nResult: Tie Game!");
            } else {
                switch(playerResponse) {
                    case "ROCK" -> {
                        if(computerResponse.equals("PAPER")) {
                            this.scoreComputer += 1;
                            System.out.println("\nResult: Computer win!");
                        }
    
                        if(computerResponse.equals("SCISSOR")) {
                            this.scorePlayer += 1;
                            System.out.println("\nResult: You win!");
                        }
                    }
                    case "PAPER" -> {
                        if(computerResponse.equals("ROCK")) {
                            this.scorePlayer += 1;
                            System.out.println("\nResult: You win!");
                        }
    
                        if(computerResponse.equals("SCISSOR")) {
                            this.scoreComputer += 1;
                            System.out.println("\nResult: Computer win!");
                        }
                    }
                    case "SCISSOR" -> {
                        if(computerResponse.equals("ROCK")) {
                            this.scoreComputer += 1;
                            System.out.println("\nResult: Computer win!");
                        }
    
                        if(computerResponse.equals("PAPER")) {
                            this.scorePlayer += 1;
                            System.out.println("\nResult: You win!");
                        }
                    }
                }
            }
        }
    
        // Get winner of the game
        public void getWinner() {
            System.out.println("Player Score: " + this.scorePlayer);
            System.out.println("Computer Score: " + this.scoreComputer);
    
            if(this.scorePlayer == 3) {
                System.out.println("\nCongratulations! You are the winner!");
                System.out.println("You won 10 tickets!");
                winnerPlayer = "Player";
                System.out.print("\n########################################################################################################\n");
            }
    
            if(this.scoreComputer == 3) {
                System.out.println("\nBetter luck next time! The winner is Computer");
                System.out.println("You won 5 tickets!");
                winnerPlayer = "Computer";
                System.out.print("\n########################################################################################################\n");
            }
        }
        
        // Get the prize ticket
        public int getTicket() {
            if(winnerPlayer.equals("Player")) {
                return 10;
            }
    
            if(winnerPlayer.equals("Computer")) {
                return 5;
            }
    
            return 0;
        }
    }

    public class GuessNumber {
        private int scorePlayer = 0;
        private int round = 1;
    
        // Instantiating Class
        GuessNumber() {
            System.out.println("\n########################################################################################################");
            System.out.println("# WELCOME TO GUESS NUMBER!                                                                             #");
            System.out.println("# Description: You need to guess a number from 1 to 5, you have 5 rounds!                              #");
            System.out.println("# Prizes:                                                                                              #");
            System.out.println("# If you guess correct number you'll win 5 tickets each rounds.                                        #");
            System.out.println("########################################################################################################\n");
            System.out.println("--- GAME HAS BEEN STARTED! ---");
        }
    
        // Start the Guess Number Game
        public void startGuessNumber() {
            Scanner in = new Scanner(System.in);
            
            while(round <= 5) {
                System.out.print("\n########################################################################################################\n");
                System.out.print("\nGuess a number (1-5): ");
                String playerGuess = in.nextLine();
                String randomNumber = randomNumbers();
    
                while(!Pattern.compile("^(1|2|3|4|5)$").matcher(playerGuess).find()) {
                    System.out.println("Your guess is invalid!\n");
                    System.out.print("Guess a number (1-5): ");
                    playerGuess = in.nextLine();
                }
    
                if(playerGuess.equals(randomNumber)) {
                    scorePlayer += 1;
                    System.out.println("Random Number: " + randomNumber);
                    System.out.println("Result: Your guess is correct!");
                } else {
                    System.out.println("Random Number: " + randomNumber);
                    System.out.println("Result: Your guess is incorrect!");
                }
    
                round++;
            }
        }
    
        // Get Random Numbers
        public String randomNumbers() {
            Random random = new Random();
            String result = String.valueOf(random.nextInt(5)+1);
            return result;
        }
    
        // Get tickets won
        public int getTicket() {
            return scorePlayer *= 5;
        }
    }

    public class ColorGame {
        private String[] choice = {"RED", "BLUE", "YELLOW", "WHITE"};
        private int round = 0;
        private int ticket = 0;
    
        // Instantiating Class
        ColorGame() {
            System.out.println("\n########################################################################################################");
            System.out.println("# WELCOME TO COLOR GAME!                                                                               #");
            System.out.println("# Description: You need to guess a color from RED, BLUE, YELLOW, and WHITE. You have 5 attempts!       #");
            System.out.println("# Prizes:                                                                                              #");
            System.out.println("# If guess is correct you will win 5 tickets!                                                          #");
            System.out.println("# If guess is incorrect you will win 1 tickets!                                                        #");
            System.out.println("########################################################################################################\n");
    
            System.out.println("--- GAME HAS BEEN STARTED! ---");
        }
    
        // Start the Color Game
        public void startColorGame() {
            Scanner inGuessNumber = new Scanner(System.in);
            
            while(round < 5) {
                System.out.print("\n########################################################################################################\n");
                System.out.print("\nGuess a color (RED, BLUE, YELLOW, WHITE): ");
                String playerColor = inGuessNumber.nextLine().toUpperCase();
                String randomColors = randomColors();
    
                while(!Pattern.compile("^(RED|BLUE|YELLOW|WHITE)$").matcher(playerColor).find()) {
                    System.out.println("Your guess is invalid!\n");
                    System.out.print("\nGuess a color (RED, BLUE, YELLOW, WHITE): ");
                    playerColor = inGuessNumber.nextLine().toUpperCase();
                }
    
                if(playerColor.equals(randomColors)) {
                    ticket += 1;
                    System.out.println("Random Color: " + randomColors);
                    System.out.println("Result: Your color guess is correct!");
                } else {
                    System.out.println("Random Color: " + randomColors);
                    System.out.println("Result: Your color guess is incorrect!");
                }
    
                round++;
            }
        }
    
        // Get Random Colors
        public String randomColors() {
            Random random = new Random();
            String result = choice[random.nextInt(4)];
            return result;
        }
    
        // Get tickets won
        public int getTicket() {
            return ticket *= 5;
        }
    }
}
