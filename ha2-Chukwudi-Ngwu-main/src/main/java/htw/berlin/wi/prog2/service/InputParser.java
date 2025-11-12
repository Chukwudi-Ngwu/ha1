package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.Ingredient;
import java.util.List;

public interface InputParser {
    List <Ingredient> ingredientsFromInput(String inputLine);
}