package org.Main;

import java.util.ArrayList;
import java.util.List;

public class ScoreCounter {

    private final List<Integer> ages = new ArrayList<>();
    private int ariAge;
    private int fkAge;
    private int smogAge;
    private int clAge;

    public int getAriAge() {
        return ariAge;
    }

    public int getFkAge() {
        return fkAge;
    }

    public int getSmogAge() {
        return smogAge;
    }

    public int getClAge() {
        return clAge;
    }

    /**
     * calculates ARI score and sets recommended ARI age
     *
     * @return readability score as double
     */
    public double getAriScore(double characters, double words, double sentences) {
        double score = 4.71 * (characters / words) + 0.5 * (words / sentences) - 21.43;
        ariAge = (int) Math.ceil(score) + 5;
        ages.add(ariAge);
        return score;
    }

    /**
     * calculates FK score and sets recommended FK age
     *
     * @return readability score as double
     */
    public double getFkScore(double words, double sentences, double syllables) {
        double score = 0.39 * (words / sentences) + 11.8 * (syllables / words) - 15.59;
        fkAge = (int) Math.ceil(score) + 5;
        ages.add(fkAge);
        return score;
    }

    /**
     * calculates SMOG score and sets recommended SMOG age
     *
     * @return readability score as double
     */
    public double getSmogScore(double sentences, double polysyllables) {
        double score = 1.043 * Math.sqrt(polysyllables * (30 / sentences)) + 3.1291;
        smogAge = (int) Math.ceil(score) + 5;
        ages.add(smogAge);
        return score;
    }

    /**
     * calculates CL score and sets recommended CL age
     *
     * @return readability score as double
     */
    public double getClScore(double characters, double words, double sentences) {
        double L = (characters / words) * 100;
        double S = (sentences / words) * 100;
        double score = 0.0588 * L - 0.296 * S - 15.8;
        clAge = (int) Math.ceil(score) + 6;
        ages.add(clAge);
        return score;
    }

    /**
     * calculates the average age of reader from all calculated ages
     *
     * @return double representing average age of reader
     */
    public double getAverageAge() {
        double sum = 0;
        for (int i : ages) {
            sum += i;
        }
        return sum / ages.size();
    }
}
