package com.snakesladders.entity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DieTest {

    @Test
    public void shouldProduceRandonNumberInRange() {
        Die die = new Die();

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(die.roll());
        }

        results.forEach(result -> assertTrue(result > 0 && result < 7));
    }

}
