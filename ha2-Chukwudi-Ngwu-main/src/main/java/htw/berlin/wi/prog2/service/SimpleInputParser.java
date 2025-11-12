package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.data.Menu;
import htw.berlin.wi.prog2.domain.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleInputParser {
    public List<Ingredient> ingredientsFromInput(String inputLine) {
        List<Ingredient> result = new ArrayList<>();
        for (Ingredient ing : Menu.getAllArticles().values()) {
            if(inputLine.contains(ing.getName())) result.add(ing);
        }
        return result;
    }
}
