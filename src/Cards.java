import java.util.UUID; 

public class Cards {
    private int creditBalance; // Should be positive
    private int ticketBalance; // Game reward tickets
    private UUID cardNumber;   // Player Unique Card

    // Instantiating Card Class
    Cards() {
        UUID uuid = UUID.randomUUID(); 
        this.creditBalance = 0;
        this.ticketBalance = 0;  
        this.cardNumber = uuid;
    }
    
    // Get current credit balance
    public int getCurrentCredit() {
        return this.creditBalance;
    }

    // Get current ticket balance
    public int getCurrentTicket() {
        return this.ticketBalance;
    }

    // Get Card -> Print Card Details
    public void getCardDetails() {
        System.out.println("Card Details:");
        System.out.println("Credit Balance: " + this.creditBalance);
        System.out.println("Ticket Balance: " + this.ticketBalance);
        System.out.println("Card Number: " + this.cardNumber);
    }

    // Reduce Credit -> Reduce the creidt balance of the card.
    public void reduceCredit(double amount){
        if(creditBalance >= amount) creditBalance -= amount;   
    }

    // Reduce Ticket -> Reduce the ticket balance by getting rewards.
    public void reduceTicket(int amount){
        if (this.ticketBalance >= amount) this.ticketBalance -= amount;
    }

    // Add Credit -> Set credit by inputting amount of money
    // $1 -> 2credits
    public void setCredit(double amount){
        if (amount >= 0) creditBalance += (amount * 2);
        if (amount < 0) System.out.println("The amount should be positive!");
    }

    // Add Ticket -> Won tickets are added to remaining tickets.
    public void setTicket(int tickets){
        if (tickets > 0) this.ticketBalance += tickets;
    }

    // Transferred Credits from Card 1 to Card 2 (Vise Versa)
    public void setTransferredCredits(double credits) {
        this.creditBalance += credits;
    }

    // Transferred Tickets from Card 1 to Card 2 (Vise Versa)
    public void setTransferredTickets(double tickets) {
        this.ticketBalance += tickets;
    }
}