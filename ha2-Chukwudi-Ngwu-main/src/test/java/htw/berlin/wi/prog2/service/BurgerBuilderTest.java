package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.Burger;
import htw.berlin.wi.prog2.domain.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BurgerBuilderTest {

    private final BurgerBuilder builder  = new BurgerBuilder();

    private final Ingredient sauce = new Ingredient("Mayo", 0.01, 2000);
    private final Ingredient broetchen = new Ingredient("Brötchen", 0.02, 1000);

    @Test
    @DisplayName("can build a precomputed burger with two ingredients")
    void buildABurger() {
        Burger burger = builder.add(broetchen).add(sauce).buildPrecomputed();

        assertEquals(List.of("Brötchen", "Mayo"), burger.getIngredientNames());
        assertEquals(0.03, burger.calculatePrice());
        assertEquals(3000, burger.calculateCalories());
    }

    @Test
    @DisplayName("can build two precomputed burgers after another without mixing things up")
    void buildTwoBurgers() {
        Burger burger1 = builder.add(broetchen).add(sauce).buildPrecomputed();
        Burger burger2 = builder.add(broetchen).add(broetchen).buildPrecomputed();

        assertEquals(List.of("Brötchen", "Mayo"), burger1.getIngredientNames());
        assertEquals(List.of("Brötchen", "Brötchen"), burger2.getIngredientNames());
    }

    @Test
    @DisplayName("can build a dynamically computed burger with two ingredients")
    void buildABurgerDynamically() {
        Burger burger = builder.add(broetchen).add(sauce).buildDynamicallyComputed();

        assertEquals(List.of("Brötchen", "Mayo"), burger.getIngredientNames());
        assertEquals(0.03, burger.calculatePrice());
        assertEquals(3000, burger.calculateCalories());
    }

    @Test
    @DisplayName("can build two dynamically computed burgers after another without mixing things up")
    void buildTwoBurgeresDynamically() {
        Burger burger1 = builder.add(broetchen).add(sauce).buildDynamicallyComputed();
        Burger burger2 = builder.add(broetchen).add(broetchen).buildDynamicallyComputed();

        assertEquals(List.of("Brötchen", "Mayo"), burger1.getIngredientNames());
        assertEquals(List.of("Brötchen", "Brötchen"), burger2.getIngredientNames());
    }

    // Diese folgenden Tests sind keine typischen Tests, da sie testen, wie Sie etwas im Detail implementiert haben
    @Test
    @DisplayName("a dynamically computed burger should have only one field, which is the list of ingredients")
    void buildDynamicallyComputed() {
        Burger burger = builder.add(broetchen).add(sauce).buildDynamicallyComputed();

        var clazz = burger.getClass();
        var fields = clazz.getDeclaredFields();
        assertEquals(1, fields.length);
        assertEquals("java.util.List<htw.berlin.wi.prog2.domain.Ingredient>", fields[0].getGenericType().getTypeName());
    }

    @Test
    @DisplayName("a precomputed burger should have three field for the precomputed values")
    void buildPrecomputed() {
        Burger burger = builder.add(broetchen).add(sauce).buildPrecomputed();

        var clazz = burger.getClass();
        var fields = clazz.getDeclaredFields();
        assertEquals(3, fields.length);
        assertTrue(Arrays.stream(fields).map(Field::getType).collect(Collectors.toList()).contains(int.class));
        assertTrue(Arrays.stream(fields).map(Field::getType).collect(Collectors.toList()).contains(double.class));
    }


    // TODO hier mind. einen Test hinzufügen, der das korrekte Werfen der IllegalBurgerException testet (assertThrows)

    @Test
    @DisplayName("a burger needs at least 2 ingredients")
    void buildBurgerWithLessThanTwoIngredients(){
        builder.add(broetchen);
        assertThrows(IllegalBurgerException.class, () -> builder.buildPrecomputed());
        assertThrows(IllegalBurgerException.class, () -> builder.buildDynamicallyComputed());
    }
}
