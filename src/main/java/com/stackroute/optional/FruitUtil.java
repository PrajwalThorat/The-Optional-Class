package com.stackroute.optional;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Utility class for analyzing fruit names in a List
 * Complete the class as per the requirements given in PROBLEM.md
 */
public class FruitUtil {
    public boolean searchFruit(List<String> fruits, String searchFruit)
    {
        if(searchFruit == null || searchFruit.trim().equals("") || fruits == null)
            return false;

        return !fruits.isEmpty() && fruits.contains(searchFruit);
    }

    public Optional<Object> sortFruits(List<String> fruits)
    {
        Optional<List<String>> checkNull = Optional.ofNullable(fruits);
        if(checkNull.isEmpty())
            return Optional.empty();
        else
        {
            List<String> sorted = fruits.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            return Optional.of(sorted);
        }
    }

    public String getFruitByTaste(Map<String, String> fruits, String searchTaste) throws FruitNotFoundException
    {
        if(Optional.ofNullable(fruits).isEmpty() || Optional.ofNullable(searchTaste).isEmpty())
            return null;
        else if(fruits.containsKey(searchTaste))
        {
            for(Map.Entry<String, String> entry : fruits.entrySet())
            {
                if(entry.getKey().equals(searchTaste)) return entry.getValue();
            }
        }

        throw new FruitNotFoundException();

    }

}