package algorithms; 
public class Main {

    public static void main(String[] args) {

        String[] types = {"Harten", "Ruiten", "Klaveren", "Pieken"};
        String[] getal = {"Aas", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Boer", "Koningin", "Koning"};
        Card[] allCards = new Card[52];

        int index = 0;

        //Create all cards
        for (String type : types) {
            for (String waarde : getal) {
                allCards[index] = new Card(type, waarde);
                index++;
            }
        }

        //Shuffle cards
        for (int i = allCards.length - 1; i > 1; i--) {
            double random = Math.random() * (allCards.length - 1);
            int j = (int) Math.ceil(random);
            Card tmp = allCards[i];
            allCards[i] = allCards[j];
            allCards[j] = tmp;
        }

        //Create player one and player two
        DoubleEndedQueue<Card> player_one = new DoubleEndedQueue<Card>();
        DoubleEndedQueue<Card> player_two = new DoubleEndedQueue<Card>();

        //Create the styack
        DoubleEndedQueue<Card> stack = new DoubleEndedQueue<Card>();

        //Give them cards
        for (int i = 0; i < 26; i++) {
            player_one.addElementToFront(allCards[i]);
            player_two.addElementToFront(allCards[i + 26]);
        }

        //Test amount of card;
        System.out.println("Player one got: " + player_one.getSize() + " cards");
        System.out.println("Player two got: " + player_two.getSize() + " cards");
        System.out.println();

        //Play the game
        int beurt = 1;
        while (!player_one.isEmpty() && !player_two.isEmpty()) {
            Card player_one_card = player_one.getHead();
            int player_one_value = player_one_card.getValue();
            player_one.removeFront();

            Card player_two_card = player_two.getHead();
            int player_two_value = player_two_card.getValue();
            player_two.removeFront();

            System.out.println("Round: " + beurt);
            System.out.println("Player one drew: " + player_one_card);
            System.out.println("Player two drew: " + player_two_card);

            if (player_one_value > player_two_value) {
                //Add cards to player one
                System.out.println("Player one won!");
                player_one.addElementToBack(player_one_card);
                player_one.addElementToBack(player_two_card);

                if (!stack.isEmpty()) {
                    while(stack.getHead() != null){
                        Card add = stack.getHead();
                        player_one.addElementToBack(add);
                        stack.removeFront();
                    }
                }
                System.out.println("Player one stack size: " + player_one.getSize());
                System.out.println("Player two stack size: " + player_two.getSize());

            }
            else if (player_one_value < player_two_value) {
                //Add cards to player two
                System.out.println("Player two won!");
                player_two.addElementToBack(player_one_card);
                player_two.addElementToBack(player_two_card);

                if (!stack.isEmpty()) {
                    while(stack.getHead() != null){
                        Card add = stack.getHead();
                        player_two.addElementToBack(add);
                        stack.removeFront();
                    }
                }
                System.out.println("Player one stack size: " + player_one.getSize());
                System.out.println("Player two stack size: " + player_two.getSize());

            }
            else {
                //Add cards to stash
                System.out.println("Same value, place on stash!");
                stack.addElementToFront(player_one_card);
                stack.addElementToFront(player_two_card);
                System.out.println("Stack size: " + stack.getSize());
                System.out.println("Player one stack size: " + player_one.getSize());
                System.out.println("Player two stack size: " + player_two.getSize());
            }
            beurt++;
            System.out.println();
        }
    }

}
