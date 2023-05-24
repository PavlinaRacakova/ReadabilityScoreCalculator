package org.Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Printer printer = new Printer();
        String text = printer.getUsersText(sc);

        double words = text.split(",?\\s+").length;
        double sentences = text.split("[.?!] ").length;
        double characters = text.replaceAll(" ", "").length();
        double syllables = countSyllables(text.toLowerCase().split(",?\\s+"));
        double polysyllables = polysyllablesCounter;

        printer.printProperties(words, sentences, characters, syllables, polysyllables);
        String scoreToPrint = printer.getScoreToCalculate(sc);
        processScoreToPrint(printer, scoreToPrint, words, sentences, characters, syllables, polysyllables);

        sc.close();

    }

    //process readability score the user picked and prints results to the console using Printer object
    public static void processScoreToPrint(Printer printer, String scoreToPrint, double words, double sentences, double characters, double syllables, double polysyllables) {

        ScoreCounter scoreCounter = new ScoreCounter();

        if (scoreToPrint.equals("ARI") || scoreToPrint.equals("ALL")) {
            printer.printResult(printer.getAriName(), scoreCounter.getAriScore(characters, words, sentences), scoreCounter.getAriAge());
        }

        if (scoreToPrint.equals("FK") || scoreToPrint.equals("ALL")) {
            printer.printResult(printer.getFkName(), scoreCounter.getFkScore(words, sentences, syllables), scoreCounter.getFkAge());
        }

        if (scoreToPrint.equals("SMOG") || scoreToPrint.equals("ALL")) {
            printer.printResult(printer.getSmogName(), scoreCounter.getSmogScore(sentences, polysyllables), scoreCounter.getSmogAge());
        }

        if (scoreToPrint.equals("CL") || scoreToPrint.equals("ALL")) {
            printer.printResult(printer.getClName(), scoreCounter.getClScore(characters, words, sentences), scoreCounter.getClAge());
        }

        if (scoreToPrint.equals("ALL")) {
            printer.printAvarageAge(scoreCounter.getAverageAge());
        }
    }

    //counts all syllables in given word array
    public static double countSyllables(String[] words) {
        double syllabesCounter = 0;

        for (String word : words) {
            double syllabesInWordCounter = 0;
            String[] letters = word.split("");

            for (int i = 0; i < letters.length - 1; i++) {
                if (letters[i].matches("[aeiouy]") && letters[i + 1].matches("[^aeiouy]")) {
                    syllabesInWordCounter++;
                }
            }

            if (syllabesInWordCounter == 0) {
                syllabesInWordCounter = 1;
            }

            if (syllabesInWordCounter > 2) {
                Main.polysyllablesCounter++;
            }

            syllabesCounter += syllabesInWordCounter;
        }

        return syllabesCounter;
    }

    //this variable stores number of polysyllables found while counting syllables
    public static double polysyllablesCounter = 0;

}