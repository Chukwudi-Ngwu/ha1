package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.Burger;
import htw.berlin.wi.prog2.domain.Ingredient;
import java.util.ArrayList;
import java.util.List;

public class PrecomputedBurger implements Burger {
    private final double price;
    private final int calories;
    private final List <Ingredient> ingredients;

    public PrecomputedBurger(double price, int calories, List <Ingredient> ingredients){
        this.price = price;
        this. calories = calories;
        this.ingredients = ingredients;
    }

    @Override
    public double calculatePrice(){
        return this.price;
    }

    @Override
    public int calculateCalories() {
        return this.calories;
    }

    @Override
    public List<String> getIngredientNames() {
        List <String> names = new ArrayList<>();
        for (Ingredient i : ingredients){
            names.add(i.getName());
        }
        return names;
    }
}