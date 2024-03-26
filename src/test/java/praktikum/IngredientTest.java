package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest (IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object [][] ingredientTestData() {
        return new Object[][] {
                {SAUCE, "hot sauce", 20f},
                {FILLING, "sausage", 300f}
        };
    }

    @Test
    public void getPriceTestReturnsTrue() {
        ingredient = new Ingredient(type, name, price);
        assertEquals(type,ingredient.getType());
    }

    @Test
    public void getNameTestReturnsTrue() {
        ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTestReturnsTrue() {
        ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(),0);
    }


}
