package com.kopiyama.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Helper {

    private static Scanner scanner = new Scanner(System.in);
    private static final List<String> validPlacements = Arrays.asList("Garut", "Jakarta", "Bandung", "Bogor", "Bekasi");

    // Method for ensuring non-empty string input
    public static String ensureValidStringInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Please Enter the Input");
            } else {
                return input;
            }
        }
    }

    // Method for ensuring integer input
    public static int ensureValidIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please Input Only Number");
            }
        }
    }

    // Method for ensuring valid placement input
    public static String ensureValidPlacementInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String placement = scanner.nextLine().trim();
            if (validPlacements.contains(placement)) {
                return placement;
            } else {
                System.out.println("Placement Not Listed");
            }
        }
    }

    public static String ensureValidNameInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty() || containsNonCharacter(input)) {
                System.out.println("Please Enter Name Correctly");
            } else {
                return input;
            }
        }
    }

    private static boolean containsNonCharacter(String input) {
        return !input.matches("[a-zA-Z\\s]+");
    }
}
