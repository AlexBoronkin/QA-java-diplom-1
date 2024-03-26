package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient firstIngredient, secondIngredient, thirdIngredient;

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        assertEquals("Флюоресцентная булка R2-D3", burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        when(firstIngredient.getName()).thenReturn("chili sauce");
        assertEquals("chili sauce", burger.ingredients.get(burger.ingredients.size() - 1).getName());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        burger.removeIngredient(1);

        assertEquals(2, burger.ingredients.size());
        assertNotEquals(secondIngredient, burger.ingredients.get(1));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.moveIngredient(0,1);

        assertEquals(firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        when(bun.getPrice()).thenReturn(55f);
        when(firstIngredient.getPrice()).thenReturn(25f);
        when(secondIngredient.getPrice()).thenReturn(20f);

        assertEquals(155f, burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        when(firstIngredient.getName()).thenReturn("sour cream");
        when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(secondIngredient.getName()).thenReturn("dinosaur");
        when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(burger.getPrice()).thenReturn(200f);

               assertEquals(
                "(==== Флюоресцентная булка R2-D3 ====)\r\n" +
                        "= sauce sour cream =\r\n" +
                        "= filling dinosaur =\r\n" +
                        "(==== Флюоресцентная булка R2-D3 ====)\r\n" +
                        "\r\n" +
                        "Price: 200,000000" + "\r\n",
                burger.getReceipt()

        );

    }

}
