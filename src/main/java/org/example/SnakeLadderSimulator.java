package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SnakeLadderSimulator {
    // Constant for the winning position
    private static final int WINNING_POSITION = 100;
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("simulates a Snake and Ladder Game!\n");

        // Define snakes and ladders
        Map<Integer, Integer> snakes = new HashMap<>();
        Map<Integer, Integer> ladders = new HashMap<>();

        // Snakes: positions where the player slides down
        snakes.put(17, 7);
        snakes.put(54, 34);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(87, 36);
        snakes.put(93, 73);
        snakes.put(95, 75);
        snakes.put(98, 79);

        // Ladders: positions where the player climbs up
        ladders.put(1, 38);
        ladders.put(4, 14);
        ladders.put(9, 31);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(51, 67);
        ladders.put(72, 91);
        ladders.put(80, 99);

        // Player's initial position
        int playerPosition = 0;


        // Play the game until the player reaches the winning position
        while (playerPosition < WINNING_POSITION) {
            System.out.println("\nPlayer's current position: " + playerPosition);

            // Roll the die using RANDOM
            int dieRoll = (int) (Math.random() * 6) + 1; // Generates a number between 1 and 6
            System.out.println("The Player rolls the die to get a number between 1 to 6.");
            System.out.println("Rolled a " + dieRoll);

            // Check for options using RANDOM (0 = No Play, 1 = Ladder, 2 = Snake)
            int option = (int) (Math.random() * 3); // Generates 0, 1, or 2
            switch (option) {
                case 0: // No Play
                    System.out.println("Option: No Play. The player stays in the same position.");
                    break;

                case 1: // Ladder
                    System.out.println("Option: Ladder. The player moves ahead by " + dieRoll + " positions.");
                    playerPosition += dieRoll;

                    // Check for ladders again in the new position
                    if (ladders.containsKey(playerPosition)) {
                        System.out.println("Hooray! Found a ladder! Move up to " + ladders.get(playerPosition));
                        playerPosition = ladders.get(playerPosition);
                    }
                    break;

                case 2: // Snake
                    System.out.println("Option: Snake. The player moves back by " + dieRoll + " positions.");
                    playerPosition -= dieRoll;

                    // Ensure position does not go below 0
                    if (playerPosition < 0) {
                        System.out.println("Oh no! The player has moved below 0! Restarting from 0.");
                        playerPosition = 0;
                    }

                    // Check for snakes again in the new position
                    if (snakes.containsKey(playerPosition)) {
                        System.out.println("Oh no! Bitten by a snake! Slide down to " + snakes.get(playerPosition));
                        playerPosition = snakes.get(playerPosition);
                    }
                    break;
            }

            // Ensure position does not exceed the winning position
            if (playerPosition > WINNING_POSITION) {
                playerPosition -= dieRoll;
                System.out.println("Overshoot! Stay at position " + playerPosition);
            }

            // Check if the player has won
            if (playerPosition == WINNING_POSITION) {
                System.out.println("Congratulations! You've reached the winning position 100!");
            }

        }



    }
}