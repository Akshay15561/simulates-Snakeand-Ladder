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

        // Random number generator for die rolls
        Random random = new Random();

        // Play the game until the player reaches the winning position
        while (playerPosition < WINNING_POSITION) {
            // Roll the die using RANDOM
            int dieRoll = (int) (Math.random() * 6) + 1; // Generates a number between 1 and 6
            System.out.println("The Player rolls the die to get a number between 1 to 6.");
            System.out.println("Rolled a " + dieRoll);

            // Move the player
            int newPosition = playerPosition + dieRoll;

            // Check if the new position is within bounds
            if (newPosition > WINNING_POSITION) {
                System.out.println("Overshoot! Stay at position " + playerPosition);
                continue;
            }

            // Check for snakes
            if (snakes.containsKey(newPosition)) {
                System.out.println("Oh no! Bitten by a snake! Slide down to " + snakes.get(newPosition));
                newPosition = snakes.get(newPosition);
            }
            // Check for ladders
            else if (ladders.containsKey(newPosition)) {
                System.out.println("Hooray! Climbed a ladder! Move up to " + ladders.get(newPosition));
                newPosition = ladders.get(newPosition);
            }

            // Update player's position
            playerPosition = newPosition;
            System.out.println("Player's current position: " + playerPosition);

            // Check if the player has won
            if (playerPosition == WINNING_POSITION) {
                System.out.println("Congratulations! You've reached the winning position 100!");
            }

        }



    }
}