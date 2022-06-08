public class PrizeCategories {
    private String[] playerPrizeInventoryName = new String[3];
    private int[] playerPrizeInventoryQuantity = new int[3];
    private int[] arcadePrizeInventoryQuantity = new int[3];

    PrizeCategories() {
        this.playerPrizeInventoryName[0] = "Pikachu Stuffed Toy";
        this.playerPrizeInventoryName[1] = "Doraemon Stuffed Toy";
        this.playerPrizeInventoryName[2] = "Big Charmander Stuffed Toy";
        this.playerPrizeInventoryQuantity[0] = 0;
        this.playerPrizeInventoryQuantity[1] = 0;
        this.playerPrizeInventoryQuantity[2] = 0;

        this.arcadePrizeInventoryQuantity[0] = 20;
        this.arcadePrizeInventoryQuantity[1] = 20;
        this.arcadePrizeInventoryQuantity[2] = 20;
    }

    // Prize Categories and ticket requirements
    public void getPrize(String item) {
        if(item.equals("1")) {
            if(Test.currentCard.getCurrentTicket() >= 10 && arcadePrizeInventoryQuantity[0] != 0) {
                Test.currentCard.reduceTicket(10);
                System.out.println("\nCongratulations! You have Pikachu Stuffed Toy (Small Size) in you inventory!");
                playerPrizeInventoryQuantity[0] += 1;
                arcadePrizeInventoryQuantity[0] -= 1;
                getWonPrizes();
                getArcadeInventory();
            } else {
                if(Test.currentCard.getCurrentTicket() < 100) System.out.println("You have insufficient ticket to obtain this reward!");
                else if(arcadePrizeInventoryQuantity[0] == 0) System.out.println("This reward is out of stock!");
            }
        }

        if(item.equals("2")) {
            if(Test.currentCard.getCurrentTicket() >= 50 && arcadePrizeInventoryQuantity[1] != 0) {
                Test.currentCard.reduceTicket(50);
                System.out.println("Congratulations! You have Doraemon Stuffed Toy (Medium Size) in you inventory!");
                playerPrizeInventoryQuantity[1] += 1;
                arcadePrizeInventoryQuantity[1] -= 1;
                getWonPrizes();
                getArcadeInventory();
            } else {
                if(Test.currentCard.getCurrentTicket() < 100) System.out.println("You have insufficient ticket to obtain this reward!");
                else if(arcadePrizeInventoryQuantity[1] == 0) System.out.println("This reward is out of stock!");
            }
        }

        if(item.equals("3")) {
            if(Test.currentCard.getCurrentTicket() >= 100 && arcadePrizeInventoryQuantity[2] != 0) {
                Test.currentCard.reduceTicket(100);
                System.out.println("Congratulations! You have Big Charmander Stuffed Toy (Large Size) in you inventory!");
                playerPrizeInventoryQuantity[2] += 1;
                arcadePrizeInventoryQuantity[2] -= 1;
                getWonPrizes();
                getArcadeInventory();
            } else {
                if(Test.currentCard.getCurrentTicket() < 100) System.out.println("You have insufficient ticket to obtain this reward!");
                else if(arcadePrizeInventoryQuantity[2] == 0) System.out.println("This reward is out of stock!");
            }
        }

        if(item.equals("4")) {
            new Test().playArcade();
        }
    }

    // Print player inventory items and its quantity
    public void getWonPrizes() {
        System.out.println("\nYour Inventory: ");
        System.out.println("1) " + playerPrizeInventoryName[0] + " => " + playerPrizeInventoryQuantity[0] + "x");
        System.out.println("2) " + playerPrizeInventoryName[1] + " => " + playerPrizeInventoryQuantity[1] + "x");
        System.out.println("3) " + playerPrizeInventoryName[2] + " => " + playerPrizeInventoryQuantity[2] + "x");
    }

    // Print arcade inventory items and its quantity
    public void getArcadeInventory() {
        System.out.println("\nArcade Inventory: ");
        System.out.println("1) " + playerPrizeInventoryName[0] + " => " + arcadePrizeInventoryQuantity[0] + "x");
        System.out.println("2) " + playerPrizeInventoryName[1] + " => " + arcadePrizeInventoryQuantity[1] + "x");
        System.out.println("3) " + playerPrizeInventoryName[2] + " => " + arcadePrizeInventoryQuantity[2] + "x");
    }
}