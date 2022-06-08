import java.util.Scanner;
import java.util.regex.Pattern;

public class Terminals {
    // Change Card
    public void changeCard() {
        Scanner inChangeCard = new Scanner(System.in);
        System.out.println("\n########################################################################################################\n");
        System.out.println("Card #1");
        Test.card1.getCardDetails();
        System.out.println("\nCard #2");
        Test.card2.getCardDetails();
        System.out.println("\nSelect Card:");
        System.out.println("[1] => Card 1");
        System.out.println("[2] => Card 2");
        System.out.print("Choose a number: ");
        String card = inChangeCard.nextLine();

        while(!Pattern.compile("^(1|2)$").matcher(card).find()) {
            System.out.println("Your input is invalid!\n");
            System.out.println("Select Card:");
            System.out.println("[1] => Card 1");
            System.out.println("[2] => Card 2");
            System.out.print("Choose a number: ");
            card = inChangeCard.nextLine();
        }

        if(card.equals("1")) Test.currentCard = Test.card1;
        if(card.equals("2")) Test.currentCard = Test.card2;

        Test.currentCard.getCardDetails();
    }

    // Transfer Credit or Tickets
    public void transferCT() {
        System.out.println("\n########################################################################################################\n");
        System.out.println("Card #1");
        Test.card1.getCardDetails();

        System.out.println("\nCard #2");
        Test.card2.getCardDetails();

        Scanner inTransferCT = new Scanner(System.in);

        if(Test.currentCard == Test.card1) {
            System.out.print("\nEnter amount of credits to transfer to Card 2: ");
            String credits = inTransferCT.nextLine();

            while(!Pattern.compile("^[0-9]+$").matcher(credits).find()) {
                System.out.println("Your input is invalid!\n");
                System.out.print("Enter amount of credits to transfer to Card 2: ");
                credits = inTransferCT.nextLine();
            }

            System.out.print("Enter amount of tickets to transfer to Card 2: ");
            String tickets = inTransferCT.nextLine();

            while(!Pattern.compile("^[0-9]+$").matcher(tickets).find()) {
                System.out.println("Your input is invalid!\n");
                System.out.print("Enter amount of tickets to transfer to Card 2: ");
                tickets = inTransferCT.nextLine();
            }

            if(Test.currentCard.getCurrentCredit() >= Integer.parseInt(credits)) { 
                Test.currentCard.reduceCredit(Integer.parseInt(credits));
                Test.card2.setTransferredCredits(Integer.parseInt(credits));
                System.out.println("Credits successfully transferred!");
            } else {
                System.out.println("Your input is greater than your card 1 credits!");
            }

            if(Test.currentCard.getCurrentTicket() >= Integer.parseInt(tickets)) { 
                Test.currentCard.reduceTicket(Integer.parseInt(tickets));
                Test.card2.setTransferredTickets(Integer.parseInt(tickets));
                System.out.println("Tickets successfully transferred!");
            } else {
                System.out.println("Your input is greater than your card 1 tickets!");
            }
        }

        if(Test.currentCard == Test.card2) {
            System.out.print("\nEnter amount of credits to transfer to Card 1: ");
            String credits = inTransferCT.nextLine();

            while(!Pattern.compile("^[0-9]+$").matcher(credits).find()) {
                System.out.println("Your input is invalid!\n");
                System.out.print("Enter amount of credits to transfer to Card 1: ");
                credits = inTransferCT.nextLine();
            }

            System.out.print("Enter amount of tickets to transfer to Card 1: ");
            String tickets = inTransferCT.nextLine();

            while(!Pattern.compile("^[0-9]+$").matcher(tickets).find()) {
                System.out.println("Your input is invalid!\n");
                System.out.print("Enter amount of tickets to transfer to Card 1: ");
                tickets = inTransferCT.nextLine();
            }  

            if(Test.currentCard.getCurrentCredit() >= Integer.parseInt(credits)) { 
                Test.currentCard.reduceCredit(Integer.parseInt(credits));
                Test.card1.setTransferredCredits(Integer.parseInt(credits));
                System.out.println("Credits successfully transferred!");
            } else {
                System.out.println("Your input is greater than your card 1 credits!");
            }

            if(Test.currentCard.getCurrentTicket() >= Integer.parseInt(tickets)) { 
                Test.currentCard.reduceTicket(Integer.parseInt(tickets));
                Test.card1.setTransferredTickets(Integer.parseInt(tickets));
                System.out.println("Tickets successfully transferred!");
            } else {
                System.out.println("Your input is greater than your card 1 tickets!");
            }
        }
    }

    // Add Credit or Load Credits
    public void addCredit() {
        System.out.println("\n########################################################################################################\n");
        Scanner inAddCredit = new Scanner(System.in);
        System.out.println("Note:\n$1 dollar = 2 game credits\n");
        System.out.print("Enter amount to load credits: ");
        String amount = inAddCredit.nextLine();

        while(!Pattern.compile("^[0-9]+$").matcher(amount).find()) {
            System.out.println("Your input is invalid!\n");
            System.out.print("Enter amount to load credits: ");
            amount = inAddCredit.nextLine();
        }

        Test.currentCard.setCredit(Integer.parseInt(amount));
        System.out.println("Successful transaction!\n");

        Test.currentCard.getCardDetails();
    }

    // Print card 1 and card 2 balance
    public void getCardBalance() {
        System.out.println("\n########################################################################################################\n");
        System.out.println("Card #1");
        Test.card1.getCardDetails();
        System.out.println("\nCard #2");
        Test.card2.getCardDetails();
    }
}
