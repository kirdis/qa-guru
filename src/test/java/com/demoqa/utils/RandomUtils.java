package com.demoqa.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RandomUtils {

    public static List<String> STATES = new ArrayList<>(Arrays.asList("NCR", "Uttar Pradesh"));
    public static Map<String, ArrayList<String>> CITIES = Map.of(
            "NCR", new ArrayList<>(Arrays.asList("Delhi", "Gurgaon", "Noida")),
            "Uttar Pradesh", new ArrayList<>(Arrays.asList("Agra", "Lucknow", "Merrut")));

    public static String getRandomState() {
        int randomIndex = (int) ( Math.random() * STATES.size() );
        return STATES.get(randomIndex);
    }

    public static String getRandomCity(String state) {
        ArrayList<String> cities = CITIES.get(state);
        int randomIndex = (int) ( Math.random() * cities.size() );
        return cities.get(randomIndex);
    }
}
