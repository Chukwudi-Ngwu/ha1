package htw.berlin.wi.prog2.domain;

public class Ingredient {
    private final String name;
    private final double price;
    private final int calories;

    public Ingredient(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCalories() {
        return calories;
    }
}