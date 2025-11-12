package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.DummyBurgerImpl;
import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.Burger;

import java.util.ArrayList;
import java.util.List;

public class BurgerBuilder {

    private final List <Ingredient> ingredients = new ArrayList<>();

    public BurgerBuilder add(Ingredient ingredient) {
        ingredients.add(ingredient);
        return this; // die Rückgabe von this sollte beibehalten bleiben (siehe Benutzung im BurgerBuilderTest)
    }

    public Burger buildPrecomputed() {

        if (ingredients.size() < 2){
            throw new IllegalBurgerException("Ein Burger muss mindestens 2 Zutaten haben!");
        }
        double totalPrice = 0;
        int totalCalories = 0;

        for (Ingredient i : ingredients) {
            totalPrice += i.getPrice();
            totalCalories += i.getCalories();
        }
        Burger burger = new PrecomputedBurger(totalPrice, totalCalories, new ArrayList<>(ingredients));

        ingredients.clear();
        return burger;
    }

    public Burger buildDynamicallyComputed() {
        if (ingredients.size() < 2){
            throw new IllegalBurgerException("Ein Burger muss mindestens 2 Zutaten haben!");
        }
        Burger burger = new DynamicallyComputedBurger(new ArrayList<>(ingredients));

        ingredients.clear();
        return burger;
    }
}