package htw.berlin.wi.prog2.domain;

import java.util.List;

public class DummyBurgerImpl implements Burger {

    @Override
    public double calculatePrice() {
        return 0.01;
    }

    @Override
    public int calculateCalories() {
        return 10000;
    }

    @Override
    public List<String> getIngredientNames() {
        return List.of("Käse", "Käse", "Käse");
    }
}
