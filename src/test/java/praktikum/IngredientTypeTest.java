package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void selectSauceFromEnumIsCorrect() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void selectFillingFromEnumIsCorrect() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

}
