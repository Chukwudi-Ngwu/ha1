package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.data.Menu;
import htw.berlin.wi.prog2.domain.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleInputParserTest {

    @Test
    @DisplayName("can detect ingredients in text input")
    void ingredientsFromInput() {
        // System under test (SUT)
        SimpleInputParser parser = new SimpleInputParser();

        // Test-Daten
        String input = "Ich hätte gerne einen Ciabatta Burger mit Rindfleisch, Tomatenscheiben und Mayo.";
        Ingredient ciabatta = Menu.base.get(2);
        Ingredient schinken = Menu.protein.get(3);
        Ingredient tomate = Menu.topping.get(5);
        Ingredient sauce = Menu.sauces.get(9);

        List<Ingredient> expected = List.of(ciabatta, schinken, tomate, sauce);
        List<Ingredient> actual = parser.ingredientsFromInput(input);

        assertEquals(expected, actual);
    }
}
