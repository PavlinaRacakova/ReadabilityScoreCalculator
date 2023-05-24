package org.Main;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;


class ScoreCounterTest {

    @Test
    void Should_ReturnCorrectAriScore_When_AtributesAreGiven() {
        //arrange
        ScoreCounter counter = new ScoreCounter();
        double actualResult = 0.0;
        double expectedResult = 7.08;
        double delta = 0.01;
        //act
        actualResult = counter.getAriScore(687, 137, 14);
        //assert
        Assertions.assertEquals(expectedResult, actualResult, delta);
    }

    @Test
    void Should_ReturnCorrectFkScore_When_AtributesAreGiven() {
        //arrange
        ScoreCounter counter = new ScoreCounter();
        double actualResult = 0.0;
        double expectedResult = 6.57;
        double delta = 0.01;
        //act
        actualResult = counter.getFkScore(137, 14, 213);
        //assert
        Assertions.assertEquals(expectedResult, actualResult, delta);
    }

    @Test
    void Should_ReturnCorrectSmogScore_When_AtributesAreGiven() {
        //arrange
        ScoreCounter counter = new ScoreCounter();
        double actualResult = 0.0;
        double expectedResult = 9.42;
        double delta = 0.01;
        //act
        actualResult = counter.getSmogScore(14, 17);
        //assert
        Assertions.assertEquals(expectedResult, actualResult, delta);
    }

    @Test
    void Should_ReturnCorrectClScore_When_AtributesAreGiven() {
        //arrange
        ScoreCounter counter = new ScoreCounter();
        double actualResult = 0.0;
        double expectedResult = 10.66;
        double delta = 0.01;
        //act
        actualResult = counter.getClScore(687, 137, 14);
        //assert
        Assertions.assertEquals(expectedResult, actualResult, delta);
    }

    @Test
    void Should_ReturnAverageAge_If_AgesAreStoredInList() throws IllegalAccessException {
        //arrange
        ScoreCounter counter = new ScoreCounter();
        List<Integer> ages = new ArrayList<>();
        ages.add(10);
        ages.add(20);

        //forces ScoreCounter class change List of ages in order to get tested
        Field[] counterFields = counter.getClass().getDeclaredFields();
        for (Field field : counterFields) {
            if (field.getName().equals("ages")) {
                field.setAccessible(true);
                field.set(counter, ages);
            }
        }

        double actualResult = 0.0;
        double expectedResult = 15.0;

        //act
        actualResult = counter.getAverageAge();

        //assert
        Assertions.assertEquals(expectedResult, actualResult);
    }
}