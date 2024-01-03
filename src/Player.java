import java.util.Scanner;
public class Player extends Person {

    Scanner input = new Scanner(System.in);

    public Player() {
        super.setName("Player");
    }

    public void makeDecision(Deck deck, Deck discarded) {

        int decision = 0;
        boolean getNum = true;

        while(getNum) {

            try{
                System.out.println("Would you like to 1) Hit or 2) Stand?");
                decision = input.nextInt();
                getNum = false;
            }
            catch (Exception e) {
                System.out.println("Invalid");
                input.next();
            }
        }

        if (decision == 1) {

            this.hit(deck, discarded);

            if (this.getHand().calculatedValue() > 20) {
                return;
            }
            else {
                this.makeDecision(deck, discarded);
            }
        }
        else {
            System.out.println("You stand.");
        }
    }
}
