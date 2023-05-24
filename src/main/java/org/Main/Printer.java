package org.Main;

import java.util.Scanner;

public class Printer {

    public String getAriName() {
        return "Automated Readability Index";
    }

    public String getFkName() {
        return "Flesch–Kincaid readability tests";
    }

    public String getSmogName() {
        return "Simple Measure of Gobbledygook";
    }

    public String getClName() {
        return "Coleman–Liau index";
    }

    /**
     * asks user to enter the text to be processed and returns it as a String
     *
     * @return text to be processed
     */
    public String getUsersText(Scanner sc) {
        System.out.println("Welcome to Readability Score Calculator\n" +
                "Enter the text you want to process:");
        return sc.nextLine();
    }

    /**
     * prints how many words, sentences, characters, syllables and polysyllables have been found
     */
    public void printProperties(double words, double sentences, double characters, double syllables, double polysyllables) {
        System.out.printf("""
                                
                In given text there are:
                Words: %.0f
                Sentences: %.0f
                Characters: %.0f
                Syllables: %.0f
                Polysyllables: %.0f
                %n""", words, sentences, characters, syllables, polysyllables);
    }

    /**
     * asks user to enter what readability score should be calculated. When incorrect score is given, it keeps asking until user provides valid input
     *
     * @return readability score the user wants to print
     */
    public String getScoreToCalculate(Scanner sc) {
        String input;
        do {
            System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
            input = sc.nextLine().toUpperCase();
        } while (!(input.equals("ALL") || input.equals("ARI") || input.equals("FK") || input.equals("SMOG") || input.equals("CL")));

        return input;
    }

    /**
     * unified method for printing readability results
     */
    public void printResult(String nameOfScore, double score, int age) {
        System.out.printf("%s: %.2f (about %d-year-olds).\n", nameOfScore, score, age);
    }

    /**
     * prints an average age of reader who is supposed to read given text
     */
    public void printAvarageAge(double avarageAge) {
        System.out.printf("\nThis text should be understood in average by %.2f-year-olds.\n", avarageAge);
    }
}
