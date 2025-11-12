package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.Burger;
import htw.berlin.wi.prog2.domain.Ingredient;

import java.util.ArrayList;
import java.util.List;


public class DynamicallyComputedBurger implements Burger {

    private final List<Ingredient> ingredients;

    public DynamicallyComputedBurger(List <Ingredient> ingredients){
        this.ingredients = ingredients;
    }


    @Override
    public double calculatePrice() {
        double sum = 0;
        for(Ingredient i : ingredients){
            sum += i.getPrice();
        }
        return sum;
    }

    @Override
    public int calculateCalories(){
        int sum = 0;
        for(Ingredient i : ingredients){
            sum += i.getCalories();
        }
        return sum;
    }

    @Override
    public List<String> getIngredientNames(){
        List <String> names = new ArrayList<>();
        for(Ingredient i : ingredients){
            names.add(i.getName());
        }
        return names;

    }
}