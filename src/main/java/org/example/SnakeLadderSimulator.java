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

        // Players' positions
        int player1Position = 0;
        int player2Position = 0;
        int diceRollCount = 0; // To track the number of dice rolls

        boolean isPlayer1Turn = true; // Player 1 starts the game



        // Play the game until the player reaches the winning position
        while (player1Position != WINNING_POSITION && player2Position != WINNING_POSITION) {
            String currentPlayer = isPlayer1Turn ? "Player 1" : "Player 2";
            int currentPosition = isPlayer1Turn ? player1Position : player2Position;

            System.out.println("\n" + currentPlayer + "'s turn. Current position: " + currentPosition);

            // Roll the die using RANDOM
            int dieRoll = (int) (Math.random() * 6) + 1; // Generates a number between 1 and 6
            diceRollCount++;
            System.out.println(currentPlayer + " rolls the die and gets " + dieRoll);

            // Calculate the new position
            int newPosition = currentPosition + dieRoll;

            // Check if the new position exceeds the winning position
            if (newPosition > WINNING_POSITION) {
                System.out.println("Overshoot! Stay at position " + currentPosition);
                if (isPlayer1Turn) player1Position = currentPosition;
                else player2Position = currentPosition;
                isPlayer1Turn = !isPlayer1Turn; // Switch turns
                continue;
            }

            // Check for options using RANDOM (0 = No Play, 1 = Ladder, 2 = Snake)
            int option = (int) (Math.random() * 3); // Generates 0, 1, or 2
            switch (option) {
                case 0: // No Play
                    System.out.println("Option: No Play. " + currentPlayer + " stays in the same position.");
                    break;

                case 1: // Ladder
                    System.out.println("Option: Ladder. " + currentPlayer + " moves ahead by " + dieRoll + " positions.");
                    newPosition += dieRoll;

                    // Check for ladders again in the new position
                    if (ladders.containsKey(newPosition)) {
                        System.out.println("Hooray! " + currentPlayer + " found a ladder! Move up to " + ladders.get(newPosition));
                        newPosition = ladders.get(newPosition);
                    }
                    System.out.println(currentPlayer + " gets another turn!");
                    break;

                case 2: // Snake
                    System.out.println("Option: Snake. " + currentPlayer + " moves back by " + dieRoll + " positions.");
                    newPosition -= dieRoll;

                    // Ensure position does not go below 0
                    if (newPosition < 0) {
                        System.out.println("Oh no! " + currentPlayer + " has moved below 0! Restarting from 0.");
                        newPosition = 0;
                    }

                    // Check for snakes again in the new position
                    if (snakes.containsKey(newPosition)) {
                        System.out.println("Oh no! Bitten by a snake! Slide down to " + snakes.get(newPosition));
                        newPosition = snakes.get(newPosition);
                    }
                    break;
            }

            // Update the player's position
            if (isPlayer1Turn) player1Position = newPosition;
            else player2Position = newPosition;

            // Ensure the position does not go below 0
            if (player1Position < 0) player1Position = 0;
            if (player2Position < 0) player2Position = 0;

            // Report the player's position after the die roll
            System.out.println(currentPlayer + "'s position after the roll: " + newPosition);

            // Switch turns unless the player got a ladder
            if (option != 1) {
                isPlayer1Turn = !isPlayer1Turn;
            }
        }

        // Announce the winner
        if (player1Position == WINNING_POSITION) {
            System.out.println("\nCongratulations! Player 1 wins the game!");
        } else {
            System.out.println("\nCongratulations! Player 2 wins the game!");
        }
        System.out.println("Total dice rolls in the game: " + diceRollCount);
    }

        }



